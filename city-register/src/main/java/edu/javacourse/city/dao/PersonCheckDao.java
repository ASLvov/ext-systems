package edu.javacourse.city.dao;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;

import java.sql.*;
import java.time.LocalDate;

public class PersonCheckDao {
    private static final String SQL_REQUEST =
            "SELECT temporal FROM cr_address_person ap " +
                    "INNER JOIN cr_person p ON p.person_id = ap.person_id " +
                    "INNER JOIN cr_address a ON a.address_id = ap.address_id " +
                    "WHERE " +
                    "CURRENT_DATE >= ap.start_date AND (CURRENT_DATE <= ap.end_date OR ap.end_date is null) " +
                    "AND UPPER(p.sur_name) = UPPER(?) " +
                    "AND UPPER(p.given_name) = UPPER(?) " +
                    "AND UPPER(p.patronymic) = UPPER(?) " +
                    "AND p.date_of_birth = ? " +
                    "AND a.street_code = ? " +
                    "AND UPPER(a.building) = UPPER(?) ";

    private ConnectionBuilder connectionBuilder;

    public PersonCheckDao() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    public PersonResponse checkPerson(PersonRequest personRequest) throws PersonCheckException {
        PersonResponse personResponse = new PersonResponse();

        String sql = SQL_REQUEST;

        if (personRequest.getExtension() != null) {
            sql += "AND UPPER(a.extension) = UPPER(?) ";
        } else {
            sql += "AND a.extension is null ";
        }

        if (personRequest.getApartment() != null) {
            sql += "AND UPPER(a.apartment) = UPPER(?) ";
        } else {
            sql += "AND a.apartment is null ";
        }

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            int count = 1;
            stmt.setString(count++, personRequest.getSurName());
            stmt.setString(count++, personRequest.getGivenName());
            stmt.setString(count++, personRequest.getPatronymic());
            stmt.setDate(count++, java.sql.Date.valueOf(personRequest.getDateOfBirth()));
            stmt.setInt(count++, personRequest.getStreetCode());
            stmt.setString(count++, personRequest.getBuilding());
            if (personRequest.getExtension() != null) {
                stmt.setString(count++, personRequest.getExtension());
            }
            if (personRequest.getApartment() != null) {
                stmt.setString(count++, personRequest.getApartment());
            }

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

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }
}
