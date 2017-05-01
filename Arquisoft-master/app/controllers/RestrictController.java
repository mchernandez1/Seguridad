package controllers;

import actions.CustomRestrict;
import actions.RoleGroup;
import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import play.mvc.Controller;
import play.mvc.Result;
import security.MyRoles;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by Maria on 25/04/2017.
 */
@Restrict({@Group("medico"),
        @Group("paciente")})
public class RestrictController extends Controller
{
    public CompletionStage<Result> index()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @Restrict({@Group({"medico", "paciente"})})
    public CompletionStage<Result> restrictOne()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @Restrict({@Group({"urgencias", "paciente"}), @Group("medico")})
    public CompletionStage<Result> restrictTwo()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @Restrict({@Group("medico"), @Group("!paciente")})
    public CompletionStage<Result> restrictThree()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @Restrict(@Group({"urgencias", "medico"}))
    public CompletionStage<Result> restrictFour()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @Restrict(@Group({"medico", "!paciente"}))
    public CompletionStage<Result> restrictFive()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }


    @CustomRestrict(value = {@RoleGroup({MyRoles.medico, MyRoles.paciente}),
            @RoleGroup(MyRoles.urgencias)},
            config = @Restrict({}))
    public CompletionStage<Result> customRestrictOne()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }

    @CustomRestrict(value = {@RoleGroup({MyRoles.urgencias, MyRoles.medico}),
            @RoleGroup({MyRoles.urgencias, MyRoles.paciente})},
            config = @Restrict({}))
    public CompletionStage<Result> customRestrictTwo()
    {
        return CompletableFuture.completedFuture(ok(views.html.accessOk.render()));
    }
}

