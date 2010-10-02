package org.thiesen.jiffs.ui.web.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.thiesen.jiffs.ui.business.ClusterService;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class HomePage extends WebPage {
	
	@Inject
	private ClusterService _clusterService;

	public HomePage() {
		add( new Label("helloWorld", "Hello World: " +  Iterables.size( _clusterService.loadClusters() ) ) );
		

	}
	
	
}
