package dataStructure;

import java.util.ArrayList;

public class SeatNumList extends ArrayList<SeatNum>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1183142943667244285L;

	public void add(String seatNumList) throws Exception {
		super.add(new SeatNum(seatNumList));
	}

}
