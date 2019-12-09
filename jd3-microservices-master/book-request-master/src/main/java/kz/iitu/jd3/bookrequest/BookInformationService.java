package kz.iitu.jd3.bookrequest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class BookInformationService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getUserBooksFallback",
            threadPoolKey = "getUserBooks",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            }
    )
    public Book getBookById(String id) {

        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.getEncoder().encodeToString(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);


//        return restTemplate.getForObject(
//                "http://book-info-service/book/info/" + userId,
//                UserBook.class);
        return restTemplate.exchange("http://book-info-service/book/info/detail/" + id,
                HttpMethod.GET, entity, Book.class).getBody();
    }

    public Book getBookByIdFallback(String id) {
        return new Book(id, "Not available", "Not available", "Not available");
    }
}
