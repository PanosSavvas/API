package com.youngearnz.api.registration;

/**
 * Created by can on 26/10/14.
 */

import com.codahale.metrics.annotation.Timed;
import com.mongodb.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/User")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private DB db;

    public UserResource(DB db) {
        this.db = db;
    }

    @POST
    @Timed
    @Path("/Register")
    public RegistrationResponse register(RegistrationRequest registrationRequest) {
        DBCollection users = db.getCollection("users");
        DBObject object = new BasicDBObject()
                .append("firstName", registrationRequest.getFirstName())
                .append("lastName", registrationRequest.getLastName())
                .append("email", registrationRequest.getEmail());

        WriteResult insert = users.insert(object);

        String id = object.get("_id").toString();
        return new RegistrationResponse(true, "Success", id);
    }

    @POST
    @Path("/Authenticate")
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        DBCursor result =
                db.getCollection("users").find(new BasicDBObject("_id", authenticationRequest.getId()));

        if (result.size() == 0) return new AuthenticationResponse(false);

        DBObject userObject = result.next();

        return new AuthenticationResponse(true);
    }
}