package dataStructure;

import java.util.ArrayList;
import java.util.Collection;

public class MovieTicketList extends ArrayList<MovieTicket>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6092961869599973569L;

	public void add(int id, String movie_name, String time, String hall, String row, String region, int seat) throws Exception {
		super.add(new MovieTicket(id, movie_name, time, hall, row, region, seat));
	}

}
