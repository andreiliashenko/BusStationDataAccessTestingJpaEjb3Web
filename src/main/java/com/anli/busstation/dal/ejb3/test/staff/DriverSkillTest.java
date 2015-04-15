package com.anli.busstation.dal.ejb3.test.staff;

import com.anli.busstation.dal.ejb3.test.Ejb3ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.staff.DriverSkill;
import com.anli.busstation.dal.jpa.entities.staff.DriverSkillImpl;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigInteger;

public class DriverSkillTest extends com.anli.busstation.dal.sql.test.staff.DriverSkillTest {

    @Override
    protected DriverSkill getNewDriverSkill(BigInteger id, String name, Integer maxPass,
            Integer maxRideLength) {
        DriverSkillImpl skill = new DriverSkillImpl();
        skill.setId(id);
        skill.setName(name);
        skill.setMaxPassengers(maxPass);
        skill.setMaxRideLength(maxRideLength);
        return skill;
    }

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb3ModuleAccessor();
    }
}
