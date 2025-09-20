package com.example.unoproject.repository;

import com.example.unoproject.model.ApprovalFlow;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApprovalFlowRepository {

    private final JdbcTemplate jdbcTemplate;

    public ApprovalFlowRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<ApprovalFlow> rowMapper = (rs, rowNum) -> new ApprovalFlow(
            rs.getInt("id"),
            rs.getString("request_id"),
            rs.getString("approver"),
            rs.getInt("level"),
            rs.getString("status"),
            rs.getTimestamp("created_at").toLocalDateTime()
    );

    public List<ApprovalFlow> findAll() {
        return jdbcTemplate.query("SELECT * FROM approval_flow", rowMapper);
    }

    public int insert(ApprovalFlow flow) {
        return jdbcTemplate.update(
                "INSERT INTO approval_flow (request_id, approver, level, status) VALUES (?, ?, ?, ?)",
                flow.getRequestId(), flow.getApprover(), flow.getLevel(), flow.getStatus()
        );
    }

    public int updateStatus(int id, String status) {
        return jdbcTemplate.update(
                "UPDATE approval_flow SET status=? WHERE id=?",
                status, id
        );
    }
}
