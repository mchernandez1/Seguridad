package controllers;

import be.objectify.deadbolt.java.actions.SubjectNotPresent;
import be.objectify.deadbolt.java.actions.SubjectPresent;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


/**
 * Created by Maria on 25/04/2017.
 */
public class SubjectController extends Controller
{
    public CompletionStage<Result> index()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @SubjectPresent
    public CompletionStage<Result> subjectPresent()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @SubjectPresent(handlerKey = "noUserHandler")
    public CompletionStage<Result> subjectPresent_notLoggedIn()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @SubjectNotPresent(handlerKey = "noUserHandler")
    public CompletionStage<Result> subjectNotPresent()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @SubjectNotPresent
    public CompletionStage<Result> subjectNotPresent_loggedIn()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }
}