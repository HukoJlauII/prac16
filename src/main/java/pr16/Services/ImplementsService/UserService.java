package pr16.Services.ImplementsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pr16.Entity.User;
import pr16.Repositories.UserRepos;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepos userRepos;


    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepos.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
    public List<User> allUsers() {
        return userRepos.findAll();
    }
    public boolean saveUser(User user) {
        User userFromDB = userRepos.findUserByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }


        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepos.save(user);
        return true;
    }
    public boolean deleteUser(int userId) {
        if (userRepos.findById(userId).isPresent()) {
            userRepos.deleteById(userId);
            return true;
        }
        return false;
    }
}
