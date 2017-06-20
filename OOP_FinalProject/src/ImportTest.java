import dataStructure.*;

public class ImportTest
{

	public static void main(String[] args)
	{
		DBBuilder builder = new DBBuilder();

		try
		{
			builder.createDB();
		} catch (Exception e)
		{
			System.out.println(e);
		}

	}

}
