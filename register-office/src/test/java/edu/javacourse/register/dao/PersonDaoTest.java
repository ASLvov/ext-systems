package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonDaoTest {

    @Test
    public void findPersons() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();
        persons.forEach(p -> {
            System.out.println(p.getLastName() + " " + p.getFirstName() + " " + p.getPatronymic());
            System.out.println("Class for sex" + p.getClass().getName());
            System.out.println("Passports: " + p.getPassports().size());
            System.out.println("Birth cert: " + p.getBirthCertificate());
            if (p instanceof PersonMale) {
                System.out.println("Birth certs count: " + ((PersonMale)p).getBirthCetificates().size());
                System.out.println("Marriage certs count: " + ((PersonMale)p).getMarriageCetificates().size());
            } else {
                System.out.println("Birth certs count: " + ((PersonFemale)p).getBirthCetificates().size());
                System.out.println("Marriage certs count: " + ((PersonFemale)p).getMarriageCetificates().size());
            }
        });

    }
}