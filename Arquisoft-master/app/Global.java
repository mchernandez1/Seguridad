import com.avaje.ebean.Ebean;
import models.AuthorisedUser;
import models.SecurityRole;
import models.UserPermission;
import play.Application;
import play.GlobalSettings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mc.hernandez1 on 27/04/2017.
 */
public class Global extends GlobalSettings
{
    @Override
    public void onStart(Application application)
    {
        if (SecurityRole.find.findRowCount() == 0)
        {
            for (String name : Arrays.asList("medico", "paciente", "urgencias"))
            {
                SecurityRole role = new SecurityRole();
                role.name = name;
                role.save();
            }
        }

        if (UserPermission.find.findRowCount() == 0)
        {
            UserPermission permission = new UserPermission();
            permission.value = "printers.edit";
            permission.save();
        }

        if (AuthorisedUser.find.findRowCount() == 0)
        {
            AuthorisedUser user = new AuthorisedUser();
            user.userName = "maria";
            user.roles = new ArrayList<SecurityRole>();
            user.roles.add(SecurityRole.findByName("medico"));
            user.roles.add(SecurityRole.findByName("paciente"));
            user.permissions = new ArrayList<UserPermission>();
            user.permissions.add(UserPermission.findByValue("printers.edit"));

            user.save();
            Ebean.saveManyToManyAssociations(user,
                    "roles");
            Ebean.saveManyToManyAssociations(user,
                    "permissions");
        }
    }
}