package com.fucloud.controller;

import com.fucloud.mapper.AdminMapper;
import com.fucloud.pojo.Admin;
import com.fucloud.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;

    @PostMapping("/admin/login")
    public Result login(@RequestBody Map<String, Object> info) {
        Integer id = (Integer) info.get("id");
        String password = (String) info.get("password");

        Map<String, Object> result = new HashMap<>();
        boolean flag = this.checkPassword(id, password);
        result.put("flag", flag);
        if(flag) {
            Admin adminInfo = adminMapper.getById(id);
            result.put("info", adminInfo);
        }

        return Result.createOk(result);
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
        Integer id = (Integer) info.get("id");
        String password = (String) info.get("password");
        if(!this.checkPassword(id, password)) {
            // TODO 处理异常错误
            return Result.createError("密码错误");
        }

        String newPassword = (String) info.get("newPassword");
        adminMapper.updatePassword(id, newPassword);
        return Result.createOk(null);
    }

    @GetMapping("/admin/list")
    public List<Admin> list() {
        return adminMapper.list();
    }

    public boolean checkPassword(Integer id, String password) {
        String truePassword = adminMapper.getPassword(id);
        if(truePassword == null) {
            return false;
        }

        return truePassword.equals(password);
    }
}

