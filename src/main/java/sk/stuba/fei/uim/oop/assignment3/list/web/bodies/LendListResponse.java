package sk.stuba.fei.uim.oop.assignment3.list.web.bodies;


import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.list.data.LendList;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LendListResponse {
    private final long id;

    private final List<BookResponse> lendingList;

    private final boolean lended;

    public LendListResponse(LendList list){
        this.id = list.getId();
        List<BookResponse> result = new ArrayList<>();
        for (Book books : list.getLendingList()) {
            BookResponse booksResponse = new BookResponse(books);
            result.add(booksResponse);
        }
        this.lendingList = result;
        this.lended = list.isLended();
    }

}