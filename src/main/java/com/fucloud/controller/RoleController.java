package com.fucloud.controller;

import com.fucloud.pojo.ReaderRole;
import com.fucloud.pojo.Result;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {
    @GetMapping("/role")
    public Result read() {
        return null;
    }

    @PostMapping("/role")
    public Result create(ReaderRole role) {
        return null;
    }

    @DeleteMapping("/role")
    public Result delete(Integer id) {
        return null;
    }

    @PutMapping("/role")
    public Result update(ReaderRole role) {
        return null;
    }
}
