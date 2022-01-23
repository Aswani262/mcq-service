package com.tms.config;

import com.mongodb.ClientSessionOptions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoDatabase;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDatabaseFactory;

public class MongoServiceSchemaFactory implements MongoDatabaseFactory {
    private PersistenceExceptionTranslator exceptionTranslator;


    @Override
    public MongoDatabase getMongoDatabase() throws DataAccessException {
        return null;
    }

    @Override
    public MongoDatabase getMongoDatabase(String dbName) throws DataAccessException {
        return getMongoDatabase();
    }

    @Override
    public PersistenceExceptionTranslator getExceptionTranslator() {
        return null;
    }

    @Override
    public ClientSession getSession(ClientSessionOptions options) {
        return null;
    }

    @Override
    public MongoDatabaseFactory withSession(ClientSession session) {
        return null;
    }
}
