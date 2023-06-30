package com.whj.jimmerdemo.dao;

import com.whj.jimmerdemo.model.BookStore;
import org.babyfish.jimmer.spring.repository.JRepository;

public interface BookStoreRepository extends JRepository<BookStore, Long> {
    
}
