package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import dataStructure.*;

public class Movie_DAO {
	// SQL Global 變數初始化
	Connection connection = null;
	// query , insert, update statement
	PreparedStatement qStmt  = null;
	PreparedStatement insertStmt = null;
	PreparedStatement updateStmt = null;
	// result set
	ResultSet result = null;
	
	// big_romm List, region List
	private List<String> big_rooms = Arrays.asList("武當","華山","少林");
	private List<String> region = Arrays.asList("gray","blue","yellow","red");
	
	/**
	 * 這個function 用來建立連線
	 * @return Connection : 回傳連線
	 * @throws SQLException : 連線有誤時
	 */
	private Connection getConnection() throws SQLException {
	  try {
	    return ConnectionFactory.getInstance().getConnection();
	  } catch (SQLException e) {
	    System.out.println(e.getMessage());
	  }
	  return null;
	}
	
	/**
	 * 用來關閉DB連線
	 *  @param conn : 欲關閉的連線
	 */
	private void closeConnection(Connection conn) {
		ConnectionFactory.closeConnection(conn);
	}
	
	/**
	 * 這個function用來拿User的Info
	 * @param userID : 輸入User ID
	 * @return Users : 回傳一個Users的object,裡面包含user 的資訊
	 * @throws ticketSystemException : 如果撈不到使用者資料時
	 */
//	public Users getUser(int userID) throws ticketSystemException{
//		// 初始化一個Users object
//		Users user = null;
//		try {
//		    connection = getConnection();
//		    qStmt = connection.prepareStatement("SELECT * FROM Users "
//		        + "WHERE id = ?");
//		    qStmt.setInt(1, userID);
//		    result = qStmt.executeQuery();
//		    if(result.next())
//		    	// 從SQL中獲得user 資料建構Users Object
//		    	user = new Users(result.getInt("id"),result.getString("name"),result.getInt("age"));
//		} catch (SQLException e) {
//		    throw new ticketSystemException(e.getMessage() + "-> 無法獲得該使用者資訊");
//		} finally {
//		    closeConnection(connection);
//		}
//		return user;
//	}
//	
//	/**
//	 * 這個function用來回傳MovieInfo Object
//	 * @param movieID : 輸入之movieID
//	 * @return MovieInfo : 電影資料的object
//	 * @throws ticketSystemException : 如果沒有這比電影資料
//	 */
//	public MovieInfo getMovieInfo(int movieID) throws ticketSystemException{
//	  MovieInfo movie_info = null;
//	  MovieTimeList timeList = new MovieTimeList();
//	  try {
//		  connection = getConnection();
//		  qStmt = connection.prepareStatement("SELECT * FROM Movie_info "
//				  + "WHERE id = ?");
//		  qStmt.setInt(1, movieID);
//		  result = qStmt.executeQuery();
//		  if(result.next()){
//	      String movie_name = result.getString("movie");
//	      String classification = result.getString("classification");
//	      String description = result.getString("descri");
//	      int infor = result.getInt("infor");
//	      Double score = result.getDouble("score");
//	     
//	      // 把七個欄位都先拿出來，不是null的再加進去MovieTimeList
//	      for(int i = 1; i < 7; i++) {
//	    	  String tmp_time = result.getString("time_" + i);
//	    	  if(tmp_time != null)
//	    		  timeList.add(tmp_time);
//	      }
//	      String hall = result.getString("hall");
//	      
//	      // new 一個MovieInfo 物件
//	      movie_info = new MovieInfo(movieID, movie_name, classification, description, infor, score, timeList, hall);
//	    }
//	  } catch (Exception e) {
//	    throw new ticketSystemException(e.getMessage() + "cannot get Movie Info");
//	  } finally {
//	    closeConnection(connection);
//	  }
//	  return movie_info;
//	}
	
	
	public ScoreSearchList getScoreMovie(double score)
	{
		ScoreSearchList list = new ScoreSearchList();
		try
		{
			connection = getConnection();
			qStmt = connection.prepareStatement("SELECT id, movie FROM movie_info WHERE score > ?");
			qStmt.setDouble(1, score);
			result = qStmt.executeQuery();
			
			
			
			while (result.next())
			{
				list.add(result.getInt("id"), result.getString("movie"));
			}

		} catch (SQLException e)
		{
			System.out.println(e.getMessage() + "-> cannot get any movie");
		}
		return list;
	}
	
	
	
	
	
	
}
