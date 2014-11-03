package com.youngearnz.api.registration;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.junit.Test;

import java.net.UnknownHostException;

/**
 * Created by can on 26/10/14.
 */
public class CreateJobTest {

    @Test
    public void createDefaultJobs() throws UnknownHostException {

        MongoClient client = new MongoClient("localhost");
        DB ye = client.getDB("ye");
        DBCollection jobs = ye.getCollection("jobs");


    }


}
