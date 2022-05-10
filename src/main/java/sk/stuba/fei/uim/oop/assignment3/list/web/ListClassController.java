package sk.stuba.fei.uim.oop.assignment3.list.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.list.logic.IListClassService;

@RestController
@RequestMapping("/list")
public class ListClassController {

    @Autowired
    private IListClassService service;
}
