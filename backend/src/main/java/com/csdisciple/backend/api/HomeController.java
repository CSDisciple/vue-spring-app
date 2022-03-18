package com.csdisciple.backend.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;



import com.csdisciple.backend.model.Person;
import com.csdisciple.backend.model.Facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.math.BigDecimal;
@RestController
@CrossOrigin
public class HomeController {
    @Autowired
    private JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @GetMapping("/members")
    public List<Person> members() throws SQLException {
        String sql = "SELECT memid, surname, firstname, address FROM cd.members";
        return template.query(sql, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNumber) throws SQLException {
                Person person = new Person();
                person.setId(Integer.parseInt(rs.getString(1)));
                person.setName(rs.getString(2));
                return person;
            }

        });

    }

    @GetMapping("/facilities")
    public List<Facility> facilities() throws SQLException {
        String sql = "SELECT facid, name, membercost, guestcost, initialoutlay, monthlymaintenance  FROM cd.facilities";
        return template.query(sql, new RowMapper<Facility>() {
            @Override
            public Facility mapRow(ResultSet rs, int rowNumber) throws SQLException {
                Facility facility = new Facility();
                facility.setId(new BigDecimal(rs.getString(1)));
                facility.setName(rs.getString(2));
                facility.setMemberCost(new BigDecimal(rs.getString(3)));
                facility.setGuestCost( new BigDecimal(rs.getString(4)));
                facility.setInitialOutlay(new BigDecimal(rs.getString(5)));
                facility.setMonthlyMaintenance(new BigDecimal(rs.getString(6)));
                return facility;
            }

        });

    }

}