package models;


import be.objectify.deadbolt.java.models.Permission;
import be.objectify.deadbolt.java.models.Role;
import be.objectify.deadbolt.java.models.Subject;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by Maria on 25/04/2017.
 */
@Entity
public class AuthorisedUser extends Model implements Subject
{
    @Id
    public Long id;

    public String userName;

    @ManyToMany
    public List<SecurityRole> roles;

    @ManyToMany
    public List<UserPermission> permissions;

    public static final Finder<Long, AuthorisedUser> find = new Finder<>(Long.class,
            AuthorisedUser.class);

    public List<? extends Role> getRoles()
    {
        return roles;
    }

    public List<? extends Permission> getPermissions()
    {
        return permissions;
    }


    public String getIdentifier()
    {
        return userName;
    }

    public static AuthorisedUser findByUserName(String userName)
    {
        return find.where()
                .eq("userName",
                        userName)
                .findUnique();
    }
}
