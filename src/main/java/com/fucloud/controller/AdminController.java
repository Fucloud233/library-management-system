package com.fucloud.controller;

import com.fucloud.mapper.AdminMapper;
import com.fucloud.pojo.Admin;
import com.fucloud.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;

    @PostMapping("/admin/login")
    public Result login(@RequestBody Map<String, Object> info) {
        return Result.createOk(this.checkPassword(info));
    }

    @PostMapping("/admin")
    public Result create(@RequestBody Admin admin)  {
        adminMapper.insert(admin);
        return Result.createOk(null);
    }


    @DeleteMapping("/admin/{id}")
    public Result deleteById(@PathVariable Integer id) {
        adminMapper.deleteById(id);
        return Result.createOk(null);
    }

    @PutMapping("/admin/password")
    public Result updatePassword(@RequestBody Map<String, Object> info) {
        if(!this.checkPassword(info)) {
            // TODO 处理异常错误
            return Result.createError("密码错误");
        }

        Integer id = (Integer) info.get("id");
        String newPassword = (String) info.get("newPassword");
        adminMapper.updatePassword(id, newPassword);
        return Result.createOk(null);
    }

    @GetMapping("/admin/list")
    public List<Admin> list() {
        return adminMapper.list();
    }

    public boolean checkPassword(Map<String, Object> info) {
        String trueString = adminMapper.getPassword((Integer) info.get("id"));
        return trueString.equals(info.get("password"));
    }
}

