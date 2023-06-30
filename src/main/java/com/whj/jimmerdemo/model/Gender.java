package com.whj.jimmerdemo.model;

import org.babyfish.jimmer.sql.EnumItem;

public enum Gender {
    @EnumItem(name = "M")
    MALE,
    @EnumItem(name = "F")
    FEMALE
    ;
}
