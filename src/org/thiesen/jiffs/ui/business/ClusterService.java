package org.thiesen.jiffs.ui.business;

import org.thiesen.jiffs.ui.business.beans.StoryCluster;

public interface ClusterService {

	public Iterable<StoryCluster> loadClusters();
	
	
}
