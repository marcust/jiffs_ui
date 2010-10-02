package org.thiesen.jiffs.ui.business.impl;

import org.thiesen.jiffs.ui.business.ClusterService;
import org.thiesen.jiffs.ui.business.beans.Story;
import org.thiesen.jiffs.ui.business.beans.StoryCluster;
import org.thiesen.jiffs.ui.db.beans.StoryClusterDBO;
import org.thiesen.jiffs.ui.db.beans.StoryDBO;
import org.thiesen.troy.TroyDAO;

import com.google.inject.Inject;
import com.google.inject.internal.Function;
import com.google.inject.internal.Iterables;

public class ClusterServiceImpl implements ClusterService {

	private static class ToStoryClusterFunction implements
			Function<StoryClusterDBO, StoryCluster> {

		public TroyDAO<StoryDBO> _funcStoryDAO;

		public ToStoryClusterFunction(TroyDAO<StoryDBO> storyDAO) {
			_funcStoryDAO = storyDAO;
		}

		@Override
		public StoryCluster apply(StoryClusterDBO dbo) {
			return StoryCluster.create( transformStory( _funcStoryDAO.query().in( "storyUri", dbo.getStoryUris() ) ) );
		}
		
		

	}

	private final TroyDAO<StoryClusterDBO> _storyClusterDAO;
	private final TroyDAO<StoryDBO> _storyDAO;

	
	@Inject
	private ClusterServiceImpl(TroyDAO<StoryClusterDBO> clusterDAO,
			final TroyDAO<StoryDBO> storyDAO ) {
		_storyClusterDAO = clusterDAO;
		_storyDAO = storyDAO;
	}

	public static Iterable<Story> transformStory(Iterable<StoryDBO> in) {
		return Iterables.transform( in , new Function<StoryDBO, Story>() {

			@Override
			public Story apply(StoryDBO dbo) {
				return Story.create(dbo.getTitle(), dbo.getText());
			}
			
		}
		);
	}

	@Override
	public Iterable<StoryCluster> loadClusters() {
		Iterable<StoryClusterDBO> allClusters = _storyClusterDAO.query().findAll();
		
		
		
		return transformCluster( allClusters );
	
	}

	private Iterable<StoryCluster> transformCluster(
			Iterable<StoryClusterDBO> allClusters) {
		return Iterables.transform( allClusters , new ToStoryClusterFunction( _storyDAO ) );
	}
	
	
	
}
