package pr16.Services.ImplementsService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pr16.Entity.User;
import pr16.Repositories.UserRepos;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    UserRepos userRepos;


    BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean saveUser(User user) {
        User userFromDB = userRepos.findUserByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }


        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepos.save(user);
        return true;
    }

}
