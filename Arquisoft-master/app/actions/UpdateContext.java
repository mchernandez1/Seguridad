package actions;


import play.mvc.With;

import java.lang.annotation.*;

/**
 * Created by Maria on 25/04/2017.
 */
@With(UpdateContextAction.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
@Documented
public @interface UpdateContext
{
    String value();
}
