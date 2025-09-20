package com.example.unoproject.service;

import com.example.unoproject.dto.request.PlayerRequest;
import com.example.unoproject.dto.response.PlayerResponse;
import com.example.unoproject.enums.RestEnum;
import com.example.unoproject.exception.AppException;
import com.example.unoproject.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository repository;

    public List<PlayerResponse> getAll() {
        return repository.findAll();
    }

    public PlayerResponse getById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new AppException(RestEnum.DATA_NOT_FOUND);
        }
    }

    public void create(PlayerRequest request) {
        repository.insert(request);
    }

    public void update(int id, PlayerRequest request) {
        if (repository.update(id, request) == 0) {
            throw new AppException(RestEnum.DATA_NOT_FOUND);
        }
    }

    public void delete(int id) {
        if (repository.delete(id) == 0) {
            throw new AppException(RestEnum.DATA_NOT_FOUND);
        }
    }
}