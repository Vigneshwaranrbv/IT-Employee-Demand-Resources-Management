package techteam;
import java.util.Date;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
public class DateCal {

	public static int getCountDate(String da1, String da2) {
		
		
		        //start date
				int d1 = Integer.parseInt(da1.substring(0, 2));
				int m1 = Integer.parseInt(da1.substring(3, 5));
				int y1 = Integer.parseInt(da1.substring(6));
				
				//end date
				int d2 = Integer.parseInt(da2.substring(0, 2));
				int m2 = Integer.parseInt(da2.substring(3, 5));
				int y2 = Integer.parseInt(da2.substring(6));
				
				// creating the date 1 with sample input date.
				Date date1 = new Date(y1, m1, d1);
				
				// creating the date 2 with sample input date.
				Date date2 = new Date(y2, m2, d2);
				
				// getting milliseconds for both dates
				long date1InMs = date1.getTime();
				System.out.println(date1InMs);
				long date2InMs = date2.getTime();
				System.out.println(date2InMs);
				// getting the diff between two dates.
				long timeDiff = 0;
				if(date1InMs > date2InMs) {
					timeDiff = date1InMs - date2InMs;
				} else {
					timeDiff = date2InMs - date1InMs;
				}
				System.out.println(timeDiff);
				// converting diff into days
				int daysDiff = (int) (timeDiff / (1000 * 60 * 60* 24));
				
				return daysDiff;
		
	}
	
	public static void main(String a[]) {
		//getCountDate("d","s");
		String da1 = "01/11/2020";
		String da2 = "30/11/2020";
		System.out.println(getCountDate(da1,da2));
	}
	
	
}
