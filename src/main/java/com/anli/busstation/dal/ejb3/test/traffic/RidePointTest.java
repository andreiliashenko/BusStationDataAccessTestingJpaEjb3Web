package com.anli.busstation.dal.ejb3.test.traffic;

import com.anli.busstation.dal.ejb3.test.Ejb3FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.geography.StationImpl;
import com.anli.busstation.dal.jpa.entities.traffic.RidePointImpl;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class RidePointTest extends com.anli.busstation.dal.sql.test.traffic.RidePointTest {

    @Override
    protected RidePoint getNewRidePoint(BigInteger id, DateTime arrivalTime, DateTime departureTime,
            BigInteger routePointId, boolean load) {
        RidePointImpl ridePoint = new RidePointImpl();
        ridePoint.setId(id);
        ridePoint.setArrivalTime(arrivalTime);
        ridePoint.setDepartureTime(departureTime);
        ridePoint.setRoutePoint(getRoutePointById(routePointId, load));
        return ridePoint;
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
    protected void setEntityId(RidePoint entity, BigInteger id) {
        ((RidePointImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }
}
