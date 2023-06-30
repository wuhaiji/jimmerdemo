package com.whj.jimmerdemo.model;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Entity
public interface BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    String name();

    @Nullable
    String website();

    // 这里，@ManyToOne(mappedBy = "store")，指当前属性BookStore.books是Book.store的镜像。
    // 关联注解具备mappedBy的属性（这里的BookStore.books），叫做镜像属性。
    // 镜像属性是可选的，因此，双向关联不是必须的。
    @OneToMany(mappedBy = "store")
    List<Book> books();
}
