package sk.stuba.fei.uim.oop.assignment3.autor.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;
import sk.stuba.fei.uim.oop.assignment3.autor.data.AutorRepository;
import sk.stuba.fei.uim.oop.assignment3.autor.web.bodies.AutorRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

@Service
public class AutorService implements IAutorService{
    @Autowired
    private AutorRepository repository;

    @Override
    public void delete(Long id) throws NotFoundException {
        this.repository.delete(this.getById(id));
    }

    @Override
    public Autor update(Long id, AutorRequest body) throws NotFoundException {
        Autor a=this.getById(id);
        if(body.getName() != null){
            a.setName(body.getName());
        }
        if(body.getSurname() != null){
            a.setSurname(body.getSurname());
        }
        return this.repository.save(a);
    }

    @Override
    public Autor getById(Long Id) throws NotFoundException {
        Autor a = this.repository.findAutorById(Id);
        if(a==null){
            throw new NotFoundException();
        }
        return a;
    }

    @Override
    public List<Autor> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Autor create(AutorRequest body) {
        return this.repository.save(new Autor(body));
    }
}
