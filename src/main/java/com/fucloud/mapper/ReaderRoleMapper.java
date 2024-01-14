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
    // TODO 根据id搜索ReaderRole
//    ReaderRole getById(Integer id);
}
