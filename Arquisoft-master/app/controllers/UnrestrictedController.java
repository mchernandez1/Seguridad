package controllers;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import be.objectify.deadbolt.java.actions.Unrestricted;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


/**
 * Created by Maria on 25/04/2017.
 */

    @Restrict(@Group("urgencias"))
    public class UnrestrictedController extends Controller
    {
        public CompletionStage<Result> index()
        {
            return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
        }

        @Unrestricted
        public CompletionStage<Result> unrestrictedWithinAConstrainedController()
        {
            return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
        }
    }

