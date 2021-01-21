package edu.javacourse.register.dao;

import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.view.MarriageRequest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MarriageDaoTest {

    @Test
    public void findMarriageCertificate() {
        MarriageDao dao = new MarriageDao();
        MarriageRequest request = new MarriageRequest();
        MarriageCertificate certificate = dao.findMarriageCertificate(request);
        System.out.println("Husband: " + certificate.getHusband().toString());
        System.out.println("Wife: " + certificate.getWife().toString());
        System.out.println("Marriage certificate: " + certificate.toString());
    }
}