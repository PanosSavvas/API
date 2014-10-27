package com.youngearnz.api.core;

/**
 * Created by can on 26/10/14.
 */
import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.net.UnknownHostException;

public class APIApplication extends Application<APIConfiguration> {

    MongoClient client;
    public APIApplication() throws UnknownHostException {
        client = new MongoClient("localhost");
    }

    public static void main(String[] args) throws Exception {
        new APIApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<APIConfiguration> bootstrap) {

    }

    @Override
    public void run(APIConfiguration configuration,
                    Environment environment) {

        final UserResource resource = new UserResource(client.getDB("ye"));
        environment.jersey().register(resource);
    }

}