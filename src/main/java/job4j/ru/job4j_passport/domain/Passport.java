package job4j.ru.job4j_passport.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private int series;
    private int number;
    private LocalDate issue;
    private LocalDate expiration;

    public static Passport of(String name, String surname, int series, int number,
                              LocalDate issue, LocalDate expiration) {
        Passport passport = new Passport();
        passport.name = name;
        passport.surname = surname;
        passport.series = series;
        passport.number = number;
        passport.issue = issue;
        passport.expiration = expiration;
        return passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getIssue() {
        return issue;
    }

    public void setIssue(LocalDate issue) {
        this.issue = issue;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }
}
