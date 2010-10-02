package org.thiesen.jiffs.ui.web.wicket;

import javax.annotation.Nonnull;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.protocol.http.WebApplication;
import org.thiesen.jiffs.ui.web.wicket.pages.HomePage;

public class CustomApplication extends WebApplication {

	public CustomApplication() {
		// Fix for https://issues.apache.org/jira/browse/WICKET-2887
		Application.set(this);
	}
	
	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}




}
