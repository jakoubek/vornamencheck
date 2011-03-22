package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
@Table(name = "VORNAME")
public class Vorname extends Model {

    @Required
    public String firstName;

    @Required
    @ManyToOne
    public Gender gender;

    public Vorname(String firstName) {
        this.firstName = firstName;
    }

    public String toString() {
        return this.firstName + " (" + this.gender.genderId + ")";
        //return this.firstName;
    }

} 