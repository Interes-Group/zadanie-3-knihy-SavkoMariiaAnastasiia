package sk.stuba.fei.uim.oop.assignment3.autor.web.bodies;


import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.autor.data.Autor;

@Getter
public class AutorResponse {

    private final long id;
    private final String name;
    private final String surname;
    private final long books;

    public AutorResponse(Autor a) {
        this.id = a.getId();
        this.name = a.getName();
        this.surname = a.getSurname();
        this.books = a.getBooks();
    }
}
