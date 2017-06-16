package dataStructure;

public class MoviePlayTime 
{
	private int _id;
	private String _movie;
	private int _infor;
	private MovieTimeList _time;
	private String _hall;
	private SeatNumList _seatNum = new SeatNumList();
	
	public MoviePlayTime(int id, String movie, int infor, String time, String hall, String time_1, String time_2, String time_3, String time_4, String time_5, String time_6, String time_7) throws Exception {
		this._id = id;
		this._movie = movie;
		this._time = new MovieTimeList();
		this._infor = infor;
		String[] timelist = time.split("、");
		for(String t :timelist) {
			this._time.add(new MovieTime(t));
		}
		
		this._hall = hall;
		_seatNum.add(time_1);
		_seatNum.add(time_2);
		_seatNum.add(time_3);
		_seatNum.add(time_4);
		_seatNum.add(time_5);
		_seatNum.add(time_6);
		_seatNum.add(time_7);
		
		
	}
	
	public MoviePlayTime(MoviePlayTime m, MovieTimeList timelist) {
		this._id = m.getID();
		this._movie = m.getMovie();
		this._infor = m.get_infor();
		this._time = timelist;
		this._hall = m.getHall();
		this._seatNum = m.getSeatNum();
		
	}
	
	public MoviePlayTime(){
		this._id = getID();
		this._movie = getMovie();
		this._infor = get_infor();
		this._time = new MovieTimeList();
		this._hall = getHall();
		this._seatNum = getSeatNum();
	}
	
	public int getID() 
	{
		return this._id;
	}
	
	public String getMovie() {
		return this._movie;
	}
	
	public int get_infor()
	{
		return this._infor;
	}


	public MovieTimeList getMovieTimeList() {
		return _time;
	}
	
	public String getHall() {
		return _hall;
	}
	
	public SeatNumList getSeatNum() {
		return _seatNum;
	}
	
	public String toString() {
		String result;
		
		result = this._movie +"  "+ this._time  +"  "+ this._infor;
		
		return result;
	}
	
	
}
