package pr16.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pr16.Services.ImplementsService.DepartureService;
import pr16.Services.ImplementsService.PostOfficeService;


@RestController
@RequestMapping("/remove")
public class RemovingController {
    @Autowired
    private PostOfficeService postOfficeService;
    @Autowired
    private DepartureService departureService;

    @GetMapping("/postoffice/{cityname}")
    public String removePostOffice(@PathVariable String cityname) {
        if (postOfficeService.removePostOffice(cityname)) {
            return "Post office deleted";
        } else {
            return "Post office doesn't exists";
        }
    }

    @GetMapping("/postoffice/all")
    public String removeAllPostOffice() {
        if (postOfficeService.removeAllPostOffice()) {
            return "All Post Offices removed";
        } else {
            return "There are no Post Offices";
        }
    }

    @GetMapping("/departure/{cityname}/{type}")
    public String removeDeparture(@PathVariable String cityname, @PathVariable String type) {

        if (departureService.removeDeparture(cityname, type)) {
            return "Departure removed";
        } else {
            return "Departure or post office doesn't exist";
        }
    }

}
