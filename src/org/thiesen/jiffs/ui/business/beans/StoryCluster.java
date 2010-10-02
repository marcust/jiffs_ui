package org.thiesen.jiffs.ui.business.beans;

import java.util.Iterator;

import com.google.inject.internal.ImmutableList;

public class StoryCluster implements Iterable<Story> {

	private final ImmutableList<Story> _stories;

	private StoryCluster(Iterable<Story> stories) {
		super();
		_stories = ImmutableList.copyOf( stories );
	}

	public static StoryCluster create(Iterable<Story> stories) {
		return new StoryCluster( stories );
	}

	@Override
	public Iterator<Story> iterator() {
		return _stories.iterator();
	}


}
