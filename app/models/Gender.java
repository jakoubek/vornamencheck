package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

@Entity
@Table(name = "gender")
public class Gender extends Model {

    @Required
    @Column(name = "genderid")
    public String genderId;

    @Required
    @Column(name = "gendername")
    public String genderName;

    public Gender() {
    }

    public String toString() {
        return this.genderId + " (" + this.genderName + ")";
    }

} 