package kz.iitu.jd3.bookrequest;

import lombok.Getter;
import lombok.Setter;

public class BookRequest {

    private String userId;
    private Book book;

    public BookRequest() {
    }

    public BookRequest(String userId, Book book) {
        this.userId = userId;
        this.book = book;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "userId='" + userId + '\'' +
                ", book=" + book +
                '}';
    }
}
