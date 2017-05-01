package security;

import be.objectify.deadbolt.java.models.Role;

/**
 * Created by Maria on 25/04/2017.
 */
public enum MyRoles implements Role
{
    medico,
    paciente,
    urgencias;

    @Override
    public String getName()
    {
        return name();
    }
}