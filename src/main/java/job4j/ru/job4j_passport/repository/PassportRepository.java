package job4j.ru.job4j_passport.repository;

import job4j.ru.job4j_passport.domain.Passport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PassportRepository extends CrudRepository<Passport, Integer> {
    List<Passport> findPassportBySeries(int series);

    @Query("from Passport p where p.expiration between :currentDate and :futureDate")
    List<Passport> findReplaceablePassports(@Param("currentDate") LocalDate currentDate,
                                            @Param("futureDate") LocalDate futureDate);

    @Query("from Passport p where p.expiration < :currentDate")
    List<Passport> findUnavailable(@Param("currentDate") LocalDate calendar);

}
