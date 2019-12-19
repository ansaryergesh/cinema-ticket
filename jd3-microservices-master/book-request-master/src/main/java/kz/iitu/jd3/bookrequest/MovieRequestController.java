package kz.iitu.jd3.bookrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/book/request")
public class MovieRequestController {

    private final Producer producer;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public MovieRequestController(Producer producer) {
        this.producer = producer;
    }

    // TODO Ideally there should POST request
    @GetMapping
    public Movie sendMessageToKafkaTopic2(@RequestParam("id") String id) {
        Movie  movie = restTemplate.getForObject(
                "http://localhost:8081/api/movie/"+id,
                Movie.class);

        MovieRequest movieRequest = new MovieRequest("1", movie);
        this.producer.movieRequestNotify(movieRequest);
        return movie;
    }
}
