package com.fucloud;

import com.fucloud.mapper.ReaderRoleMapper;
import com.fucloud.pojo.ReaderRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import java.util.List;


@SpringBootTest()
public class ReaderRoleMapperTest {

    @Autowired
    ReaderRoleMapper readerRoleMapper;

    @Test
    void testReaderRole() {
        ReaderRole role = new ReaderRole("教师", 20 ,60);

        try {
            readerRoleMapper.insert(role);
        } catch (DataAccessException e) {
            // ref: https://blog.csdn.net/qq_44766592/article/details/106033695
            System.out.println("类型重复");
        }

        List<ReaderRole> list = readerRoleMapper.list();
        list.forEach(System.out::println);
        ReaderRole studentRole = new ReaderRole("学生", 30 ,60);
        try {
            // 数据在insert之后会自动加载在ReaderRole对象内
            readerRoleMapper.insert(studentRole);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        studentRole.setDuration(30);
        readerRoleMapper.update(studentRole);
        System.out.println(studentRole);
        readerRoleMapper.deleteById(studentRole.getId());
    }

    @Test
    void testGetById() {
        int id = 6;
        System.out.println(readerRoleMapper.getById(id));
    }

}
