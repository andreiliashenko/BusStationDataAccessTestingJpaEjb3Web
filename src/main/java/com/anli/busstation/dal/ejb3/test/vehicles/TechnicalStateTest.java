package com.anli.busstation.dal.ejb3.test.vehicles;

import com.anli.busstation.dal.ejb3.test.Ejb3FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.vehicles.TechnicalStateImpl;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigInteger;

public class TechnicalStateTest extends com.anli.busstation.dal.sql.test.vehicles.TechnicalStateTest {

    @Override
    protected TechnicalState getNewState(BigInteger id, String description, Integer diffLevel) {
        TechnicalStateImpl state = new TechnicalStateImpl();
        state.setId(id);
        state.setDescription(description);
        state.setDifficultyLevel(diffLevel);
        return state;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new com.anli.busstation.dal.ejb3.factories.ProviderFactory();
    }

    @Override
    protected void setEntityId(TechnicalState entity, BigInteger id) {
        ((TechnicalStateImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }
}
