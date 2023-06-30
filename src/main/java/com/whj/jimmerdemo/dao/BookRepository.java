package com.whj.jimmerdemo.dao;

import com.whj.jimmerdemo.model.Book;
import org.babyfish.jimmer.spring.repository.JRepository;

public interface BookRepository extends JRepository<Book, Long> {

}
