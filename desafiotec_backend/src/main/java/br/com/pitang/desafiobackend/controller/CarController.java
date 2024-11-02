package br.com.pitang.desafiobackend.controller;

import br.com.pitang.desafiobackend.dto.CarDTO;
import br.com.pitang.desafiobackend.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * A classe @carController representa o elo de comunicação entre a apirest e o service da parte web.
 */


@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    /**
     * Recupera a lista de todos os carros do usuário logado
     */
    @GetMapping()
    public ResponseEntity<?> getAll(@RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(this.service.findAll(token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    /**
     * Salva um novo veiculo vinculado a um usuário logado
     *
     * @param dto   objeto com os dados do novo carro
     * @param token para verificação do usuário logado
     */
    @PostMapping()
    public ResponseEntity<?> save(@RequestHeader("Authorization") String token, @RequestBody CarDTO dto) {
        try {
            return ResponseEntity.ok(this.service.create(token, dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    /**
     * Recupera um veiculo  do usuário logado por id
     *
     * @param id    do carrro para perquisa
     * @param token para verificação do usuário logado
     */
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.service.findById(token, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    /**
     * deleta um veiculo do usuário logado por id
     *
     * @param id    do carro a ser deletado
     * @param token para verificação do usuário logado
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        try {
            this.service.delete(token, id);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    /**
     * Atualiza os dados de veiculo vinculado do usuário logado
     *
     * @param dto   objeto com os dados atualizado do carro
     * @param token para verificação do usuário logado
     */
    @PutMapping()
    public ResponseEntity<?> update(@RequestHeader("Authorization") String token, @RequestBody CarDTO dto) {
        try {
            return ResponseEntity.ok(this.service.update(token, dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
