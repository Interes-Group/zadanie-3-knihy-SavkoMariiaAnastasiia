package sk.stuba.fei.uim.oop.assignment3.autor.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.autor.logic.IAutorService;
import sk.stuba.fei.uim.oop.assignment3.autor.web.bodies.AutorRequest;
import sk.stuba.fei.uim.oop.assignment3.autor.web.bodies.AutorResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private IAutorService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AutorResponse> getAllAutors() {
        return this.service.getAll().stream().map(AutorResponse::new).collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorResponse> addAutor(@RequestBody AutorRequest body) {
        return new ResponseEntity<>(new AutorResponse(this.service.create(body)), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public AutorResponse getAutor(@PathVariable("id") Long id)throws NotFoundException {
        return new AutorResponse(this.service.getById(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public AutorResponse updateProduct(@PathVariable("id") Long productId, @RequestBody AutorRequest body) throws NotFoundException {
        return new AutorResponse(this.service.update(productId, body));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAutor(@PathVariable("id") Long id) throws NotFoundException {
        this.service.delete(id);
    }

}
