package actions;

import be.objectify.deadbolt.java.ConstraintLogic;
import be.objectify.deadbolt.java.ExecutionContextProvider;
import be.objectify.deadbolt.java.actions.RestrictAction;
import be.objectify.deadbolt.java.cache.HandlerCache;
import play.Configuration;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import security.MyRoles;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;
/**
 * Created by Maria on 25/04/2017.
 */
public class CustomRestrictAction extends Action<CustomRestrict>
{
    final HandlerCache handlerCache;

    final Configuration playConfig;

    final ExecutionContextProvider ecProvider;

    private final ConstraintLogic constraintLogic;

    @Inject
    public CustomRestrictAction(final HandlerCache handlerCache,
                                final Configuration playConfig,
                                final ExecutionContextProvider ecProvider,
                                final ConstraintLogic constraintLogic)
    {
        this.handlerCache = handlerCache;
        this.playConfig = playConfig;
        this.ecProvider = ecProvider;
        this.constraintLogic = constraintLogic;
    }

    @Override
    public CompletionStage<Result> call(Http.Context context)
    {
        final CustomRestrict outerConfig = configuration;
        RestrictAction restrictionsAction = new RestrictAction(handlerCache,
                playConfig,
                configuration.config(),
                this.delegate,
                ecProvider,
                constraintLogic)
        {
            @Override
            public List<String[]> getRoleGroups()
            {
                List<String[]> roleGroups = new ArrayList<String[]>();
                for (RoleGroup roleGroup : outerConfig.value())
                {
                    MyRoles[] value = roleGroup.value();
                    String[] group = new String[value.length];
                    for (int i = 0; i < value.length; i++)
                    {
                        group[i] = value[i].getName();
                    }
                    roleGroups.add(group);
                }
                return roleGroups;
            }
        };
        return restrictionsAction.call(context);
    }
}
