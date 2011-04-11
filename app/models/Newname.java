package	models;

import javax.persistence.*;
import java.util.Date;
import play.db.jpa.*;
import play.data.validation.*;

@Entity
@Table(name = "newnames")
public class Newname extends Model {
    
    @Required
    @Column(name = "newname")
    public String newname;
    public Date createdDate;
  
    public Newname(String newname) {
        this.newname = newname;
        this.createdDate = new Date();
        this.save();
    }
    
    public String toString() {
        return this.newname;
    }
    
}
