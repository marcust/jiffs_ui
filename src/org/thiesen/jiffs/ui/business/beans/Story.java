package org.thiesen.jiffs.ui.business.beans;

public class Story {

	private final String _title;
	private final String _text;
	
	private Story(String title, String text) {
		super();
		_title = title;
		_text = text;
	}
	
	public static Story create(String title, String text) {
		return new Story( title, text );
	}
	
	
}
