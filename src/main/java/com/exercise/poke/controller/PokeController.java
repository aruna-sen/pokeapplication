package com.exercise.poke.controller;


import com.exercise.poke.dto.PokemonDetailDto;
import com.exercise.poke.dto.PokemonDto;
import com.exercise.poke.service.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/rest/api/v1")
@CrossOrigin("*")
public class PokeController {
    public PokeService pokeService;

    public PokeController(PokeService pokeService){
        this.pokeService = pokeService;
    }


    @GetMapping("/getHundredPokemon")
    public Mono<List<PokemonDto>> getHundredPoke(){
        return pokeService.fetchHundredPoke();
    }

    @GetMapping(value = "/getPokemonDetails/{name}",produces="application/json")
    public Mono<PokemonDetailDto> getPokemonDetails(@PathVariable String name){
        return pokeService.fetchPokemonDetails(name);

    }

}
