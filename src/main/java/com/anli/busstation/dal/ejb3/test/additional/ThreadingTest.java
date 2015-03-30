package com.anli.busstation.dal.ejb3.test.additional;

import com.anli.busstation.dal.ejb3.test.Ejb3FixtureCreator;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;

public class ThreadingTest extends com.anli.busstation.dal.test.additional.ThreadingTest {

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb3FixtureCreator();
    }

    @Override
    protected ProviderFactory getFactory() {
        return new com.anli.busstation.dal.ejb3.factories.ProviderFactory();
    }
}
