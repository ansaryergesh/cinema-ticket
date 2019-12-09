package kz.iitu.jd3.bookinfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/book/info")
public class BookController {


    @GetMapping("/{userId}")
    public UserBook getBooksByUserId(
            @PathVariable("userId") String userId) {

        List<Book> userBookList =  Arrays.asList(
    new Book("1", "Screen 1", "11", "Desc 1"),
    new Book("2", "Screen 2", "12", "Desc 2"));

        UserBook userBook = new UserBook(userBookList);

        return userBook;
    }
    @GetMapping("/detail/{id}")
    public Book getBookById(@PathVariable("id") String id) {

        return new Book(id, id +    " - Marvel", "action", "description");
    }
}
