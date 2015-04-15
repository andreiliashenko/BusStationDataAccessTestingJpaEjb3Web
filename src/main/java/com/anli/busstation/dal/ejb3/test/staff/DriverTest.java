package com.anli.busstation.dal.ejb3.test.staff;

import com.anli.busstation.dal.ejb3.test.Ejb3ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.staff.Driver;
import com.anli.busstation.dal.jpa.entities.staff.DriverImpl;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class DriverTest extends com.anli.busstation.dal.sql.test.staff.DriverTest {

    @Override
    protected Driver getNewDriver(BigInteger id, String name, BigDecimal salary, DateTime hiringDate,
            BigInteger skillId, boolean load) {
        DriverImpl driver = new DriverImpl();
        driver.setId(id);
        driver.setName(name);
        driver.setSalary(salary);
        driver.setHiringDate(hiringDate);
        driver.setSkill(getSkillById(skillId, load));
        return driver;
    }

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb3ModuleAccessor();
    }
}
