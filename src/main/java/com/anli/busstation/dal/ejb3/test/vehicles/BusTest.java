package com.anli.busstation.dal.ejb3.test.vehicles;

import com.anli.busstation.dal.ejb3.test.Ejb3ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.vehicles.Bus;
import com.anli.busstation.dal.jpa.entities.vehicles.BusImpl;
import com.anli.busstation.dal.test.ModuleAccessor;
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
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb3ModuleAccessor();
    }
}
