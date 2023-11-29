package com.ohgiraffers.section02.annotation.subsection05.inject;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Service("pokemonServiceInject")
public class PokemonService {

//    @Inject
//    @Named("pikachu")
    private Pokemon pokemon;

    // 생성자 기반 주입
//    @Inject
//    public PokemonService(@Named("pikachu") Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }

    // setter 기반 주입
    @Inject
    public void setPokemon(@Named("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack(){
       pokemon.attack();
    }

}
