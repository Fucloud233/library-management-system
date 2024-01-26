package com.fucloud.controller;

import com.fucloud.mapper.ReaderMapper;
import com.fucloud.pojo.Reader;
import com.fucloud.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReaderController {
    @Autowired
    ReaderMapper readerMapper;

    @GetMapping("reader/list")
    public Result query(Integer id, String name, String phone, Integer roleId, Integer pageNum, Integer pageSize) {
        Reader reader = new Reader(id, name, phone, roleId);

        List<Reader> list = readerMapper.query(reader, pageNum, pageSize);
        return Result.createOk(list);
    }

}
