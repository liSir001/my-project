package com.storage.cn.service.impl;

import com.google.common.collect.Lists;
import com.storage.cn.dao.UserRepository;
import com.storage.cn.dto.UserPageQueryDTO;
import com.storage.cn.dto.UserRequestDTO;
import com.storage.cn.dto.UserResponseDTO;
import com.storage.cn.entity.User;
import com.storage.cn.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * @Auther: Lei Li
 * @Date: 2019/11/9 18:07
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        final String userName = userRequestDTO.getUserName();
        final String password = userRequestDTO.getPassword();
        final String phone = userRequestDTO.getPhone();
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhone(phone);
        User newUser = userRepository.save(user);
        return UserResponseDTO.build(newUser);
    }

    @Override
    public Page<UserPageQueryDTO> pageQueryUser(String userName, Pageable page) {
        Specification<User> specification = (Specification<User>) (root, query, cb) -> {
            List<Predicate> predicates = Lists.newArrayList();
            if (StringUtils.isNotBlank(userName)) {
                Predicate predicate = cb.equal(root.get("userName").as(String.class), userName);
                predicates.add(predicate);
            }
            return cb.and(predicates.toArray(new Predicate[]{}));
        };
        Page<User> userPage = userRepository.findAll(specification, page);
        return userPage.map(UserPageQueryDTO::build);
    }

}
