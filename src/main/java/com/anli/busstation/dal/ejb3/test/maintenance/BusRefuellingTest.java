package com.anli.busstation.dal.ejb3.test.maintenance;

import com.anli.busstation.dal.ejb3.test.Ejb3ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.maintenance.BusRefuelling;
import com.anli.busstation.dal.jpa.entities.maintenance.BusRefuellingImpl;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class BusRefuellingTest extends com.anli.busstation.dal.sql.test.maintenance.BusRefuellingTest {

    @Override
    protected BusRefuelling getNewRefuelling(BigInteger id, BigInteger mechanicId, DateTime beginTime,
            DateTime endTime, BigDecimal cost, BigInteger busId, Integer volume, boolean load) {
        BusRefuellingImpl busRefuelling = new BusRefuellingImpl();
        busRefuelling.setId(id);
        busRefuelling.setMechanic(getMechanicById(mechanicId, load));
        busRefuelling.setBeginTime(beginTime);
        busRefuelling.setEndTime(endTime);
        busRefuelling.setServiceCost(cost);
        busRefuelling.setBus(getBusById(busId, load));
        busRefuelling.setVolume(volume);
        return busRefuelling;
    }

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb3ModuleAccessor();
    }
}
