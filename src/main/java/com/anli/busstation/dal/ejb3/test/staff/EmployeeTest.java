package com.anli.busstation.dal.ejb3.test.staff;

import com.anli.busstation.dal.ejb3.test.Ejb3FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.staff.Driver;
import com.anli.busstation.dal.interfaces.entities.staff.Employee;
import com.anli.busstation.dal.interfaces.entities.staff.Mechanic;
import com.anli.busstation.dal.interfaces.entities.staff.Salesman;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.staff.DriverImpl;
import com.anli.busstation.dal.jpa.entities.staff.EmployeeImpl;
import com.anli.busstation.dal.jpa.entities.staff.MechanicImpl;
import com.anli.busstation.dal.jpa.entities.staff.SalesmanImpl;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class EmployeeTest extends com.anli.busstation.dal.sql.test.staff.EmployeeTest {

    @Override
    protected Driver getNewDriver(BigInteger id, String name, BigDecimal salary, DateTime hiringDate,
            BigInteger skillId, boolean load) {
        DriverImpl driver = new DriverImpl();
        driver.setId(id);
        driver.setName(name);
        driver.setSalary(salary);
        driver.setHiringDate(hiringDate);
        driver.setSkill(getDriverSkillById(skillId, load));
        return driver;
    }

    @Override
    protected Mechanic getNewMechanic(BigInteger id, String name, BigDecimal salary, DateTime hiringDate,
            BigInteger skillId, boolean load) {
        MechanicImpl mechanic = new MechanicImpl();
        mechanic.setId(id);
        mechanic.setName(name);
        mechanic.setSalary(salary);
        mechanic.setHiringDate(hiringDate);
        mechanic.setSkill(getMechanicSkillById(skillId, load));
        return mechanic;
    }

    @Override
    protected Salesman getNewSalesman(BigInteger id, String name, BigDecimal salary, DateTime hiringDate,
            Integer totalSales) {
        SalesmanImpl salesman = new SalesmanImpl();
        salesman.setId(id);
        salesman.setName(name);
        salesman.setSalary(salary);
        salesman.setHiringDate(hiringDate);
        salesman.setTotalSales(totalSales);
        return salesman;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new com.anli.busstation.dal.ejb3.factories.ProviderFactory();
    }

    @Override
    protected void setEntityId(Employee entity, BigInteger id) {
        ((EmployeeImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }
}
