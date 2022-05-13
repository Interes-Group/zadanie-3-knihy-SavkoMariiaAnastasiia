package sk.stuba.fei.uim.oop.assignment3.list.data;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Getter
@Setter
public class LendList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Book> lendingList;

    private boolean lended;

    public LendList() {
        this.lendingList = new ArrayList<>();
        this.lended = false;
    }

}
