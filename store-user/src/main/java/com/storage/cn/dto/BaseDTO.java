package com.storage.cn.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public abstract class BaseDTO {

    @Setter
    @Getter
    protected Date createdTime;

    @Setter
    @Getter
    protected Date updatedTime;
}
