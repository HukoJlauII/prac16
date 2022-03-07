package pr16.Services.ImplementsService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr16.Aspect.LogExecutionTime;
import pr16.Entity.PostOffice;
import pr16.Repositories.PostOfficeRepos;

@Service
@Slf4j
public class PostOfficeService implements pr16.Services.PostOfficeService {
    @Autowired
    private PostOfficeRepos postOfficeRepos;
    @Autowired
    private EmailSenderService emailSenderService;

    @Override
    @LogExecutionTime
    public PostOffice addPostOffice(String name, String cityname) {
        PostOffice postOffice = postOfficeRepos.findPostOfficeByCityName(cityname);
        if (postOffice == null) {
            postOffice = new PostOffice(name, cityname);
            postOfficeRepos.save(postOffice);
            log.info("Post office added successfully");
            emailSenderService.sendMail("Post office added successfully");
            return postOffice;
        } else {
            log.info("Post office already exists");
            emailSenderService.sendMail("Post office already exists");
            return null;
        }
    }

    @Override
    @LogExecutionTime
    public boolean removePostOffice(String cityname) {
        if (postOfficeRepos.findPostOfficeByCityName(cityname) != null) {
            postOfficeRepos.delete(postOfficeRepos.findPostOfficeByCityName(cityname));
            log.info("Post office removed successfully");
            emailSenderService.sendMail("Post office removed successfully");
            return true;
        } else {
            log.info("Post office doesn't exist");
            emailSenderService.sendMail("Post office doesn't exist");
            return false;
        }
    }

    @Override
    @LogExecutionTime
    public boolean removeAllPostOffice() {
        if (postOfficeRepos.findAllBy() != null) {
            postOfficeRepos.deleteAll(postOfficeRepos.findAllBy());
            log.info("All post offices removed successfully");
            emailSenderService.sendMail("All post offices removed successfully");
            return true;
        } else {
            log.info("Post office base is empty");
            emailSenderService.sendMail("Post office base is empty");
            return false;
        }
    }

    @Override
    @LogExecutionTime
    public String showPostOffice(String cityname) {
        if (postOfficeRepos.findPostOfficeByCityName(cityname) != null) {
            log.info(postOfficeRepos.findPostOfficeByCityName(cityname).toString());
            emailSenderService.sendMail(postOfficeRepos.findPostOfficeByCityName(cityname).toString());
            return postOfficeRepos.findPostOfficeByCityName(cityname).toString();

        } else {
            log.info("post office doesn't exists");
            emailSenderService.sendMail("post office doesn't exists");
            return "post office doesn't exists";
        }
    }

    @Override
    @LogExecutionTime
    public String showAllPostOffice() {
        log.info(postOfficeRepos.findAllBy().toString());
        emailSenderService.sendMail(postOfficeRepos.findAllBy().toString());
        return postOfficeRepos.findAllBy().toString();
    }
}
