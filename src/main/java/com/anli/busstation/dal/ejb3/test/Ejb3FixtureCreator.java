package com.anli.busstation.dal.ejb3.test;

import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.BSEntityImpl;
import com.anli.busstation.dal.sql.test.SqlFixtureCreator;
import java.math.BigInteger;

public class Ejb3FixtureCreator extends SqlFixtureCreator {

    @Override
    protected void setObjectId(BSEntity entity, BigInteger id) {
        ((BSEntityImpl) entity).setId(id);
    }

    @Override
    protected ProviderFactory getFactory() {
        return new com.anli.busstation.dal.ejb3.factories.ProviderFactory();
    }
}
