package com.anli.busstation.dal.ejb3.test;

import com.anli.busstation.dal.test.servlet.AbstractTester;

public class Ejb3Tester extends AbstractTester {

    @Override
    protected String getBasePackage() {
        return "com.anli.busstation.dal.ejb3.test";
    }

    @Override
    protected String getExecutorUrl() {
        return "/executor";
    }

    @Override
    protected String getTitle() {
        return "Bus Station Data Access Integration Tests (JpaEjb3 implementation)";
    }
}
