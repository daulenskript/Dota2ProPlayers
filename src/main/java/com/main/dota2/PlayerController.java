package com.main.dota2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private final Dota2Service dota2Service;

    public PlayerController(Dota2Service dota2Service) {
        this.dota2Service = dota2Service;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(dota2Service.getPlayerById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Profile>> getAllPlayers() {
        return ResponseEntity.ok(dota2Service.getAllPlayers());
    }
    @GetMapping("/search")
    public List<Profile> getPlayersByName(@RequestParam String name) {
        return dota2Service.findByName(name);
    }

}
