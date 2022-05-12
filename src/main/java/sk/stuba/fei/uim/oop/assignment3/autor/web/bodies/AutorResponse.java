package sk.stuba.fei.uim.oop.assignment3.autor.web.bodies;


import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AutorResponse {

    private final long id;
    private final String name;
    private final String surname;
    private final List<Long> books;

    public AutorResponse(Autor a) {
        this.id = a.getId();
        this.name = a.getName();
        this.surname = a.getSurname();
        this.books = a.getBooks().stream().map(book -> book.getId()).collect(Collectors.toList());
    }
}
