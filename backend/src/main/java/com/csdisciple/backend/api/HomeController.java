package com.csdisciple.backend.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.csdisciple.backend.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {
    @Autowired
    private JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @GetMapping("/")
    public List<Person> home() throws SQLException {
        String sql = "SELECT id, name FROM person";
        return template.query(sql, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNumber) throws SQLException {
                Person person = new Person();
                person.setId(UUID.fromString(rs.getString(1)));
                person.setName(rs.getString(2));
                return person;
            }

        });

    }
}