package edu.javacourse.register.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("2")
public class PersonMale extends Person {
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
            mappedBy = "husband")
    private List<MarriageCertificate> marriageCetificates;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
            mappedBy = "father")
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
