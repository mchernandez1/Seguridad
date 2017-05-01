package actions;


import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

/**
 * Created by Maria on 25/04/2017.
 */
public class UpdateContextAction extends Action<UpdateContext>
{
    @Override
    public CompletionStage<Result> call(final Http.Context context)
    {
        context.args.put("UpdateContext",
                configuration.value());
        return delegate.call(context);
    }
}