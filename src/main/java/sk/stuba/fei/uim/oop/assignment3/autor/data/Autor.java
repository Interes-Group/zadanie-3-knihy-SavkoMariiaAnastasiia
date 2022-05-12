package sk.stuba.fei.uim.oop.assignment3.autor.data;


import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.autor.web.bodies.AutorRequest;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @OneToMany
    private List<Book> books;

    public Autor (AutorRequest request){
        this.name=request.getName();
        this.surname=request.getSurname();
        this.books=new ArrayList<>();
    }
}
