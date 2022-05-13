package sk.stuba.fei.uim.oop.assignment3.list.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.autor.web.bodies.AutorRequest;
import sk.stuba.fei.uim.oop.assignment3.autor.web.bodies.AutorResponse;
import sk.stuba.fei.uim.oop.assignment3.list.logic.IListClassService;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.ListClassResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ListClassController {

    @Autowired
    private IListClassService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListClassResponse> getAllList() {
        return this.service.getAll().stream().map(ListClassResponse::new).collect(Collectors.toList());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListClassResponse> addList() {
        return new ResponseEntity<>(new ListClassResponse(this.service.create()), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListClassResponse> getAllList() {
        return this.service.getAll().stream().map(ListClassResponse::new).collect(Collectors.toList());
    }
}
