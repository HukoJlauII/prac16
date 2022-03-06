package pr16.Services.ImplementsService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr16.Entity.PostOffice;
import pr16.Repositories.PostOfficeRepos;

@Service
@Slf4j
public class PostOfficeService implements pr16.Services.PostOfficeService {
    @Autowired
    private PostOfficeRepos postOfficeRepos;

    @Override
    public PostOffice addPostOffice(String name, String cityname) {
        PostOffice postOffice = postOfficeRepos.findPostOfficeByCityName(cityname);
        if (postOffice == null) {
            postOffice = new PostOffice(name, cityname);
            postOfficeRepos.save(postOffice);
            log.info("Post office added successfully");
            return postOffice;
        } else {
            log.info("Post office already exists");
            return null;
        }
    }

    @Override
    public boolean removePostOffice(String cityname) {
        if (postOfficeRepos.findPostOfficeByCityName(cityname) != null) {
            postOfficeRepos.delete(postOfficeRepos.findPostOfficeByCityName(cityname));
            log.info("Post office removed successfully");
            return true;
        } else {
            log.info("Post office doesn't exist");
            return false;
        }
    }

    @Override
    public boolean removeAllPostOffice() {
        if (postOfficeRepos.findAllBy() != null) {
            postOfficeRepos.deleteAll(postOfficeRepos.findAllBy());
            log.info("All post offices removed successfully");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String showPostOffice(String cityname) {
        if (postOfficeRepos.findPostOfficeByCityName(cityname) != null) {
            log.info(postOfficeRepos.findPostOfficeByCityName(cityname).toString());
            return postOfficeRepos.findPostOfficeByCityName(cityname).toString();
        } else {
            log.info("post office doesn't exists");
            return "post office doesn't exists";
        }
    }

    @Override
    public String showAllPostOffice() {
        log.info(postOfficeRepos.findAllBy().toString());
        return postOfficeRepos.findAllBy().toString();
    }
}
