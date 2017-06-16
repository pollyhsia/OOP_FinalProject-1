package dataStructure;

import java.util.ArrayList;
import java.util.Collection;

public class MovieTimeList extends ArrayList<MovieTime>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8991888755859362344L;

	public void add(int h, int m) throws Exception
	{
		super.add(new MovieTime(h, m));
	}

	public MovieTimeList findBetween(MovieTime early, MovieTime late)
	{
		MovieTimeList result = new MovieTimeList();

		int n = this.size();

		for (int i = 0; i < n; i++)
		{
			if (this.get(i).compareAfter(early) && this.get(i).compareBefore(late))
			{
				this.get(i).setSession(i);
				result.add(this.get(i));
			} 
		}

		return result;
	}

	public String toString()
	{
		String result = "";
		int n = this.size();

		if (n > 0)
		{
			result = this.get(0).toString();
			for (int i = 1; i < n; i++)
			{
				result += "、" + this.get(i);
			}
		}
		
		return result;
	}
}
