package com.rent.Rental.System.Api.Services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rent.Rental.System.Api.Models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    private RestTemplate restTemplate;
    //------------------------— Games —-------------------------—
//------------------------— All —-------------------------—
    @HystrixCommand(fallbackMethod = "getAllPayments_Fallback")
    public List<Payment> getAllPayments() {
        ResponseEntity<List<Payment>> rateResponse =
                restTemplate.exchange("http://localhost:8084/pay/all",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Payment>>() {
        });
        List<Payment> rates = rateResponse.getBody();
        return rates;
    }
    @SuppressWarnings("unused")
    private List<Payment> getAllPayments_Fallback() {

        System.out.println("Payment Service is down!!! fallback route enabled...");
        List<Payment> list = Arrays.asList(
                new Payment("Not available","Not available","Not available","Not available"));
        return list;
// return "CIRCUIT BREAKER ENABLED!!! No Response From Game Service at this moment. " +
// " Service will be back shortly - " + new Date();
    }
    //------------------------— Game by id —-------------------------—
    @HystrixCommand(fallbackMethod = "getPayment_Fallback")
    public Payment getPayment(Long id) {
        Payment payment = restTemplate.getForObject(
                "http://localhost:8084/pay/payments/"+id,
                Payment.class);
        return payment;
    }
    @SuppressWarnings("unused")
    private Payment getPayment_Fallback(Long id) {

        System.out.println("Payment Service is down!!! fallback route enabled...");
        Payment list=new Payment("Not available","Not available","Not available","Not available");
        return list;
    }
//------------------------— Game by user id —-------------------------—

    //------------------------— Add game —-------------------------—
    @HystrixCommand(fallbackMethod = "addPayment_Fallback")
    public Payment createNote(Payment payment) {
        return restTemplate.postForObject("http://localhost:8084/pay/add",
                payment, Payment.class);
    }

    @SuppressWarnings("unused")
    public Payment addPayment_Fallback(Payment payment) {
        System.out.println("Payment Service is down!!! fallback route enabled...");
        Payment list = payment;
        return list;
    }
    //------------------------— Delete game —-------------------------—
    @HystrixCommand(fallbackMethod = "deletePayment_Fallback")
    public Boolean delete(String id) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8084/pay/payments/"+id, params);
        return true;
    }

    @SuppressWarnings("unused")
    public Boolean deletePayment_Fallback(String id) {
        return false;
    }
    //------------------------— Delete game —-------------------------—
    @HystrixCommand(fallbackMethod = "updatePayment_Fallback")
    public Payment updatePayment(String payID,Payment paymentDetails) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("id", payID);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8084/pay/payments/"+payID, paymentDetails, params);
        return paymentDetails;
    }
    @SuppressWarnings("unused")
    public Payment updatePayment_Fallback(String payID,Payment paymentDetails) {
        System.out.println("Game Service is down!!! fallback route enabled...");
        return new Payment("Not available","Not available","Not available","Not available");
    }

}
