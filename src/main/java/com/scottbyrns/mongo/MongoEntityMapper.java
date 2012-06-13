package com.scottbyrns.mongo;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.scottbyrns.utilities.FatalMappingException;
import com.scottbyrns.utilities.InvalidJSONStringException;
import com.scottbyrns.utilities.JSONObjectMapper;
import org.codehaus.jackson.map.JsonMappingException;

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
 * Created 6/12/12 9:12 PM
 */
public class MongoEntityMapper
{
    public static <T> T dbObjectToEntity(DBObject dbObject, Class<T> entityClass) throws JsonMappingException, InvalidJSONStringException, FatalMappingException {
        T entity = JSONObjectMapper.mapJSONStringToEntity(dbObject.toString(), entityClass);
        return entity;
    }

    public static DBObject entityToDBObject (Object entity) throws FatalMappingException {
        return (DBObject)JSON.parse(JSONObjectMapper.convertEntityToJSON(entity));
    }
}
