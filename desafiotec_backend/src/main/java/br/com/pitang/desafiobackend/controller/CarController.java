package br.com.pitang.desafiobackend.controller;

import br.com.pitang.desafiobackend.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * A classe @carController representa o elo de comunicação entre a apirest e o service da parte web.
 */


@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;



}
