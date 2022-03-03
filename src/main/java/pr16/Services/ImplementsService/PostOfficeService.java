package pr16.Services.ImplementsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr16.Entity.PostOffice;
import pr16.Repositories.PostOfficeRepos;

@Service
public class PostOfficeService implements pr16.Services.PostOfficeService {
    @Autowired
    private PostOfficeRepos postOfficeRepos;

    @Override
    public PostOffice addPostOffice(String name, String cityname) {
        PostOffice postOffice = postOfficeRepos.findPostOfficeByCityName(cityname);
        if (postOffice == null) {
            postOffice = new PostOffice(name, cityname);
            postOfficeRepos.save(postOffice);
            return postOffice;
        } else {
            return null;
        }
    }

    @Override
    public boolean removePostOffice(String cityname) {
        if (postOfficeRepos.findPostOfficeByCityName(cityname) != null) {
            postOfficeRepos.delete(postOfficeRepos.findPostOfficeByCityName(cityname));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeAllPostOffice() {
        if (postOfficeRepos.findAllBy() != null) {
            postOfficeRepos.deleteAll(postOfficeRepos.findAllBy());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String showPostOffice(String cityname) {
        if (postOfficeRepos.findPostOfficeByCityName(cityname) != null) {
            return postOfficeRepos.findPostOfficeByCityName(cityname).toString();
        } else {
            return "post office doesn't exists";
        }
    }

    @Override
    public String showAllPostOffice() {
        return postOfficeRepos.findAllBy().toString();
    }
}
