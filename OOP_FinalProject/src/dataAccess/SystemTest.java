package dataAccess;

import dataStructure.*;

public class SystemTest
{

	public static void main(String[] args)
	{

		
		Movie_DAO system = new Movie_DAO();
		ScoreSearchList movie = system.getScoreMovie(5);
		 for (ScoreSearch e : movie){
				 System.out.println(e.getID()+" "+e.getMovie());
				 }
		
	}

}
