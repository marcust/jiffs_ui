package org.thiesen.jiffs.ui.control;

import org.thiesen.jiffs.ui.business.ServiceModule;
import org.thiesen.jiffs.ui.db.dao.DAOModule;
import org.thiesen.jiffs.ui.web.servlet.CustomServletModule;
import org.thiesen.jiffs.ui.web.wicket.FrontendModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class CustomGuiceServletContextListener extends GuiceServletContextListener {

    private static final Injector INJECTOR = Guice.createInjector(
            new DAOModule(),
            new ServiceModule(),
            new FrontendModule(),
            new CustomServletModule() );


    @Override
    protected Injector getInjector() {
        return INJECTOR;
    }

    public static Injector getGuiceInjector() {
        return INJECTOR;
    }


}
