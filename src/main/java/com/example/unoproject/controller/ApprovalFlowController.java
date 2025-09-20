package com.example.unoproject.controller;

import com.example.unoproject.model.ApprovalFlow;
import com.example.unoproject.service.ApprovalFlowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approval")
public class ApprovalFlowController {

    private final ApprovalFlowService service;

    public ApprovalFlowController(ApprovalFlowService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<ApprovalFlow> getAll() {
        return service.getAll();
    }

    @PostMapping("/insert")
    public String create(@RequestBody ApprovalFlow flow) {
        service.createApproval(flow);
        return "Approval flow created!";
    }

    @PutMapping("/{id}/status")
    public String updateStatus(@PathVariable int id, @RequestParam String status) {
        service.updateStatus(id, status);
        return "Status updated!";
    }
}