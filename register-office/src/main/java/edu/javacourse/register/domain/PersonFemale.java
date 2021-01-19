package edu.javacourse.register.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("1")
public class PersonFemale extends Person {
//    private List<MarriageCertificate> marriageCetificates;
//    private List<BirthCertificate> birthCetificates;
//
//    public List<MarriageCertificate> getMarriageCetificates() {
//        return marriageCetificates;
//    }
//
//    public void setMarriageCetificates(List<MarriageCertificate> marriageCetificates) {
//        this.marriageCetificates = marriageCetificates;
//    }
//
//    public List<BirthCertificate> getBirthCetificates() {
//        return birthCetificates;
//    }
//
//    public void setBirthCetificates(List<BirthCertificate> birthCetificates) {
//        this.birthCetificates = birthCetificates;
//    }
}
