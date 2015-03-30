package com.anli.busstation.dal.ejb3.test.maintenance;

import com.anli.busstation.dal.ejb3.test.Ejb3FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.maintenance.BusRepairment;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.maintenance.BusRepairmentImpl;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class BusRepairmentTest extends com.anli.busstation.dal.sql.test.maintenance.BusRepairmentTest {

    @Override
    protected BusRepairment getNewRepairment(BigInteger id, BigInteger mechanicId, DateTime beginTime,
            DateTime endTime, BigDecimal cost, BigInteger busId, BigDecimal price, boolean load) {
        BusRepairmentImpl repairment = new BusRepairmentImpl();
        repairment.setId(id);
        repairment.setMechanic(getMechanicById(mechanicId, load));
        repairment.setBeginTime(beginTime);
        repairment.setEndTime(endTime);
        repairment.setServiceCost(cost);
        repairment.setBus(getBusById(busId, load));
        repairment.setExpendablesPrice(price);
        return repairment;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new com.anli.busstation.dal.ejb3.factories.ProviderFactory();
    }

    @Override
    protected void setEntityId(BusRepairment entity, BigInteger id) {
        ((BusRepairmentImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }
}
