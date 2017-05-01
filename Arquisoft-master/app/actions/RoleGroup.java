package actions;

import security.MyRoles;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Maria on 25/04/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleGroup
{
    /**
     * The roles with access to the target.
     *
     * @return the role names
     */
    MyRoles[] value() default {};

    MyRoles[] not() default {};
}
