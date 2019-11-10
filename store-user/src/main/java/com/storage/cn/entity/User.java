package com.storage.cn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * 用户实体类
 * @Auther: Lei Li
 * @Date: 2019/11/9 18:08
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store_user")
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String password;

    @Column
    private String phone;

    @Column
    private String email;
}
