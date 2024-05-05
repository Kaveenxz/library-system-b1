package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    final private BookRepository repository;

    ModelMapper mapper;

    @Bean
    public void setUp(){
        this.mapper = new ModelMapper();
    }
    @Override
    public void addBook(Book book) {
        repository.save(mapper.map(book, BookEntity.class));
    }
}
