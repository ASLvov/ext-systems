package edu.javacourse.city.dao;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonCheckDaoTest {

    @Test
    public void checkPerson() throws PersonCheckException {
        PersonRequest personRequest = new PersonRequest();
        personRequest.setSurName("Васильев");
        personRequest.setGivenName("Павел");
        personRequest.setPatronymic("Николаевич");
        personRequest.setDateOfBirth(LocalDate.of(1995, 3, 18));
        personRequest.setStreetCode(1);
        personRequest.setBuilding("10");
        personRequest.setExtension("2");
        personRequest.setApartment("121");

        PersonCheckDao dao = new PersonCheckDao();
        PersonResponse personResponse = dao.checkPerson(personRequest);
        Assert.assertTrue(personResponse.isRegistered());
        Assert.assertFalse(personResponse.isTemporal());
    }

    @Test
    public void checkPerson2() throws PersonCheckException {
        PersonRequest personRequest = new PersonRequest();
        personRequest.setSurName("Васильева");
        personRequest.setGivenName("Ирина");
        personRequest.setPatronymic("Петровна");
        personRequest.setDateOfBirth(LocalDate.of(1997, 8, 21));
        personRequest.setStreetCode(1);
        personRequest.setBuilding("271");
        personRequest.setApartment("4");

        PersonCheckDao dao = new PersonCheckDao();
        PersonResponse personResponse = dao.checkPerson(personRequest);
        Assert.assertTrue(personResponse.isRegistered());
        Assert.assertFalse(personResponse.isTemporal());
    }
}