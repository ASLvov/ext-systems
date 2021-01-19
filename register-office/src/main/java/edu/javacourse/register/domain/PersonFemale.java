package edu.javacourse.register.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("1")
public class PersonFemale extends Person {
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
            mappedBy = "wife")
    private List<MarriageCertificate> marriageCetificates;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
            mappedBy = "mother")
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
