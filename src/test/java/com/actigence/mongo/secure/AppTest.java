package com.actigence.mongo.secure;

import com.actigence.Application;
import com.actigence.mongo.secure.domain.Person;
import com.actigence.mongo.secure.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class AppTest {

    public static final String CARD_NUMBER = "4536-8795-9876-0000";
    public static final String NAME = "Michael Smith";
    public static final String PHONE = "98333-3939";
    @Inject
    private PersonRepository personRepository;

    @Test
    public void executeTest(){
        Person person = new Person();
        person.setCardNumber(CARD_NUMBER);
        person.setName(NAME);
        person.setPhone(PHONE);
        personRepository.save(person);

        List<Person> personList = personRepository.findAll();
        System.out.println("Obtained person list : " + personList);
    }
}
