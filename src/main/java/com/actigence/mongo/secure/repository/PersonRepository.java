package com.actigence.mongo.secure.repository;

import com.actigence.mongo.secure.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Anubhav on 11/24/2015.
 */
public interface PersonRepository extends MongoRepository<Person, String> {
}
