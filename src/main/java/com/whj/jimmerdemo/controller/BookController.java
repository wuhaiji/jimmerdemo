package com.whj.jimmerdemo.controller;

import com.whj.jimmerdemo.dao.BookStoreRepository;
import com.whj.jimmerdemo.model.AuthorFetcher;
import com.whj.jimmerdemo.model.BookFetcher;
import com.whj.jimmerdemo.model.BookStore;
import com.whj.jimmerdemo.model.BookStoreFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class BookController {

    @Autowired
    BookStoreRepository bookStoreRepository;

    @GetMapping("/book-stores")
    public Object gets(){
        List<BookStore> all = bookStoreRepository.findAll(
                BookStoreFetcher.$
                        .allScalarFields()
                        .books(
                                BookFetcher.$
                                        .allScalarFields()
                                        .authors(
                                                AuthorFetcher.$
                                                        .allScalarFields()
                                        )
                        )
        );
        return all;
    }

}
