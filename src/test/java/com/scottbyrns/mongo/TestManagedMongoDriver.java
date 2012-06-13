package com.scottbyrns.mongo;

import com.mongodb.DB;
import org.junit.Test;

import static junit.framework.Assert.*;

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
 * Created 6/12/12 8:51 PM
 */
public class TestManagedMongoDriver
{

    private MongoDriverConfiguration mongoDriverConfiguration = new MongoDriverConfiguration();

    {
        mongoDriverConfiguration.setServerAddress("198.101.202.204");
        mongoDriverConfiguration.setServerPort(27017);
        mongoDriverConfiguration.setDatabaseName(TEST_MANAGED_MONGO_DRIVER_UNIT_TEST_DB);
    }

    private static final String TEST_MANAGED_MONGO_DRIVER_UNIT_TEST_DB = "TestManagedMongoDriverUnitTestDB";

    @Test
    public void testCreatingAnInstance () {
        ManagedMongoDriver managedMongoDriver = new ManagedMongoDriver(mongoDriverConfiguration);
        assertTrue("Get instance should return an instance.", ManagedMongoDriver.class.isInstance(managedMongoDriver));
    }

    @Test
    public void testGettingADatabase () {
        ManagedMongoDriver managedMongoDriver = new ManagedMongoDriver(mongoDriverConfiguration);

        DB db = managedMongoDriver.getDB(TEST_MANAGED_MONGO_DRIVER_UNIT_TEST_DB);
        assertEquals("The name of the database we just got should be the same as we requested.", db.getName(), TEST_MANAGED_MONGO_DRIVER_UNIT_TEST_DB);
    }



}
