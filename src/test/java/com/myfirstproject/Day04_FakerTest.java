package com.myfirstproject;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class Day04_FakerTest extends TestBase {

    /*
    We use Java Faker class to create fake data for our test cases.
    It creates random and fake data
     */
    @Test
    public void fakerTest(){
        Faker faker = new Faker();
//        first name
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);
//        last name
        System.out.println("lastName = " + faker.name().lastName());
//        full name
        System.out.println("fullName = " + faker.name().fullName());
//        funny name
        System.out.println("faker.funnyName().name() = " + faker.funnyName().name());
//        title
        System.out.println("faker.name().title() = " + faker.name().title());
//        address
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
//        street
        System.out.println("faker.address().streetName() = " + faker.address().streetName());
//        state
        System.out.println("faker.address().state() = " + faker.address().state());
//        phone
        System.out.println("faker.phoneNumber().cellPhone() = " + faker.phoneNumber().cellPhone());
//        random numbers
        System.out.println("faker.number().randomDigit() = " + faker.number().randomDigit());
//        email
        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());
//        password
        System.out.println("faker.internet().password() = " + faker.internet().password());


    }




















}
