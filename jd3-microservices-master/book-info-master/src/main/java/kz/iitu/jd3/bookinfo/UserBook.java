package kz.iitu.jd3.bookinfo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserBook {

    private List<Book> userBooks;

    public UserBook() {
    }

    public UserBook(List<Book> userBooks) {
        this.userBooks = userBooks;
    }
}
