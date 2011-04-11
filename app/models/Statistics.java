package models;

import play.cache.Cache;

public class Statistics {

    public long firstnameCount = 0;
    public long firstnameFemaleCount = 0;
    public long firstnameMaleCount = 0;
    public long firstnameUnknownCount = 0;
    public long searchCount = 0;
    public long viewCount = 0;

    public long getFirstnameCount() {
        Long firstnameCount = Cache.get("firstnameCount", Long.class);
        if(firstnameCount == null) {
            firstnameCount = Vorname.count();
            Cache.set("firstnameCount", firstnameCount, "30mn");
        }
        return firstnameCount;
    }

    public long getFirstnameFemaleCount() {
        Long firstnameFemaleCount = Cache.get("firstnameFemaleCount", Long.class);
        if(firstnameFemaleCount == null) {
            firstnameFemaleCount = Vorname.count("gender = 'F'");
            Cache.set("firstnameFemaleCount", firstnameFemaleCount, "30mn");
        }
        return firstnameFemaleCount;
    }

    public long getFirstnameMaleCount() {
        Long firstnameMaleCount = Cache.get("firstnameMaleCount", Long.class);
        if(firstnameMaleCount == null) {
            firstnameMaleCount = Vorname.count("gender = 'M'");
            Cache.set("firstnameMaleCount", firstnameMaleCount, "30mn");
        }
        return firstnameMaleCount;
    }

    public long getFirstnameUnknownCount() {
        Long firstnameUnknownCount = Cache.get("firstnameUnknownCount", Long.class);
        if(firstnameUnknownCount == null) {
            firstnameUnknownCount = Vorname.count("gender = 'U'");
            Cache.set("firstnameUnknownCount", firstnameUnknownCount, "30mn");
        }
        return firstnameUnknownCount;
    }

    public long getSearchCount() {
        Long searchCount = Cache.get("searchCount", Long.class);
        if(searchCount == null) {
            searchCount = Search.count();
            Cache.set("searchCount", searchCount, "30mn");
        }
        return searchCount;
    }

    public long getViewCount() {
        Long viewCount = Cache.get("viewCount", Long.class);
        if(viewCount == null) {
            viewCount = EntryView.count();
            Cache.set("viewCount", viewCount, "30mn");
        }
        return viewCount;
    }

} 