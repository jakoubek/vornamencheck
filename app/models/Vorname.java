package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;
import play.i18n.Messages;

import org.apache.commons.lang.WordUtils;

@Entity
@Table(name = "firstnames")
public class Vorname extends Model {

    @Required
    @Column(name = "firstname")
    public String firstname;

    @Required
    @Column(name = "gender")
    public String gender;

    public Vorname(String firstName) {
        this.firstname = firstName;
    }

    public String getPretty() {
        return WordUtils.capitalizeFully(this.firstname.toLowerCase(), new char[] { '-' });
    }

    public String getLower() {
        return this.firstname.toLowerCase();
    }

    public String getGendername() {
        String gendername;
        if (this.gender.equals("F")) {
            gendername = Messages.get("gender.female");
        } else if (this.gender.equals("M")) {
            gendername = Messages.get("gender.male");
        } else {
            gendername = Messages.get("gender.unknown");
        }
        return gendername;
    }

    public String toString() {
        //return this.firstName + " (" + this.gender.genderId + ")";
        return this.firstname;
    }

} 