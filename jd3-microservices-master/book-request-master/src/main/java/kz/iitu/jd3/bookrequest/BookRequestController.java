package kz.iitu.jd3.bookrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/request")
public class BookRequestController {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;
    private final Producer producer;

    @Autowired
    public BookRequestController(Producer producer) {
        this.producer = producer;
    }

    // TODO Ideally there should POST request
    @GetMapping("/{id}")
    public Movie sendMessageToKafkaTopic2(@PathVariable(value = "id") Long id) {
        Movie  movie = restTemplate.getForObject(
                "http://localhost:8082/movie/movies/"+id,
                Movie.class);

        MovieRequest movieRequest = new MovieRequest("1", movie);
        this.producer.bookRequestNotify(movieRequest);
        return movie;
    }
}
//new Movie(-1L,"","","","","",100,"")
