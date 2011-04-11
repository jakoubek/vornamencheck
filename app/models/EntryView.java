package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.Required;
import play.db.jpa.*;

@Entity
@Table(name = "entryview")
public class EntryView extends Model {

    @Required
    @ManyToOne
    public Vorname firstname;

    @Required
    public String firstnameString;

    @Required
    public String viewformat;

    @Required
    public Date timestamp;

    public EntryView(String firstname, String viewformat) {
        this.firstname = Vorname.find("byFirstname", firstname).first();
        this.firstnameString = this.firstname.firstname;
        this.viewformat = viewformat;
        this.timestamp = new Date();
        this.save();
    }

} 