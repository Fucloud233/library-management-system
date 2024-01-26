package com.fucloud.controller;

import com.fucloud.mapper.ReaderRoleMapper;
import com.fucloud.pojo.ReaderRole;
import com.fucloud.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReaderRoleController {

    @Autowired
    ReaderRoleMapper readerRoleMapper;

    @GetMapping("/role/list")
    public Result list() {
        List<ReaderRole> roleList = readerRoleMapper.list();
        return Result.createOk(roleList);
    }

    @GetMapping("/role/list/option")
    public Result listOptions() {
        List<ReaderRole> roleList = readerRoleMapper.listOptions();
        return Result.createOk(roleList);
    }

    @PostMapping("/role")
    public Result create(@RequestBody ReaderRole role) {
        // 需要验证条件非空 这里可能会出现空值的情况
        readerRoleMapper.insert(role);
        return Result.createOk(null);
    }

    @DeleteMapping("/role/{id}")
    public Result delete(@PathVariable Integer id) {
        readerRoleMapper.deleteById(id);
        return Result.createOk(null);
    }

    @PutMapping("/role")
    public Result update(@RequestBody ReaderRole role) {
        readerRoleMapper.update(role);
        return Result.createOk(null);
    }

}
