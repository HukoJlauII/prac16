package pr16.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Data
public class Departure {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String type;
    private String date;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postoffice_id")
    private PostOffice postoffice;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public Departure() {
    }

    public Departure(String type, String date) {
        this.type = type;
        this.date = date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PostOffice getPostOffice() {
        return postoffice;
    }

    public void setPostOffice(PostOffice postOffice) {
        this.postoffice = postOffice;
    }

}
