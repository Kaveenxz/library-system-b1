package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin
@RequiredArgsConstructor
public class BookController {

    final BookService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
         service.addBook(book);
    }

    @GetMapping()
    public Iterable<BookEntity> getBook(){
        return service.getBook();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
       return service.deleteBook(id) ?
               ResponseEntity.ok("Deleted") :
               ResponseEntity.ok("Not deleted");
    }

    @GetMapping("/search/{id}")
    public Book findBookById(@PathVariable Long id){
        return service.findBookById(id);
    }
}
