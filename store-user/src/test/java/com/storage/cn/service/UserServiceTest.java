package com.storage.cn.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testFindUserByUserNameAndPassword() {
        String userName = "admin";
        String password = "1234";
        Boolean success = userService.findUserByUserNameAndPassword(userName, password);
        System.out.println("success = " + success);
    }
}