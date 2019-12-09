package kz.iitu.jd3.notifyservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {


    @KafkaListener(topics = "book_requests", groupId = "group_id")
    public void consume(BookRequest bookRequest) throws IOException {
        System.out.println(String.format("#### -> Notify user by email: -> %s",
                "User " + bookRequest.getUserId() + " purchased book "
                        + bookRequest.getBook().toString()));
    }
}