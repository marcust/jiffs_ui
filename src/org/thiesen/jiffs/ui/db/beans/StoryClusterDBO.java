package org.thiesen.jiffs.ui.db.beans;

import java.util.List;

import org.joda.time.DateTime;
import org.thiesen.troy.annotations.TroyCollectionName;

@TroyCollectionName("storyCluster")
public class StoryClusterDBO {
	
	private final DateTime _createdAt;
	private final List<String> _storyUris;
	
	private StoryClusterDBO(DateTime createdAt, List<String> storyUris ) {
		super();
		_createdAt = createdAt;
		_storyUris = storyUris;
	}

	public DateTime getCreatedAt() {
		return _createdAt;
	}

	public List<String> getStoryUris() {
		return _storyUris;
	}

	
	

}
