package com.actigence.mongo.secure.domain;

import com.actigence.mongo.secure.Encrypted;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * Created by Anubhav on 11/24/2015.
 */
@Document
public class Person {

    private String id = UUID.randomUUID().toString();

    private String name;

    @Encrypted
    private String phone;

    @Encrypted
    private String cardNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
