package org.example.service;

import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    void addBook(Book book);

    List<BookEntity> getBook();
}
