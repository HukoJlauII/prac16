package pr16.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pr16.Entity.Departure;
import pr16.Entity.PostOffice;

import java.util.List;

@Repository
public interface DepartureRepos extends JpaRepository<Departure,Integer> {
    Departure findDepartureByType(String type);
//    List<Departure> findAllByPostOffice(PostOffice postOffice);
}
