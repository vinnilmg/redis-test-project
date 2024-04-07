package com.vinnilmg.redistestproject.controller;

import com.vinnilmg.redistestproject.controller.request.AtualizacaoChampion;
import com.vinnilmg.redistestproject.controller.request.CadastroChampion;
import com.vinnilmg.redistestproject.domain.Champion;
import com.vinnilmg.redistestproject.service.LolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/redis")
public class LolController {
    private final Logger LOG = LoggerFactory.getLogger(LolController.class);

    @Autowired
    private LolService lolService;

    @GetMapping("/{name}")
    public ResponseEntity<Champion> getChampion(@PathVariable String name) {
        LOG.info("Bateu no controller: get");
        Optional<Champion> championOptional = lolService.getChampion(name);
        return championOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Champion> createChampion(@RequestBody CadastroChampion request) {
        LOG.info("Bateu no controller: create");
        var champion = lolService.createChampion(request);
        return ResponseEntity.ok(champion);
    }

    @PutMapping
    public ResponseEntity<Champion> updateChampion(@RequestBody AtualizacaoChampion request) {
        LOG.info("Bateu no controller: update");
        var championUpdated = lolService.updateChampion(request);
        return ResponseEntity.ok(championUpdated);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteChampion(@PathVariable String name) {
        LOG.info("Bateu no controller: delete");
        lolService.deleteChampion(name);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllChampions() {
        LOG.info("Bateu no controller: delete all");
        lolService.deleteAllChampions();
        return ResponseEntity.noContent().build();
    }

}
