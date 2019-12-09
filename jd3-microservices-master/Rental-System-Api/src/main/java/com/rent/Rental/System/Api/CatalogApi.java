package com.rent.Rental.System.Api;

import com.rent.Rental.System.Api.Models.Movie;
import com.rent.Rental.System.Api.Models.Payment;
import com.rent.Rental.System.Api.Services.MovieInfoService;
import com.rent.Rental.System.Api.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class CatalogApi {
    @Autowired
    MovieInfoService movieInfoService;

    @Autowired
    PaymentService paymentService;
    @GetMapping
    public String getStr() {
        return "It's working hystrix page";
    }

    @GetMapping("/all")
    public List<Movie> getAllGames() {
        return movieInfoService.getAllMovies();
    }
    @GetMapping("movie/{id}")
    public Movie getMovies(@PathVariable Long id) {
        return movieInfoService.getMovies(id);
    }
    @PostMapping("/add/movie")
    public Movie createNote(@Valid @RequestBody Movie movie) {
        return movieInfoService.createNote(movie);

    }
    @PutMapping("/update/movie/{id}")
    public Movie updateGame(@PathVariable(value = "id") String movieID,
                            @Valid @RequestBody Movie movieDetails) {
        return movieInfoService.updateMovie(movieID,  movieDetails);
    }

    @DeleteMapping("/movie/{id}")
    public Boolean delete(@PathVariable String id) {
        return movieInfoService.delete(id);
    }

    @GetMapping("pay/all")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
    @GetMapping("pay/{id}")
    public Payment getPayment(@PathVariable Long id) {

        return paymentService.getPayment(id);
    }
    @PostMapping("/add/pay")
    public Payment createNote(@Valid @RequestBody Payment payment) {
        return paymentService.createNote(payment);
    }
    @PutMapping("/update/pay/{id}")
    public Payment updateGame(@PathVariable(value = "id") String payID,
                              @Valid @RequestBody Payment paymentDetails){
        return paymentService.updatePayment(payID,paymentDetails);
    }

    @DeleteMapping("/pay/{id}")
    public Boolean deletee(@PathVariable String id) {
        return paymentService.delete(id);
    }

//    @GetMapping("/{id}")
//    public List<RentalCatalog> getAllGames(
//            @PathVariable Long id) {
//        Game  game = restTemplate.getForObject(
//                "http://localhost:8082/game/games/"+id,
//                Game.class);
//
//        List<RentalCatalog> gameCatalogList = new ArrayList<>();
//
//       // for (Game game : userGame.getUserGames()) {
//            Rent gameRent = restTemplate.getForObject(
//                    "http://localhost:8083/rent/rents/" +game.getId() ,
//                    Rent.class);
//            Payment gamePayment = restTemplate.getForObject(
//                    "http://localhost:8084/pay/payments/"+game.getId(),
//                    Payment.class);
//
//            gameCatalogList.add(new RentalCatalog(game.getId(),gameRent.getUserID(),gameRent.price,gamePayment.cardNumber
//                    ));
//     //   }
//
//        return gameCatalogList;
//    }
//
//    @GetMapping("/catalog/all")
//    public List<RentalCatalog> getAllCatalog() {
//        Game  game = restTemplate.getForObject(
//                "http://localhost:8082/game/all/",
//                Game.class);
//
//        List<RentalCatalog> gameCatalogList = new ArrayList<>();
//
//        // for (Game game : userGame.getUserGames()) {
//        Rent gameRent = restTemplate.getForObject(
//                "http://localhost:8083/rent/rents/" +game.getId() ,
//                Rent.class);
//        Payment gamePayment = restTemplate.getForObject(
//                "http://localhost:8084/pay/payments/"+game.getId(),
//                Payment.class);
//
//        gameCatalogList.add(new RentalCatalog(game.getId(),gameRent.getUserID(),gameRent.price,gamePayment.cardNumber
//        ));
//        //   }
//
//        return gameCatalogList;
//    }

}
