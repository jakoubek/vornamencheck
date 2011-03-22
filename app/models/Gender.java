package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
@Table(name = "GENDER")
public class Gender extends Model {

    public String genderId;
    public String genderName;

    public Gender() {
    }

    public String toString() {
        return this.genderId + " (" + this.genderName + ")";
    }

} 