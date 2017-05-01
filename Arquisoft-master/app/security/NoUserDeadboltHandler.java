package security;

/**
 * Created by Maria on 25/04/2017.
 */
import be.objectify.deadbolt.java.AbstractDeadboltHandler;
import be.objectify.deadbolt.java.DynamicResourceHandler;
import be.objectify.deadbolt.java.ExecutionContextProvider;
import be.objectify.deadbolt.java.models.Subject;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import scala.concurrent.ExecutionContext;


import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

/**
 * @author María Camila
 */
public class NoUserDeadboltHandler extends AbstractDeadboltHandler
{
    public NoUserDeadboltHandler(ExecutionContextProvider ecProvider)
    {
        super(ecProvider);
    }

    public CompletionStage<Optional<Result>> beforeAuthCheck(final Http.Context context)
    {
        // if the API calls for an Optional, don't return a null!
        // THIS IS A PURPOSEFUL ERROR - DO NOT REPEAT IN YOUR CODE!
        return null;
    }

    public CompletionStage<Optional<? extends Subject>> getSubject(final Http.Context context)
    {
        return CompletableFuture.completedFuture(Optional.empty());
    }

    public CompletionStage<Result> onAuthFailure(final Http.Context context,
                                                 final Optional<String> content)
    {
        final ExecutionContext executionContext = executionContextProvider.get();
        return CompletableFuture.supplyAsync(views.html.accessFailed::render,
                (Executor) executionContext)
                .thenApplyAsync(Results::ok,
                        (Executor) executionContext);
    }

    public CompletionStage<Optional<DynamicResourceHandler>> getDynamicResourceHandler(Http.Context context)
    {
        final ExecutionContext executionContext = executionContextProvider.get();
        return CompletableFuture.supplyAsync(() -> Optional.of(new MyAlternativeDynamicResourceHandler()),
                (Executor) executionContext);
    }
}