package com.online.event.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.online.event.model.Event;



public interface EventCreationRepository extends MongoRepository<Event, String> {


}