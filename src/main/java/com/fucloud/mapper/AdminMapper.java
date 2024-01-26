package com.fucloud.mapper;

import com.fucloud.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<Admin> list();

    Admin getById(Integer id);

    String getPassword(Integer id);

    void updatePassword(Integer id, String password);

    void insert(Admin admin);

    void deleteById(Integer id);
}
