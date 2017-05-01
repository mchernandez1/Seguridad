package controllers;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
/**
 * Created by Maria on 25/04/2017.
 */
public class EdgeCaseController extends Controller
{
    @Restrict(value = @Group("causeFailure"), handlerKey= "buggyHandler")
    public CompletionStage<Result> index()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }
}
