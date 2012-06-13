package com.scottbyrns.mongo;

import com.mongodb.Mongo;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Copyright (C) 2012 by Scott Byrns
 * http://github.com/scottbyrns
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * <p/>
 * Created 6/12/12 9:03 PM
 */
public class TestMongoFactory
{
    @Test
    public void testCreateMongoForConfiguration () {
        MongoDriverConfiguration mongoDriverConfiguration = new MongoDriverConfiguration();
        mongoDriverConfiguration.setServerAddress("198.101.202.204");
        mongoDriverConfiguration.setServerPort(27017);
        mongoDriverConfiguration.setDatabaseName("TestMongoFactoryDatabase");
        try {
            Mongo mongo = MongoFactory.getInstance().createMongoForConfiguration(mongoDriverConfiguration);
            assertTrue(Mongo.class.isInstance(mongo));
        }
        catch (UnknownHostException e) {
            fail("Unable to resolve MONGO server.");
        }
    }


}
