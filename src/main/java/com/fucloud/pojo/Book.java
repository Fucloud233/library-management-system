package com.fucloud.pojo;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private Long isbn;
    private String name;
    private String author;
    private Double price;
    private Short status;
}
