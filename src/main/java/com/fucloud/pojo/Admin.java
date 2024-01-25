package com.fucloud.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Admin {
    private Integer id;
    private String name;
    private String phone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    private Short privilege;
}
