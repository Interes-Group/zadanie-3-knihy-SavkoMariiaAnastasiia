package sk.stuba.fei.uim.oop.assignment3.book.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.logic.IBookService;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService service;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookResponse> getAllBooks() {
        return this.service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest body) {
        return new ResponseEntity<>(new BookResponse(this.service.create(body)), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public BookResponse getAutor(@PathVariable("id") Long id)throws NotFoundException {
        return new BookResponse(this.service.getById(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookResponse updateBook(@PathVariable("id") Long bookId, @RequestBody BookRequest body) throws NotFoundException {
        return new BookResponse(this.service.update(bookId, body));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable("id") Long id) throws NotFoundException {
        this.service.delete(id);
    }

    @GetMapping(value = "/{id}/amount",produces = MediaType.APPLICATION_JSON_VALUE)
    public BookAmount getAmount(@PathVariable("id") Long id) throws NotFoundException {
        return new BookAmount(this.service.getBookAmount(id));
    }

    @PostMapping(value = "/{id}/amount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookAmount addAmount(@PathVariable("id") Long productId, @RequestBody BookAmount body) throws NotFoundException {
        return new BookAmount(this.service.addAmount(productId, body.getAmount()));
    }
}
