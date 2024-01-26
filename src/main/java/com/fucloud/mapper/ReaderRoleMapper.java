package com.fucloud.mapper;

import com.fucloud.pojo.ReaderRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReaderRoleMapper {
    void insert(ReaderRole role);
    void deleteById(Integer id);
    void update(ReaderRole role);

    List<ReaderRole> list();
    List<ReaderRole> listOptions();
    ReaderRole getById(Integer id);
}
