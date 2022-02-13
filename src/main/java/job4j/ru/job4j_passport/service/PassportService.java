package job4j.ru.job4j_passport.service;

import job4j.ru.job4j_passport.domain.Passport;
import job4j.ru.job4j_passport.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassportService {
    private PassportRepository repository;

    public PassportService(PassportRepository repository) {
        this.repository = repository;
    }

    public Passport save(Passport passport) {
        return repository.save(passport);
    }

    public List<Passport> findAll() {
        List<Passport> passports = new ArrayList<>();
        repository.findAll().forEach(passports::add);
        return passports;
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<Passport> findPassportBySeries(int series) {
        return repository.findPassportBySeries(series);
    }

    public List<Passport> findUnavailable() {
        List<Passport> passports = new ArrayList<>();
        repository.findUnavailable(LocalDate.now()).forEach(passports::add);
        return passports;
    }

    public List<Passport> findReplaceable() {
        List<Passport> passports = new ArrayList<>();
        repository.findReplaceablePassports(LocalDate.now(), LocalDate.now().plusMonths(3)).forEach(passports::add);
        return passports;
    }
}
