package app.homework_spring.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    public final String RESPONSE_OK_TEXT = "Server working!";
    public final String BAD_REQUEST_TEXT = "Bad request!";

    @GetMapping
    public ResponseEntity getCustomers() {
        try {
            return ResponseEntity.ok(RESPONSE_OK_TEXT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BAD_REQUEST_TEXT + " " + e.getMessage());
        }
    }
}
