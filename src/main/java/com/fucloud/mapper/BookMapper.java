package com.fucloud.mapper;

import com.fucloud.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> list();

    Book getById();

//    void update(Book book);

    void updateStatus(Integer id, Integer status);

    void insert(Book book);

    void deleteById(Integer id);

}
