package pr16.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
public class PostOffice {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String name;
    private String cityName;

    public PostOffice() {
    }

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "postoffice",fetch = FetchType.LAZY)
    private final Set<Departure> departureSet =new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "PostOffice{" +
                "name='" + name + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
