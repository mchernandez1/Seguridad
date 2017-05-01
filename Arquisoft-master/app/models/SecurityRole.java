package models;

import be.objectify.deadbolt.java.models.Role;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Maria on 25/04/2017.
 */
@Entity
public class SecurityRole extends Model implements Role
{
    @Id
    public Long id;

    public String name;

    public static final Finder<Long, SecurityRole> find = new Finder<>(Long.class,
            SecurityRole.class);

    public String getName()
    {
        return name;
    }

    public static SecurityRole findByName(String name)
    {
        return find.where()
                .eq("name",
                        name)
                .findUnique();
    }
}
