package dataStructure;

public class MovieScore
{
	private int _id;
	private String _movie;

	

	public MovieScore(int id, String movie) {
		this._id = id;
		this._movie = movie;
	}
	
	public int getID() {
		return this._id;
	}
	
	public String getMovie()
	{
		return _movie;
	}
	

}
