package com.youngearnz.api.registration;

/**
 * Created by can on 26/10/14.
 */
import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.net.UnknownHostException;

public class RegistrationApplication extends Application<RegistrationConfiguration> {

    MongoClient client;
    public RegistrationApplication() throws UnknownHostException {
        client = new MongoClient("localhost");
    }

    public static void main(String[] args) throws Exception {
        new RegistrationApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<RegistrationConfiguration> bootstrap) {

    }

    @Override
    public void run(RegistrationConfiguration configuration,
                    Environment environment) {

        final UserResource resource = new UserResource(client.getDB("ye"));
        environment.jersey().register(resource);
    }

}