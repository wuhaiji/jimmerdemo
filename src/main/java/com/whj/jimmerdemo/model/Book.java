package com.whj.jimmerdemo.model;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.ManyToOne;
import org.jetbrains.annotations.Nullable;

@Entity
public interface Book {
    @ManyToOne
    @Nullable
    BookStore store();
}
