package dataStructure;

import java.util.ArrayList;

public class MovieScoreList extends ArrayList<MovieScore>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 875205461417844881L;

	public void add(int id, String name) {
		super.add(new MovieScore(id, name));
	}
}
