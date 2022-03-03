package pr16.Services.ImplementsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr16.Entity.Departure;
import pr16.Repositories.DepartureRepos;
import pr16.Repositories.PostOfficeRepos;

@Service
public class DepartureService implements pr16.Services.DepartureService {

    @Autowired
    private PostOfficeRepos postOfficeRepos;
    @Autowired
    private DepartureRepos departureRepos;

    @Override
    public Departure addDeparture(String cityname, String type, String date) {
        Departure departure = departureRepos.findDepartureByType(type);
        if (departure == null && postOfficeRepos.findPostOfficeByCityName(cityname) != null) {
            departure = new Departure(type, date);
            departure.setPostOffice(postOfficeRepos.findPostOfficeByCityName(cityname));
            departureRepos.save(departure);
            return departure;
        } else {
            return null;
        }
    }

    @Override
    public boolean removeDeparture(String cityname, String type) {
        if (postOfficeRepos.findPostOfficeByCityName(cityname) != null && departureRepos.findDepartureByType(type) != null) {
            departureRepos.delete(departureRepos.findDepartureByType(type));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String showDeparture(String cityname, String type) {
        if (postOfficeRepos.findPostOfficeByCityName(cityname) != null) {
            if (departureRepos.findDepartureByType(type) != null) {

                return departureRepos.findDepartureByType(type).toString();
            } else {
                return "departure doesn't exist";
            }
        } else {
            return "post office doesn't exist";
        }
    }
}
