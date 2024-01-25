package com.fucloud.pojo;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private Long isbn;
    private String name;
    private String author;
    // TODO press 出版社信息
    private Double price;
    private Short status;
}
