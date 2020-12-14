package edu.javacourse.city.dao;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCheckDao {
    private static final String SQL_REQUEST =
            "SELECT temporal FROM cr_address_person ap" +
                    "INNER JOIN cr_person p ON p.person_id = ap.person_id" +
                    "INNER JOIN cr_address a ON a.address_id = ap.address_id" +
                    "WHERE" +
                    "UPPER(p.sur_name) = UPPER(?)" +
                    "AND UPPER(p.given_name) = UPPER(?)" +
                    "AND UPPER(p.patronymic) = UPPER(?)" +
                    "AND p.date_of_birth = ?" +
                    "AND a.street_code = ?" +
                    "AND UPPER(a.building) = UPPER(?)" +
                    "AND UPPER(a.extension) = UPPER(?)" +
                    "AND UPPER(a.apartment) = UPPER(?)";

    public PersonResponse checkPerson (PersonRequest personRequest) throws PersonCheckException {
        PersonResponse personResponse = new PersonResponse();
        try (Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_REQUEST))
        {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                personResponse.setRegistered(true);
                personResponse.setTemporal(rs.getBoolean("temporal"));
            }

        } catch (SQLException ex) {
            throw new PersonCheckException(ex);
        }

        return personResponse;
    }

    private Connection getConnection() {
        return null;
    }
}
