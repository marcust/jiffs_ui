package org.thiesen.jiffs.ui.db.beans;

import java.net.URI;

import org.thiesen.troy.annotations.TroyCollectionName;

@TroyCollectionName("story")
public class StoryDBO {

	private final URI _storyUri;
	private final String _title;
	private final String _text;
	
	private StoryDBO(URI _storyUri, String _title, String _text) {
		super();
		this._storyUri = _storyUri;
		this._title = _title;
		this._text = _text;
	}

	public URI getStoryUri() {
		return _storyUri;
	}

	public String getTitle() {
		return _title;
	}

	public String getText() {
		return _text;
	}
	


}
