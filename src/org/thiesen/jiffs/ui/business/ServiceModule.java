package org.thiesen.jiffs.ui.business;

import org.thiesen.jiffs.ui.business.impl.ClusterServiceImpl;

import com.google.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind( ClusterService.class ).to( ClusterServiceImpl.class );
	}

}
