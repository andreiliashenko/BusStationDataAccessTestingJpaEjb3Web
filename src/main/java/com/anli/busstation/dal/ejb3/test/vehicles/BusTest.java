package com.anli.busstation.dal.ejb3.test.vehicles;

import com.anli.busstation.dal.ejb3.test.Ejb3FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.vehicles.BusImpl;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigInteger;

public class BusTest extends com.anli.busstation.dal.sql.test.vehicles.BusTest {

    @Override
    protected Bus getNewBus(BigInteger id, BigInteger modelId, String plate,
            BigInteger stateId, boolean load) {
        BusImpl bus = new BusImpl();
        bus.setId(id);
        bus.setModel(getModelById(modelId, load));
        bus.setPlate(plate);
        bus.setState(getStateById(stateId, load));
        return bus;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new com.anli.busstation.dal.ejb3.factories.ProviderFactory();
    }

    @Override
    protected void setEntityId(Bus entity, BigInteger id) {
        ((BusImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }
}
