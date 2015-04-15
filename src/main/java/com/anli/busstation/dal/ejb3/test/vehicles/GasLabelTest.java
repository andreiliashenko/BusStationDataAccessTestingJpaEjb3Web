package com.anli.busstation.dal.ejb3.test.vehicles;

import com.anli.busstation.dal.ejb3.test.Ejb3ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.vehicles.GasLabel;
import com.anli.busstation.dal.jpa.entities.vehicles.GasLabelImpl;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigDecimal;
import java.math.BigInteger;

public class GasLabelTest extends com.anli.busstation.dal.sql.test.vehicles.GasLabelTest {

    @Override
    protected GasLabel getNewGasLabel(BigInteger id, String name, BigDecimal price) {
        GasLabelImpl label = new GasLabelImpl();
        label.setId(id);
        label.setName(name);
        label.setPrice(price);
        return label;
    }

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb3ModuleAccessor();
    }
}
