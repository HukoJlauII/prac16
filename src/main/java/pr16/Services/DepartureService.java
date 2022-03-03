package pr16.Services;

import pr16.Entity.Departure;


public interface DepartureService {
    Departure addDeparture(String cityname, String type, String date);

    boolean removeDeparture(String cityname, String type);

    String showDeparture( String cityname, String type);
}
