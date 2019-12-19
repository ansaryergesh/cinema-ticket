package kz.iitu.jd3.bookrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "book_requests";

    @Autowired
    private KafkaTemplate<String, MovieRequest> kafkaTemplate;

    public String bookRequestNotify(MovieRequest movieRequest) {
        System.out.println(String.format("#### -> Producing book request to notification service -> %s", movieRequest));
        this.kafkaTemplate.send(TOPIC, movieRequest);
        return "Successfully";
    }
}
