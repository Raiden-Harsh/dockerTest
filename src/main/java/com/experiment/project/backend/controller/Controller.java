package com.experiment.project.backend.controller;

import com.experiment.project.backend.dao.EntityDAO;
import com.experiment.project.backend.model.Entity;
import com.experiment.project.backend.service.EntityService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/home")
public class Controller {
    @Autowired
    private EntityService entityService;
    @Autowired
    private EntityDAO entityDAO;

    @GetMapping("/test")
    public ResponseEntity<?> testApi() {
        return ResponseEntity.ok("The API is working..");
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveEntity(@RequestBody Entity requestBody) {
        Entity response = entityService.save(requestBody);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/show")
    public ResponseEntity<?> showAll() {
        return ResponseEntity.ok(entityService.findAll());
    }

    @GetMapping("/json")
    public ResponseEntity<?> showJSONList(){
        List<Document> list = entityDAO.showDocumentsInJSON();
        return ResponseEntity.ok(list.toString());
    }

    @PostMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Entity> response = entityService.findById(id);
        if (response.isEmpty()) {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(response);
    }
}
