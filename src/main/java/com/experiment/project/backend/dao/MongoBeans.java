package com.experiment.project.backend.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoBeans {

    protected SimpleMongoClientDatabaseFactory mongodbFactoryCreator() {
        String dbName = "harshdb";
        // port is 8181 because in our container we are exposing
        // container port 27017 to 8181 of our laptop.
        // database name is harshdb
        String connectionString = "mongodb://localhost:8181/harshdb";
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(connectionString)).build();
        MongoClient mongoClient = MongoClients.create(mongoClientSettings);
        return new SimpleMongoClientDatabaseFactory(mongoClient, dbName);
    }

    /*
    * The SimpleMongoClientDatabaseFactory is like the Engine of a Car,
    * The MongoTemplate is the Car itself, and the
    * MongoRepository<Class,Id> is like Uber (you don't have to do anything)
    * */
    @Bean
    public SimpleMongoClientDatabaseFactory databaseFactory() {
        return mongodbFactoryCreator();
    }
}
