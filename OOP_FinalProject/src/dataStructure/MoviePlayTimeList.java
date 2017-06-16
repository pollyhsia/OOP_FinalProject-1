package dataStructure;

import java.util.ArrayList;
import java.util.Collection;

public class MoviePlayTimeList extends ArrayList<MoviePlayTime>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -153644060856122815L;

	public void add(int id, String movie, int infor, String time, String hall, String time_1, String time_2, String time_3, String time_4, String time_5, String time_6, String time_7) throws Exception
	{
		super.add(new MoviePlayTime(id, movie, infor, time, hall, time_1, time_2, time_3, time_4, time_5, time_6, time_7));
	}
	
	/**
	 * 把所有時間介於early和late的 time 的所有電影場次都找出來
	 * @return
	 */
	public MoviePlayTimeList findBetween(MovieTime early, MovieTime late) {
		MoviePlayTimeList result = new MoviePlayTimeList();
				
		// 目前電影的個數
		int n = this.size();
		
		// 先看過所有的電影
		for(int i=0; i<n; i++) {
			MoviePlayTime movie = this.get(i);
			MovieTimeList timelist = movie.getMovieTimeList();
			// timelist 要和  early 和 late 比較 
			MovieTimeList newTimelist = timelist.findBetween(early, late);
			if (newTimelist.size() > 0) {
				
				result.add(new MoviePlayTime(this.get(i), newTimelist));
			}
		}
		
		return result;
	}
	
	
	public MoviePlayTimeList findRightInfor(int longest, int shortest){
		MoviePlayTimeList result = new MoviePlayTimeList();
		
		// 目前電影的個數
		int n = this.size();
		
		for (int i = 0; i < n; i++){
			MoviePlayTime movie = this.get(i);
			if(movie.get_infor() < longest && movie.get_infor() > shortest)
				result.add(this.get(i));
		}
		
		return result;
	}
	
	
	public MoviePlayTimeList findEnoughSeat(Movie_DAO system, int seatNum){
		MoviePlayTimeList result = new MoviePlayTimeList();
		
		// 目前電影的個數
		int n = this.size();
		
		for (int i = 0; i < n; i++){
			MoviePlayTime movie = this.get(i);
			
			MovieTimeList time = movie.getMovieTimeList();
			boolean[] isEnough = new boolean[time.size()];
			for (int j = 0; j < time.size(); j++){
				
				int movieSession = time.get(j).getSession();
				
				// 從資料庫再抓一次座位表
				// SeatNumList SessionList = system.getRemainSeats_new(movie.getID(), movieSession);
				
				// 自己抓的資料
				SeatNumList SessionList = movie.getSeatNum();
				
				
				SeatNum seatnum = SessionList.get(movieSession);
				
				
				if(seatNum <= seatnum.getTotal())
					isEnough[j] = true;
				else
					isEnough[j] = false;
			}
			
			MovieTimeList time_new = new MovieTimeList(); 
			for(int j=0; j<isEnough.length; j++) {
				if(isEnough[j]) {
					time_new.add(time.get(j));
				}
			}
			
			if(time_new.size() > 0)
				result.add(new MoviePlayTime(this.get(i), time_new));
		}
		
		return result;
	}
	
	
	
	public String toString() {
		String result = "";
		int n = this.size();
		
		if (n>0) {
			result = this.get(0).toString();
			for(int i=1; i<n; i++) {
				result += "\n" + this.get(i);
			}
		}
		
		
		return result;
	}

}
