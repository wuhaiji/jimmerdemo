package com.whj.jimmerdemo.dao;

import com.whj.jimmerdemo.model.Author;
import org.babyfish.jimmer.spring.repository.JRepository;

public interface AuthorRepository extends JRepository<Author, Long> {
    
}
