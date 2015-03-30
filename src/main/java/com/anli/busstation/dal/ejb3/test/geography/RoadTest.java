package com.anli.busstation.dal.ejb3.test.geography;

import com.anli.busstation.dal.ejb3.test.Ejb3FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.geography.Road;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.geography.RoadImpl;
import com.anli.busstation.dal.jpa.entities.geography.StationImpl;
import com.anli.busstation.dal.test.FixtureCreator;
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
    protected ProviderFactory getFactory() {
        return new com.anli.busstation.dal.ejb3.factories.ProviderFactory();
    }

    @Override
    protected void setEntityId(Road entity, BigInteger id) {
        ((RoadImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }
}
