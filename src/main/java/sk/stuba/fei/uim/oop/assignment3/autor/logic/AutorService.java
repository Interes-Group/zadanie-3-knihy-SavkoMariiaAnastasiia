package sk.stuba.fei.uim.oop.assignment3.autor.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.autor.data.AutorRepository;

@Service
public class AutorService implements IAutorService{
    @Autowired
    private AutorRepository repository;
}
