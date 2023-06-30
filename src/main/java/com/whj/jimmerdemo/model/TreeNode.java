package com.whj.jimmerdemo.model;

import org.babyfish.jimmer.sql.*;

@Entity
public interface TreeNode {

    @Id
    @Column(name = "NODE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    String name();
}