package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.Required;
import play.db.jpa.*;
import play.cache.Cache;

@Entity
@Table(name = "search")
public class Search extends Model {

    @Required
    public String searchstring;

    @Required
    public Date timestamp;

    public Search(String searchstring) {
        this.searchstring = searchstring;
        this.timestamp = new Date();
        this.save();
        this.refreshCache();
    }

    private void refreshCache() {
        Long searchCount = Cache.get("searchCount", Long.class);
        if(searchCount == null) {
            searchCount = Search.count();
        }
        Cache.set("searchCount", searchCount + 1, "30mn");
    }

} 