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

    @GetMapping("/role")
    public Result read() {
        List<ReaderRole> roleList = readerRoleMapper.list();
        return Result.createNewResult(roleList);
    }

    @PostMapping("/role")
    public Result create(@RequestBody ReaderRole role) {
        // 需要验证条件非空 这里可能会出现空值的情况
        readerRoleMapper.insert(role);
        return Result.createNewResult(null);
    }

    @DeleteMapping("/role/{id}")
    public Result delete(@PathVariable Integer id) {
        readerRoleMapper.deleteById(id);
        return Result.createNewResult(null);
    }

    @PutMapping("/role")
    public Result update(@RequestBody ReaderRole role) {
        readerRoleMapper.update(role);
        return Result.createNewResult(null);
    }

}
