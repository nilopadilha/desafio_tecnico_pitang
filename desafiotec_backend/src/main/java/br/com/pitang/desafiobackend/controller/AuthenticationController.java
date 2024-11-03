package br.com.pitang.desafiobackend.controller;

import br.com.pitang.desafiobackend.dto.AutenticacaoDTO;
import br.com.pitang.desafiobackend.dto.RegistrarUsuarioDTO;
import br.com.pitang.desafiobackend.exceptions.UserCarNotFoundException;
import br.com.pitang.desafiobackend.model.User;
import br.com.pitang.desafiobackend.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthenticationController {
    @Autowired
    private  AuthenticationManager manager;

    @Autowired
    private UserRepository usuarioRepository;



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AutenticacaoDTO usuarioLog) throws UserCarNotFoundException {
        var usernamePassword = new UsernamePasswordAuthenticationToken(usuarioLog.login(), usuarioLog.password());
        var auth = this.manager.authenticate(usernamePassword);

        return ResponseEntity.status(HttpStatus.OK).body("logado com sucesso.");
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody @Valid RegistrarUsuarioDTO data) throws UserCarNotFoundException {
        if(this.usuarioRepository.findByLogin(data.login()) != null) return  ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUsuario = new User(data.firstName(), data.lastName(), data.email(), data.birthday(), data.login(), encryptedPassword, data.phone(), data.role());

        this.usuarioRepository.save(newUsuario);

        return ResponseEntity.status(HttpStatus.OK).body("Usuario cadastrado com sucesso.");

    }
}
