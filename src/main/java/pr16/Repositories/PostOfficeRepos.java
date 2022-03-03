package pr16.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pr16.Entity.PostOffice;

import java.util.List;

@Repository
public interface PostOfficeRepos extends JpaRepository<PostOffice,Integer> {
    PostOffice findPostOfficeByCityName(String cityName);
    List<PostOffice> findAllBy();

}
