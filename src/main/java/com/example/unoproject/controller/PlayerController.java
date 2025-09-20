package com.example.unoproject.controller;

import com.example.unoproject.dto.request.PlayerRequest;
import com.example.unoproject.dto.response.PlayerResponse;
import com.example.unoproject.factory.RestResponseFactory;
import com.example.unoproject.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<PlayerResponse> response = service.getAll();
        return RestResponseFactory.success(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        PlayerResponse response = service.getById(id);
        return RestResponseFactory.success(response);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PlayerRequest request) {
        service.create(request);
        return RestResponseFactory.success("Player created!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody PlayerRequest request) {
        service.update(id, request);
        return RestResponseFactory.success("Player updated!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return RestResponseFactory.success("Player deleted!");
    }
}
