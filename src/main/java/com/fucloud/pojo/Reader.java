package com.fucloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    private Integer id;
    private String name;
    private String phone;

//    private Integer roleId;
    private ReaderRole role;

    public Reader(Integer id, String name, String phone, Integer roleId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.role = new ReaderRole();
        this.role.setId(roleId);
    }
}

