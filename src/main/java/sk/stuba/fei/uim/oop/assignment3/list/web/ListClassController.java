package sk.stuba.fei.uim.oop.assignment3.list.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListClass;
import sk.stuba.fei.uim.oop.assignment3.list.logic.ListClassService;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.ListClassResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ListClassController {

    @Autowired
    private ListClassService service;

    @PostMapping()
    public ResponseEntity<ListClassResponse> addLendList(){
        return new ResponseEntity<>(new ListClassResponse(this.service.create()), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<ListClassResponse> getLendLists(){
        return this.service.getAll().stream().map(ListClassResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListClassResponse> getLendList(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(new ListClassResponse(this.service.getById(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<ListClassResponse> addBookToList(@PathVariable("id") long listId, @RequestBody BookIdRequest id){
        try {
            ListClass list = this.service.addBook(listId,id);
            return new ResponseEntity<>(new ListClassResponse(list), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(IllegalOperationException f) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}/remove")
    public ResponseEntity<?> removeBookFromList(@PathVariable("id") long listId, @RequestBody BookIdRequest id){
        try {
            this.service.removeBook(listId,id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/lend")
    public ResponseEntity<?> lendList(@PathVariable("id") long listId){
        try {
            this.service.lendBook(listId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(IllegalOperationException f) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeList(@PathVariable("id") long listId){ //<?> je len aby ide nekričal na mne IDE
        try {
            this.service.deleteList(listId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
