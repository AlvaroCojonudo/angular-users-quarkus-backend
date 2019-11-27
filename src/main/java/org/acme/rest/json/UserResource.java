package org.acme.rest.json;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject UserService userService;

    @GET
    public List<User> list() {
        return userService.list();
    }

    @POST
    public List<User> add(User user) {
        userService.add(user);
        return list();
    }

    @DELETE
    public List<User> delete(User user){
        userService.delete(user);
        return list();
    }
}