package controllers;

import play.*;
import play.cache.Cache;
import play.mvc.*;

import java.util.*;

import models.*;
import play.templates.TemplateParser;

public class Application extends Controller {

    public static void index() {
        Statistics stat = new Statistics();
        TopTen topten = new TopTen();
        ArrayList<Vorname> toptenlist = topten.getTopTenList();
        render(toptenlist, stat);
    }

    public static void searchInit(String search) {
        Statistics stat = new Statistics();
        if (search != null && search.length() > 0) {
            Search searchentry = new Search(search);
            List<Vorname> vornamen = Vorname.find("firstname like ? order by firstname", "%" + search.toUpperCase() + "%").fetch();
            int resultSize = vornamen.size();
            Logger.debug("searchInit - resultSize = %s", resultSize);
            if (resultSize == 0) {
                Newname newname = new Newname(search);
                renderTemplate("Application/index.html", search, stat);
            } else if (resultSize == 1) {
                Application.show(vornamen.get(0).getLower());
            } else if (resultSize > 1) {
                renderTemplate("Application/index.html", search, vornamen, stat);
            }
        } else {
            renderTemplate("Application/index.html", search, stat);
        }
    }

    public static void searchResult(Vorname vorname) {
        renderTemplate("Application/index.html", vorname);
    }

    public static void showID(long id) {
        Logger.debug("in show: %s", id);
        Vorname vorname = Vorname.findById(id);
        renderTemplate("Application/show.html", vorname);
    }

    public static void show(String vornamenname) {
        Logger.debug("in showVorname: %s / %s", vornamenname);
        Statistics stat = new Statistics();
        EntryView view = new EntryView(vornamenname, request.format);
        Vorname vorname = Vorname.find("firstname = ?", vornamenname.toUpperCase()).first();
        if(request.format.equals("json")) {
            renderTemplate("Application/show.json", vorname);
        } else if(request.format.equals("csv")) {
            renderTemplate("Application/show.csv", vorname);
        } else if(request.format.equals("xml")) {
           renderTemplate("Application/show.xml", vorname);
        } else {
            render(vorname, stat);
        }
    }

    public static void deleteEntry(Long id, String search) {
        Vorname vn = Vorname.findById(id);
        vn.delete();
        Application.searchInit(search);
    }

}
