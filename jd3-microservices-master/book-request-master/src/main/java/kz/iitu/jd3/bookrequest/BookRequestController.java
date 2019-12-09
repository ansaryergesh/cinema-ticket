package kz.iitu.jd3.bookrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book/request")
public class BookRequestController {

    private final Producer producer;
    private BookInformationService bookInformationService;

    @Autowired
    public BookRequestController(Producer producer, BookInformationService bookInformationService) {
        this.producer = producer;
        this.bookInformationService = bookInformationService;
    }

    // TODO Ideally there should POST request
    @GetMapping
    public String sendMessageToKafkaTopic2(@RequestParam("userId") String userId,
                                           @RequestParam("bookId") String bookId) {

        BookRequest bookRequest = new BookRequest(userId, bookInformationService.getBookById(bookId));
        this.producer.bookRequestNotify(bookRequest);
        return "Your request sent successful!";
    }
}