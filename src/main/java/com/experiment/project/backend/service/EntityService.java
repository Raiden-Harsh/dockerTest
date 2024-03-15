package com.experiment.project.backend.service;

import com.experiment.project.backend.model.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface EntityService extends MongoRepository<Entity,Integer> {
}
