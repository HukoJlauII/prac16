package pr16.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pr16.Entity.User;


public interface UserRepos extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
