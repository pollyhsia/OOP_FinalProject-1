package dataStructure;


public class MovieTime
{
	private int session = -1;
	private int _hour;
	private int _min;

	private boolean checkTime(int hour, int min) {
		boolean isRight = true;
		if (hour < 0 || hour > 24)
			isRight = false;

		if (min < 0 || min > 60)
			isRight = false;
		
		return isRight;
	}
	
	
	public MovieTime(int hour, int min) throws Exception
	{
		if (!checkTime(hour, min))
			throw new Exception("No this time " + hour+":"+min);

		this._hour = hour;
		this._min = min;
	}
	
	public MovieTime(String time) throws Exception {
		time = DBBuilder.convertChar(time);
		int hour = Integer.parseInt(time.split(":")[0]);
		int min = Integer.parseInt(time.split(":")[1]);
		
		if (!checkTime(hour, min))
			throw new Exception("No this time " + hour+":"+min);

		this._hour = hour;
		this._min = min;
	}

	public int getHour()
	{
		return this._hour;
	}

	public int getMin()
	{
		return this._min;
	}

	public int getSession()
	{
		return this.session;
	}

	public void setSession(int session)
	{
		this.session = session;
	}
	
	public boolean compareBefore(MovieTime time)
	{
		boolean isBefore = false;
		if (this.getHour() == time.getHour())
		{
			if (this.getMin() <= time.getMin())
				isBefore = true;
		} else
		{

			if (this.getHour() <= time.getHour())
				isBefore = true;
		}

		return isBefore;
	}

	public boolean compareAfter(MovieTime time)
	{
		boolean isAfter = false;
		if (this.getHour() == time.getHour())
		{
			if (this.getMin() >= time.getMin())
				isAfter = true;
		} else
		{
			if (this.getHour() >= time.getHour())
				isAfter = true;
		}

		return isAfter;
	}

	public String toString()
	{
		return String.format("%02d:%02d", this._hour, this._min);
	}

}
