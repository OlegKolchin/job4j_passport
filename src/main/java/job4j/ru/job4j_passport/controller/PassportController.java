package job4j.ru.job4j_passport.controller;

import job4j.ru.job4j_passport.domain.Passport;
import job4j.ru.job4j_passport.service.PassportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {
    private final PassportService service;

    public PassportController(final PassportService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Passport> getAll() {
        return service.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Passport> save(@RequestBody Passport passport) {
        return new ResponseEntity(service.save(passport), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/series/{series}")
    public List<Passport> findBySeries(@PathVariable int series) {
        return service.findPassportBySeries(series);
    }

    @GetMapping("/expired")
    public List<Passport> findExpired() {
        return service.findUnavailable();
    }

    @GetMapping("/replaceable")
    public List<Passport> findReplaceable() {
        return service.findReplaceable();
    }
}
