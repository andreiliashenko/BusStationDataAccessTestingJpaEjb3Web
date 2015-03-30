package com.anli.busstation.dal.ejb3.test.vehicles;

import com.anli.busstation.dal.ejb3.test.Ejb3FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.vehicles.GasLabel;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.vehicles.GasLabelImpl;
import com.anli.busstation.dal.test.FixtureCreator;
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
    protected ProviderFactory getFactory() {
        return new com.anli.busstation.dal.ejb3.factories.ProviderFactory();
    }

    @Override
    protected void setEntityId(GasLabel entity, BigInteger id) {
        ((GasLabelImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }
}
