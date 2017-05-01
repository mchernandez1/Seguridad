package security;

import be.objectify.deadbolt.java.DeadboltHandler;
import be.objectify.deadbolt.java.DynamicResourceHandler;
import play.mvc.Http;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by Maria on 25/04/2017.
 */
public class MyAlternativeDynamicResourceHandler implements DynamicResourceHandler
{
    public CompletionStage<Boolean> isAllowed(final String name,
                                              final Optional<String> meta,
                                              final DeadboltHandler deadboltHandler,
                                              final Http.Context context)
    {
        // look something up in an LDAP directory, etc, and the answer isn't good for the user
        return CompletableFuture.completedFuture(false);
    }

    public CompletionStage<Boolean> checkPermission(final String permissionValue,
                                                    final Optional<String> meta,
                                                    final DeadboltHandler deadboltHandler,
                                                    final Http.Context ctx)
    {
        // Computer says no
        return CompletableFuture.completedFuture(false);
    }
}
