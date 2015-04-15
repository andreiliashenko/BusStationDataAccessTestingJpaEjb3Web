package com.anli.busstation.dal.ejb3.test;

import com.anli.busstation.dal.ejb3.cache.CacheAccessor;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.BSEntityImpl;
import com.anli.busstation.dal.test.FixtureCreator;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigInteger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ejb3ModuleAccessor implements ModuleAccessor {

    private static final Logger LOG = LoggerFactory.getLogger(Ejb3ModuleAccessor.class);

    @Override
    public ProviderFactory getProviderFactory() {
        return new com.anli.busstation.dal.ejb3.factories.ProviderFactory();
    }

    @Override
    public FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }

    @Override
    public void resetCaches() {
        CacheAccessor accessor;
        try {
            accessor = (CacheAccessor) InitialContext
                    .doLookup(CacheAccessor.class.getCanonicalName());
        } catch (NamingException ex) {
            LOG.error("Could not resolve cache accessor", ex);
            throw new RuntimeException(ex);
        }
        accessor.resetCaches();
    }

    @Override
    public void setEntityId(BSEntity entity, BigInteger id) {
        ((BSEntityImpl) entity).setId(id);
    }
}
