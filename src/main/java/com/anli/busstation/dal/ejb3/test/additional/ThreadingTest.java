package com.anli.busstation.dal.ejb3.test.additional;

import com.anli.busstation.dal.ejb3.test.Ejb3ModuleAccessor;
import com.anli.busstation.dal.test.ModuleAccessor;

public class ThreadingTest extends com.anli.busstation.dal.test.additional.ThreadingTest {

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb3ModuleAccessor();
    }
}
