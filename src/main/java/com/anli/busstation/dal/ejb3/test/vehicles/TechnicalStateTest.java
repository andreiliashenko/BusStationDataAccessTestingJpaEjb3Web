package com.anli.busstation.dal.ejb3.test.vehicles;

import com.anli.busstation.dal.ejb3.test.Ejb3ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;
import com.anli.busstation.dal.jpa.entities.vehicles.TechnicalStateImpl;
import com.anli.busstation.dal.test.ModuleAccessor;
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
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb3ModuleAccessor();
    }
}
