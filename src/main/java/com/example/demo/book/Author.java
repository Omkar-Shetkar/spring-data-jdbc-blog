package com.example.demo.book;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("author")
public class Author {
    @Id
    public Long id;
    public String name;
}