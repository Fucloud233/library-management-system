package com.fucloud.pojo;

import lombok.Data;

@Data
public class Admin {
    private Integer id;
    private String name;
    private String phone;
    private String password;
    private Short privilege;
}
