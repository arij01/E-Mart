package com.example.usermicroservice.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthentificationController {
    private final AuthentficationService authentificationService;
    @PostMapping("/registre")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> registre (@RequestBody RegistrationRequest request)
    {
        authentificationService.registre(request);
        return ResponseEntity.accepted().build();
    }
}
