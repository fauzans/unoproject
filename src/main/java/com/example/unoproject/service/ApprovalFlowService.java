package com.example.unoproject.service;

import com.example.unoproject.model.ApprovalFlow;
import com.example.unoproject.repository.ApprovalFlowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalFlowService {

    private final ApprovalFlowRepository repository;

    public ApprovalFlowService(ApprovalFlowRepository repository) {
        this.repository = repository;
    }

    public List<ApprovalFlow> getAll() {
        return repository.findAll();
    }

    public void createApproval(ApprovalFlow flow) {
        repository.insert(flow);
    }

    public void updateStatus(int id, String status) {
        repository.updateStatus(id, status);
    }
}
