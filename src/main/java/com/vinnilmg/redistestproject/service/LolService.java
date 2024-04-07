package com.vinnilmg.redistestproject.service;

import com.vinnilmg.redistestproject.controller.request.AtualizacaoChampion;
import com.vinnilmg.redistestproject.controller.request.CadastroChampion;
import com.vinnilmg.redistestproject.domain.Champion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LolService {
    private final Logger LOG = LoggerFactory.getLogger(LolService.class);

    @Cacheable(value = "league-of-legends", key = "#name", unless = "#result == null")
    public Optional<Champion> getChampion(String name) {
        LOG.info("Bateu no service");
        return Optional.empty();
    }

    @Cacheable(value = "league-of-legends", key = "#request.name")
    public Champion createChampion(CadastroChampion request) {
        LOG.info("Bateu no service");
        return new Champion(request.id(), request.name(), request.position());
    }

    @CachePut(value = "league-of-legends", key = "#request.name")
    public Champion updateChampion(AtualizacaoChampion request) {
        LOG.info("Bateu no service");
        return new Champion(request.name(), request.position());
    }

    @CacheEvict(value = "league-of-legends", key = "#name")
    public void deleteChampion(String name) {
        LOG.info("Bateu no service");
        // Faz alguma coisa
    }

    @CacheEvict(value = "league-of-legends", allEntries = true)
    public void deleteAllChampions() {
        LOG.info("Bateu no service");
        // Faz alguma coisa
    }

}
