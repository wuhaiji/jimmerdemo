package com.whj.jimmerdemo.model;

import org.babyfish.jimmer.sql.*;

@Entity
public interface Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    String firstName();

    String lastName();

    /*
     * 这里，Gender是一个枚举，代码稍后给出
     */
    Gender gender();
}