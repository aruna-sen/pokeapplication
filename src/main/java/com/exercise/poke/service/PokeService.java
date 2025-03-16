package com.exercise.poke.service;

import com.exercise.poke.dto.PokemonDetailDto;
import com.exercise.poke.dto.PokemonDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PokeService {
    public Mono<List<PokemonDto>> fetchHundredPoke();
    public Mono<PokemonDetailDto> fetchPokemonDetails(String name);
}
