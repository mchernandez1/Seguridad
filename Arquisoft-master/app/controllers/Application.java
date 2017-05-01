package controllers;

import models.AuthorisedUser;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import javax.inject.Inject;
/**
 * Created by Maria on 25/04/2017.
 */
public class Application extends Controller
{
    private final HttpExecutionContext ec;

    @Inject
    public Application(final HttpExecutionContext ec)
    {
        this.ec = ec;
    }

    public CompletionStage<Result> index()
    {
        return CompletableFuture.supplyAsync(() -> AuthorisedUser.findByUserName("maria"))
                .thenApplyAsync(user -> ok(views.html.index.render((user))),
                        ec.current());
    }
}
