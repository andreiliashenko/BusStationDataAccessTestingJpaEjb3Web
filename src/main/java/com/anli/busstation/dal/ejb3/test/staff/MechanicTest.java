package com.anli.busstation.dal.ejb3.test.staff;

import com.anli.busstation.dal.ejb3.test.Ejb3FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.staff.Mechanic;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.jpa.entities.staff.MechanicImpl;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class MechanicTest extends com.anli.busstation.dal.sql.test.staff.MechanicTest {

    @Override
    protected Mechanic getNewMechanic(BigInteger id, String name, BigDecimal salary, DateTime hiringDate,
            BigInteger skillId, boolean load) {
        MechanicImpl mechanic = new MechanicImpl();
        mechanic.setId(id);
        mechanic.setName(name);
        mechanic.setSalary(salary);
        mechanic.setHiringDate(hiringDate);
        mechanic.setSkill(getSkillById(skillId, load));
        return mechanic;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new com.anli.busstation.dal.ejb3.factories.ProviderFactory();
    }

    @Override
    protected void setEntityId(Mechanic entity, BigInteger id) {
        ((MechanicImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }
}
