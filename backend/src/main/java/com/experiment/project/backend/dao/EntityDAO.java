package com.experiment.project.backend.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityDAO {

    @Autowired
    @Qualifier("databaseFactory")
    SimpleMongoClientDatabaseFactory mongoFactory;

    // this will show how the docs are getting mapped into our object
    public List<Document> showDocumentsInJSON() {
        List<Document> jsonList = new ArrayList<>();
        try (MongoCursor<Document> cursor = getCollection().find().cursor()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                jsonList.add(doc);
            }
        }
        return jsonList;
    }


    public MongoCollection<Document> getCollection() {
        // since we are using only the "harshdb"
        return mongoFactory.getMongoDatabase().getCollection("harshdb");
    }

}
