package com.rent.Payment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pay")
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping
    public String getStr(){
        return "It's Payment page";
    }


    @GetMapping("/all")
    public List<Payment> allPayment(){
        return paymentRepository.findAll();
    }
    @PostMapping("/add")
    public Payment createPay(@Valid @RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }
    @GetMapping("/payments/{id}")
    public Payment getPaymentById(@PathVariable(value = "id") Long gameID)
            throws ResourceNotFoundException {
        Payment payment= paymentRepository.findById(gameID)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id :: " + gameID));
        return payment;
    }
    @PutMapping("/payments/{id}")
    public ResponseEntity<Payment> updateRent(@PathVariable(value = "id") Long gameID,
                                           @Valid @RequestBody Payment paymentDetails) throws ResourceNotFoundException {
        Payment payment = paymentRepository.findById(gameID)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id :: " + gameID));

        payment.setRentID(paymentDetails.getRentID());
        payment.setPrice(paymentDetails.getPrice());
        payment.setCardNumber(paymentDetails.getCardNumber());
        payment.setCvv(paymentDetails.getCvv());
        final Payment updatedRent = paymentRepository.save(payment);
        return ResponseEntity.ok(updatedRent);
    }

    @DeleteMapping("/payments/{id}")
    public Map<String, Boolean> deleteGame(@PathVariable(value = "id") Long paymentID)
            throws ResourceNotFoundException {
        Payment payment = paymentRepository.findById(paymentID)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id :: " + paymentID));

        paymentRepository.delete(payment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
