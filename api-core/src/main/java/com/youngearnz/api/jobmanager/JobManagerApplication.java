package com.youngearnz.api.jobmanager;

/**
 * Created by can on 26/10/14.
 */
import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.net.UnknownHostException;

public class JobManagerApplication extends Application<JobManagerConfiguration> {

    MongoClient client;
    public JobManagerApplication() throws UnknownHostException {
        client = new MongoClient("localhost");
    }

    public static void main(String[] args) throws Exception {
        new JobManagerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<JobManagerConfiguration> bootstrap) {

    }

    @Override
    public void run(JobManagerConfiguration configuration,
                    Environment environment) {

        //final UserResource resource = new UserResource(client.getDB("ye"));
        //environment.jersey().register(resource);
    }

}