package com.fucloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReaderRole {
    private Integer id;
    private String name;
    private Integer number;
    private Integer duration;

    public ReaderRole(String name, Integer number, Integer duration) {
        this.name = name;
        this.number = number;
        this.duration = duration;
    }
}
