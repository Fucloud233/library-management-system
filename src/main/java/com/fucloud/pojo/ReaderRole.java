package com.fucloud.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReaderRole {
    private Integer id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer number;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer duration;

    public ReaderRole(String name, Integer number, Integer duration) {
        this.name = name;
        this.number = number;
        this.duration = duration;
    }
}
