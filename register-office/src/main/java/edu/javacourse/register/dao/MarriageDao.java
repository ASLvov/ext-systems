package edu.javacourse.register.dao;

import edu.javacourse.register.business.MarriageManager;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.domain.Person;
import edu.javacourse.register.view.MarriageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Component
public class MarriageDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDao.class);

    private EntityManager entityManager;

    @Value("${test.value}")
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

    public MarriageDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called: {}", test);
        Query query = entityManager.createNamedQuery("MarriageCertificate.findCertificates");
        query.setParameter("certificateId", 1L);
        List<MarriageCertificate> resultList = query.getResultList();
        return resultList.get(0);
    }
}
