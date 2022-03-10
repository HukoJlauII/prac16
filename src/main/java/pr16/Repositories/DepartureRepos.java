package pr16.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pr16.Entity.Departure;

@Repository
public interface DepartureRepos extends JpaRepository<Departure,Integer> {
    Departure findDepartureByType(String type);
    @Modifying
    @Query(value = "COPY postgres.jpa.departure TO 'C:\\temp\\Entities\\departure.csv'" +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void saveDeparture();
}
