package sk.stuba.fei.uim.oop.assignment3.list.data;


import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class ListClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private java.util.List<Book> lendingList;
    private Boolean lended;
}
