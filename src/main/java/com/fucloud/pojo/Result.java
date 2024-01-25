package com.fucloud.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object data;
    Integer code;
    String message;

    public static Result createOk(Object data) {
        return new Result(data, 0, "ok");
    }

    public static Result createError(Object data) {
        return new Result(data, 1, "error");
    }
}
