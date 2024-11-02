package br.com.pitang.desafiobackend.controller;

import br.com.pitang.desafiobackend.dto.UserDTO;
import br.com.pitang.desafiobackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * A classe @UserController representa o elo de comunicação entre a apirest e o service da parte web.
 */


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class Usercontoller {

    private final UserService service;

    /**
     * Recupera a lista de todos os usuários
     */
    @GetMapping()
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(this.service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    /**
     * cadastra um novo usuário no sistema
     *
     * @param dto objeto com os dados do novo usuário
     */
    @PostMapping()
    public ResponseEntity<?> save(@RequestBody UserDTO dto) {
        try {
            return ResponseEntity.ok(this.service.create(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    /**
     * Recupera um usuário por id
     *
     * @param id do usuário para perquisa
     */
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

    /**
     * Atualiza os dados usuário
     *
     * @param dto objeto com os dados atualizado do usuário
     */
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody UserDTO dto) {
        try {
            return ResponseEntity.ok(this.service.update(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    /**
     * deleta um usuário por id
     *
     * @param id do usuário a ser excluído
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            this.service.deleteById(id);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }

    }


}
