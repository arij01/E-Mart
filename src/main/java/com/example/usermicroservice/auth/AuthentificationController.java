package com.example.usermicroservice.auth;

import com.example.usermicroservice.Entities.User;
import com.example.usermicroservice.UserDTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthentificationController {

    @Autowired
    UserSerivce userSerivce ;
    private final AuthentficationService authentificationService;
    @PostMapping("/registre")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> registre (@RequestBody RegistrationRequest request)
    {
        authentificationService.registre(request);
        return ResponseEntity.accepted().build();
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
    {
        return ResponseEntity.ok(authentificationService.authenticate(request));
    }
    @GetMapping("/getall")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userSerivce.getAllUsers();
        return ResponseEntity.ok(users);
    }

}
