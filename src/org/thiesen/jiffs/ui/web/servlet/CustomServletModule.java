package org.thiesen.jiffs.ui.web.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.wicket.guice.GuiceWebApplicationFactory;
import org.apache.wicket.protocol.http.WicketServlet;

import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

public class CustomServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		super.configureServlets();
		
	    bind( WicketServlet.class ).in( Singleton.class );
	    serve( "/*" ).with( WicketServlet.class, getWicketServletParams() );
	
	}

	/**
	 * Provide the init parameters for the Wicket servlet.
	 *
	 * @return a map containing the necessary parameters.
	 */
	private @Nonnull Map<String, String> getWicketServletParams() {
	
	    final Map<String, String> params = new HashMap<String, String>();
	    params.put( "applicationFactoryClassName", GuiceWebApplicationFactory.class.getCanonicalName() );
	    params.put("injectorContextAttribute", Injector.class.getCanonicalName() );
	    return params;
	}
}

