package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService {

    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request) {
        String readSql = "SELECT * FROM user WHERE id = ?";
        boolean isUserNotExist
                = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }
}
