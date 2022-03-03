package pr16.Services;

import pr16.Entity.PostOffice;


public interface PostOfficeService {
    PostOffice addPostOffice(String name, String cityname);

    boolean removePostOffice(String cityname);

    boolean removeAllPostOffice();

    String showPostOffice(String cityname);

    String showAllPostOffice();

}
