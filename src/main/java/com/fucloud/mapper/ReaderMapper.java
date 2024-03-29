package com.fucloud.mapper;

import com.fucloud.pojo.Reader;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReaderMapper {
    void insert(Reader reader);

    void update(Reader reader);

    Integer count();

    Integer countWithCondition(Reader reader);

    List<Reader> list();

    List<Reader> query(Reader reader, Integer pageNum, Integer pageSize);
}
