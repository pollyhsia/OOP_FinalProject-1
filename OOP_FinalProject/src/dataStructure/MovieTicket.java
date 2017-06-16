package dataStructure;

public class MovieTicket
{
	private int id;
	private String movie_name;
	private MovieTime time;
	private String hall;
	private String row;
	private String region;
	private int seat;
	
	public MovieTicket(int id, String movie_name, String time, String hall, String row, String region,int seat) throws Exception
	{
		this.id = id;
		this.movie_name = movie_name;
		this.time = new MovieTime(time);
		this.hall = hall;
		this.row = row;
		this.region = region;
		this.seat =seat;
	}
	
	public int getId()
	{
		return this.id;
	}

	public String getMovie_name()
	{
		return this.movie_name;
	}

	public MovieTime getTime()
	{
		return this.time;
	}

	public String getHall()
	{
		return this.hall;
	}
	
	public String getRow()
	{
		return row;
	}

	public String getRegion()
	{
		return region;
	}

	public int getSeat()
	{
		return this.seat;
	}


}
