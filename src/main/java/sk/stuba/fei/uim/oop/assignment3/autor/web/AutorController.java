package sk.stuba.fei.uim.oop.assignment3.autor.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.autor.logic.IAutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private IAutorService service;
}
