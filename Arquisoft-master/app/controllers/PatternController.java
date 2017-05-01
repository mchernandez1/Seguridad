package controllers;

import be.objectify.deadbolt.java.actions.Pattern;
import be.objectify.deadbolt.java.models.PatternType;
import play.mvc.Controller;
import play.mvc.Result;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


/**
 * Created by Maria on 25/04/2017.
 */
public class PatternController extends Controller
{
    @Pattern("printers.edit")
    public CompletionStage<Result> editPrinter()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @Pattern("printers.detonate")
    public CompletionStage<Result> detonatePrinter()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @Pattern(value = "(.)*\\.edit", patternType = PatternType.REGEX)
    public CompletionStage<Result> editPrinterRegex()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }
}