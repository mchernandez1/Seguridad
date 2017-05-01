package controllers;


import be.objectify.deadbolt.java.actions.Dynamic;
import be.objectify.deadbolt.java.actions.SubjectPresent;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


/**
 * Created by Maria on 25/04/2017.
 */
@SubjectPresent
public class DynamicRestrictionsController extends Controller
{
    public CompletionStage<Result> index()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @Dynamic("pureLuck")
    public CompletionStage<Result> pureLuck()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @Dynamic(value = "pureLuck", handlerKey = "altHandler")
    public CompletionStage<Result> noWayJose()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @Dynamic(value = "viewProfile")
    public CompletionStage<Result> viewProfile(final String userName)
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }
}