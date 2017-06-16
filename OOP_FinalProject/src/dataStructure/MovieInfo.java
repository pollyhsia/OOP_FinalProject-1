package dataStructure;

public class MovieInfo
{
	private int _id;
	private String _movie;
	private String _classification;
	private String _descri;
	private int _infor;
	private double _score;
	private MovieTimeList _time;
	private String _hall;
	
	public MovieInfo(int id, String movie, String classification, String descri, int infor, double score, String time, String hall) throws Exception
	{
		this._id = id;
		this._movie = movie;
		this._classification = classification;
		this._descri = descri;
		this._infor = infor;
		this._score = score;
		this._time = new MovieTimeList();
		String[] timelist = time.split("、");
		
		// 這邊要改
		for(String t :timelist) {
			int h = Integer.parseInt(t.split(":")[0]);
			int m = Integer.parseInt(t.split(":")[1]);
			this._time.add(h,m);
		}
		this._hall = hall;
	}
	
	public int getId()
	{
		return this._id;
	}

	public String getMovie()
	{
		return this._movie;
	}

	public String getCalssification()
	{
		return this._classification;
	}

	public String getDescri()
	{
		return this._descri;
	}

	public int getInfor()
	{
		return this._infor;
	}

	public double getScore()
	{
		return this._score;
	}

	public MovieTimeList getTime()
	{
		return this._time;
	}

	public String getHall()
	{
		return this._hall;
	}

}
