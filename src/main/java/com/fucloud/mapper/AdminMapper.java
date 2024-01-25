package com.fucloud.mapper;

import com.fucloud.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<Admin> list();

    Admin get(Integer id);

    String getPassword(Integer id);

    void updatePassword(String password);

    void insert();

    void deleteById(Integer id);
}
