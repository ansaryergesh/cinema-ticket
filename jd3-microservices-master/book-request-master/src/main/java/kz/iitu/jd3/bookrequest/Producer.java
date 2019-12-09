package kz.iitu.jd3.bookrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "book_requests";

    @Autowired
    private KafkaTemplate<String, BookRequest> kafkaTemplate;

    public String bookRequestNotify(BookRequest bookRequest) {
        System.out.println(String.format("#### -> Producing book request to notification service -> %s", bookRequest));
        this.kafkaTemplate.send(TOPIC, bookRequest);
        return "Successfully";
    }
}