package pr16.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pr16.Services.ImplementsService.DepartureService;
import pr16.Services.ImplementsService.PostOfficeService;

@RestController
@RequestMapping("/add")
public class AddingController {

    @Autowired
    private PostOfficeService postOfficeService;

    @Autowired
    private DepartureService departureService;

    @GetMapping("/postoffice/{name}/{cityname}")
    public String addPostOffice(@PathVariable String name, @PathVariable String cityname) {

        if (postOfficeService.addPostOffice(name, cityname) != null) {
            return "Post office created";
        } else {
            return "Post office already exists";
        }
    }

    @GetMapping("/departure/{cityname}/{type}/{date}")
    public String addDeparture(@PathVariable String cityname, @PathVariable String type, @PathVariable String date) {

        if (departureService.addDeparture(cityname, type, date) != null) {
            return "Departure added";
        } else {
            return "Post office doesn't exist or departure already exists";
        }

    }
}

