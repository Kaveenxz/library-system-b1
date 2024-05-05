package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    final BookRepository repository;

    ModelMapper mapper;

    @Bean
    public void setUp(){
        this.mapper = new ModelMapper();
    }
    @Override
    public void addBook(Book book) {
        repository.save(mapper.map(book, BookEntity.class));
    }

    @Override
    public List<BookEntity> getBook() {
        return repository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Book findBookById(Long id) {
        Optional<BookEntity> byId = repository.findAllById(id);
        return mapper.map(byId, Book.class);
    }
}
