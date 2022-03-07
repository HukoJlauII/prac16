package pr16.Services.ImplementsService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr16.Aspect.LogExecutionTime;
import pr16.Entity.Departure;
import pr16.Repositories.DepartureRepos;
import pr16.Repositories.PostOfficeRepos;

@Service
@Slf4j
public class DepartureService implements pr16.Services.DepartureService {

    @Autowired
    private PostOfficeRepos postOfficeRepos;
    @Autowired
    private DepartureRepos departureRepos;
    @Autowired
    private EmailSenderService emailSenderService;

    @Override
    @LogExecutionTime
    public Departure addDeparture(String cityname, String type, String date) {
        Departure departure = departureRepos.findDepartureByType(type);
        if (departure == null && postOfficeRepos.findPostOfficeByCityName(cityname) != null) {
            departure = new Departure(type, date);
            departure.setPostOffice(postOfficeRepos.findPostOfficeByCityName(cityname));
            departureRepos.save(departure);
            log.info("Departure added successfully" );
            emailSenderService.sendMail("Departure added successfully");
            return departure;
        } else {
            log.info("Post office doesn't exist or departure already exists");
            emailSenderService.sendMail("Post office doesn't exist or departure already exists");
            return null;
        }
    }

    @Override
    @LogExecutionTime
    public boolean removeDeparture(String cityname, String type) {
        if (postOfficeRepos.findPostOfficeByCityName(cityname) != null && departureRepos.findDepartureByType(type) != null) {
            departureRepos.delete(departureRepos.findDepartureByType(type));
            log.info("Departure removed successfully");
            emailSenderService.sendMail("Departure removed successfully");
            return true;
        } else {
            log.info("Departure or post office doesn't exist");
            emailSenderService.sendMail("Departure or post office doesn't exist");
            return false;
        }
    }

    @Override
    @LogExecutionTime
    public String showDeparture(String cityname, String type) {
        if (postOfficeRepos.findPostOfficeByCityName(cityname) != null) {
            if (departureRepos.findDepartureByType(type) != null) {
                log.info(departureRepos.findDepartureByType(type).toString());
                emailSenderService.sendMail(departureRepos.findDepartureByType(type).toString());
                return departureRepos.findDepartureByType(type).toString();
            } else {
                log.info("Departure doesn't exist");
                emailSenderService.sendMail("Departure doesn't exist");
                return "Departure doesn't exist";
            }
        } else {
            log.info("Post office doesn't exist");
            emailSenderService.sendMail("Post office doesn't exist");
            return "Post office doesn't exist";
        }
    }
}
