package controllers;

import play.cache.Cache;
import play.mvc.*;

import models.*;

import java.util.Stack;

public class Admin extends Controller {

    public static void index() {
        Statistics stat = new Statistics();
        render(stat);
    }

}
