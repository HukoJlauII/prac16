package pr16.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pr16.Entity.User;

import javax.validation.constraints.Size;

public interface UserRepos extends JpaRepository<User,Integer> {
    User findUserByUsername(@Size(min = 3, message = "Не меньше 3 знаков") String username);
}
