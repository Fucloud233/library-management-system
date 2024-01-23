package com.fucloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    Object data;
    Integer code;
    String message;

    public static Result createNewResult(Object data) {
        return new Result(data, 0, "ok");
    }
}
