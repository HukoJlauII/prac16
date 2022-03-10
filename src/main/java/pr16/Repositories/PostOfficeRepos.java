package pr16.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pr16.Entity.PostOffice;

import java.util.List;

@Repository
public interface PostOfficeRepos extends JpaRepository<PostOffice,Integer> {
    PostOffice findPostOfficeByCityName(String cityName);
    List<PostOffice> findAllBy();
    @Modifying
    @Query(value = "COPY postgres.jpa.post_office TO 'C:\\temp\\Entities\\post_office.csv'" +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void savePostoffice();
}
