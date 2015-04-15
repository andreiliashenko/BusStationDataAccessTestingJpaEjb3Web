package com.anli.busstation.dal.ejb3.test.geography;

import com.anli.busstation.dal.ejb3.test.Ejb3ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.geography.Road;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.jpa.entities.geography.RoadImpl;
import com.anli.busstation.dal.jpa.entities.geography.StationImpl;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigDecimal;
import java.math.BigInteger;

public class RoadTest extends com.anli.busstation.dal.sql.test.geography.RoadTest {

    @Override
    protected Road getNewRoad(BigInteger id, BigInteger aStationId, Integer length,
            BigDecimal ridePrice, BigInteger zStationId, boolean load) {
        RoadImpl road = new RoadImpl();
        road.setId(id);
        road.setAStation(getStationById(aStationId, load));
        road.setLength(length);
        road.setRidePrice(ridePrice);
        road.setZStation(getStationById(zStationId, load));
        return road;
    }

    @Override
    protected void nullifyStationCollections(Station station) {
        StationImpl stationImpl = (StationImpl) station;
        stationImpl.setBuses(null);
        stationImpl.setEmployees(null);
    }

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb3ModuleAccessor();
    }
}
