package com.rent.Payment.Service;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
    public Payment() {
    }

    public Payment(String rentID, String price, String cardNumber, String cvv) {
        this.rentID = rentID;
        this.price = price;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    public String rentID;
    public String price;
    public String cardNumber;
    public String cvv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRentID() {
        return rentID;
    }

    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
