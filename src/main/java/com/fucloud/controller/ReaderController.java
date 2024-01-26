package com.fucloud.controller;

import com.fucloud.mapper.ReaderMapper;
import com.fucloud.pojo.Reader;
import com.fucloud.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReaderController {
    @Autowired
    ReaderMapper readerMapper;

    @GetMapping("reader/list")
    public Result query(Integer id, String name, String phone, Integer roleId, Integer pageNum, Integer pageSize) {
        if(pageNum == null || pageNum < 0) {
            pageNum = 0;
        } else {
            pageNum = pageSize * pageNum;
        }
        if(pageSize == null || pageSize < 1) {
            pageSize = 5;
        }

        Map<String, Object> result = new HashMap<>();

        Reader reader = new Reader(id, name, phone, roleId);
        List<Reader> list = readerMapper.query(reader, pageNum, pageSize);
        Integer length = readerMapper.countWithCondition(reader);

        result.put("list", list);
        result.put("length", length);

        return Result.createOk(result);
    }

}
