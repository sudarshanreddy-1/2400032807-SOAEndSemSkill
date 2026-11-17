package soa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soa.service.GatewayService;

@RestController
@RequestMapping("/api/books")
public class GatewayController {

    GatewayService GS;

    public GatewayController(GatewayService GS) {
        this.GS = GS;
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody String requestbody) {
        return GS.addBook(requestbody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(
            @PathVariable Long id,
            @RequestBody String requestbody) {

        return GS.updateBook(id, requestbody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return GS.deleteBook(id);
    }

    @GetMapping
    public ResponseEntity<String> getAllBook() {
        return GS.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getBookbyId(@PathVariable Long id) {
        return GS.getBookById(id);
    }
}