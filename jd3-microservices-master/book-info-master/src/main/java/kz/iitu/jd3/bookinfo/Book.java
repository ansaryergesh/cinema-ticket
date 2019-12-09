package kz.iitu.jd3.bookinfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    public Book() {
    }

    public Book(String id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    private String id;
    private String title;
    private String author;
    private String description;
}
