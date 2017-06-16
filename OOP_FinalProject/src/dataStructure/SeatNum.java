package dataStructure;

public class SeatNum
{
	
	
	int _numGray=0;
	int _numBlue=0;
	int _numYellow=0;
	int _numRed=0;
	int _numSmall=0;

	
	public SeatNum(String seatNumList) throws Exception 
	{
		String[] seatlist = seatNumList.split(",");
		
		if (seatlist.length == 4) {
			_numGray = Integer.parseInt(seatlist[0]) ;
			_numBlue = Integer.parseInt(seatlist[1]) ;
			_numYellow = Integer.parseInt(seatlist[2]) ;
			_numRed = Integer.parseInt(seatlist[3]) ;
			
		} else if (seatlist.length == 1){
			_numSmall = Integer.parseInt(seatlist[0]) ;
		} else {
			throw new Exception("error seatNumList");
		}
		
		
	}
	

	

	public int getTotal()
	{
		return _numGray + _numBlue + _numYellow + _numRed + _numSmall;
	}
}
