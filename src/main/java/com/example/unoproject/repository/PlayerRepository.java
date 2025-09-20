package com.example.unoproject.repository;

import com.example.unoproject.dto.request.PlayerRequest;
import com.example.unoproject.dto.response.PlayerResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class PlayerRepository {

    private final JdbcTemplate jdbcTemplate;

    public PlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<PlayerResponse> rowMapper = (rs, rowNum) -> PlayerResponse.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .position(rs.getString("position"))
            .birthday(rs.getDate("birthday").toLocalDate())
            .nationality(rs.getString("nationality"))
            .squadNumber(rs.getInt("squad_number"))
            .joinYear(rs.getInt("join_year"))
            .kontrakUntil(rs.getInt("kontrak_until"))
            .gaji(rs.getDouble("gaji"))
            .build();

    public List<PlayerResponse> findAll() {
        return jdbcTemplate.query("SELECT * FROM players", rowMapper);
    }

    public PlayerResponse findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM players WHERE id = ?", rowMapper, id);
    }

    public int insert(PlayerRequest request) {
        return jdbcTemplate.update(
                "INSERT INTO players (name, position, birthday, nationality, squad_number, join_year, kontrak_until, gaji) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                request.getName(), request.getPosition(), Date.valueOf(request.getBirthday()),
                request.getNationality(), request.getSquadNumber(),
                request.getJoinYear(), request.getKontrakUntil(), request.getGaji()
        );
    }

    public int update(int id, PlayerRequest request) {
        return jdbcTemplate.update(
                "UPDATE players SET name=?, position=?, birthday=?, nationality=?, squad_number=?, join_year=?, kontrak_until=?, gaji=? WHERE id=?",
                request.getName(), request.getPosition(), Date.valueOf(request.getBirthday()),
                request.getNationality(), request.getSquadNumber(),
                request.getJoinYear(), request.getKontrakUntil(), request.getGaji(), id
        );
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM players WHERE id=?", id);
    }
}
