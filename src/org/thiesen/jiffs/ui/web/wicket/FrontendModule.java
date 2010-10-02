package org.thiesen.jiffs.ui.web.wicket;

import org.apache.wicket.protocol.http.WebApplication;

import com.google.inject.AbstractModule;

public class FrontendModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(WebApplication.class).to(CustomApplication.class);
	}

}
