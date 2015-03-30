package com.anli.busstation.dal.ejb3.test.traffic;

import com.anli.busstation.dal.ejb3.test.Ejb3FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.traffic.Ticket;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.geography.StationImpl;
import com.anli.busstation.dal.jpa.entities.traffic.TicketImpl;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class TicketTest extends com.anli.busstation.dal.sql.test.traffic.TicketTest {

    @Override
    protected Ticket getNewTicket(BigInteger id, BigInteger arrivalPointId, String customerName,
            BigInteger departurePointId, BigDecimal price, DateTime saleDate, BigInteger salesmanId,
            Integer seat, boolean sold, boolean load) {
        TicketImpl ticket = new TicketImpl();
        ticket.setId(id);
        ticket.setArrivalPoint(getRidePointById(arrivalPointId, load));
        ticket.setCustomerName(customerName);
        ticket.setDeparturePoint(getRidePointById(departurePointId, load));
        ticket.setPrice(price);
        ticket.setSaleDate(saleDate);
        ticket.setSalesman(getSalesmanById(salesmanId, load));
        ticket.setSeat(seat);
        ticket.setSold(sold);
        return ticket;
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
    protected void setEntityId(Ticket entity, BigInteger id) {
        ((TicketImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }
}
