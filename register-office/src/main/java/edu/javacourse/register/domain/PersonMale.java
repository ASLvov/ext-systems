package edu.javacourse.register.domain;

import java.util.List;

public class PersonMale extends Person {
    private List<MarriageCertificate> marriageCetificates;
    private List<BirthCertificate> birthCetificates;

    public List<MarriageCertificate> getMarriageCetificates() {
        return marriageCetificates;
    }

    public void setMarriageCetificates(List<MarriageCertificate> marriageCetificates) {
        this.marriageCetificates = marriageCetificates;
    }

    public List<BirthCertificate> getBirthCetificates() {
        return birthCetificates;
    }

    public void setBirthCetificates(List<BirthCertificate> birthCetificates) {
        this.birthCetificates = birthCetificates;
    }
}
