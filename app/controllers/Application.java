package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public  static void searchInit(String search) {
        String vorname = search.toLowerCase();
        Logger.debug("Suchen nach %s", vorname);
        Vorname vn = Vorname.find("firstName like ?", "%" + vorname + "%").first();
        Logger.debug("Vorname: %s", vn.firstName);
        Application.searchResult(vn);
    }

    public static void searchResult(Vorname vorname) {
        renderTemplate("Application/index.html", vorname);
    }

}