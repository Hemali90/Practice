

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;


public class DateTest {
	public static void test(String currentTime) {
		
		
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			cal.setTime(dateFormat.parse(currentTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		int minute=cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		cal.add(Calendar.SECOND, -(minute%5)*60-second);

		Date latest5minTimestamp = cal.getTime();
		
		//cal.add(Calendar.DAY_OF_YEAR,-1);
		System.out.println("start time:"+dateFormat.format(latest5minTimestamp));
		for(int i = 0 ; i<30; i=i+5){
		cal.add(Calendar.MINUTE, -5);
		Date fiveMinAgo= cal.getTime();
		System.out.println(dateFormat.format(fiveMinAgo));
		}
		
		Date oneDayBefore= cal.getTime();
		
		System.out.println("end time"+dateFormat.format(oneDayBefore));
		
	    //String startRowkey = Utils.generateRowKey(ROW_KEY_DELIMITER, url, dateFormat.format(latest5minTimestamp));
	    	    
		//String stopRowkey = Utils.generateRowKey(ROW_KEY_DELIMITER, url, dateFormat.format(oneDayBefore));
		
	}
	
	public static Long getPastHourEpoch(Long timestamp){
		Calendar cal = new GregorianCalendar();
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
		String date = formatter.format(new Date (timestamp));
		try {
			cal.setTime(formatter.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		cal.add(Calendar.HOUR, -1);
		Date pastHour = cal.getTime();
		
		Long epoch = pastHour.getTime();
		return epoch;	
	}
	
	public static void testepoch(Long epochTime){
		Calendar cal = new GregorianCalendar();
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
		String date = formatter.format(new java.util.Date (epochTime));
		
		
		System.out.println("Current time "+epochTime+ " "+date);
		
		
		try {
			cal.setTime(formatter.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		int minute=cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		cal.add(Calendar.SECOND, -minute*60-second);
		Date lastHour = cal.getTime();
		
		Long epoch = lastHour.getTime();
		
		
		for(int i = 0 ; i< 23 ;i++){
			
			if (i == 0) System.out.println("24th hour is "+epoch+ " : "+formatter.format(new Date(epoch)));
			System.out.println((23 - i)+"th hour is "+ getPastHourEpoch(epoch) +" : "+ formatter.format(new Date(getPastHourEpoch(epoch))));
			epoch = getPastHourEpoch(epoch);
		}
		
	}
	
	public static void archiveTest(Long startTime, Long endTime){
		Calendar cal = new GregorianCalendar();
		String cq="";
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
		String date = formatter.format(new java.util.Date (startTime));
		
		try {
			cal.setTime(formatter.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		while(true){
			
			Date pastDay = cal.getTime();
			System.out.println("day/time is "+formatter.format(pastDay)+ " epoch "+ pastDay.getTime());
			cal.add(Calendar.DAY_OF_MONTH, -1);
			if(pastDay.getTime() == endTime){
			break;
			}
			
		}
		
		int hour = 0;
		int minute = 0;
		for(int i =0 ;i < 300; i++){
			cq = String.format("%02d", hour)+String.format("%02d", minute);
			System.out.println(cq);
			minute = minute+5;
			if(minute == 60){
				hour = hour+1;
				minute = 0;
			}
		}
		
		/*for( int i = 0; i< 30 ; i++){
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date pastDay = cal.getTime();
		System.out.println(30-i +"th day/time is "+formatter.format(pastDay)+ " epoch "+ pastDay.getTime());
		}*/
		
	}
	
	public static void newCurrentTest(){
		List<String> tableNameList = new LinkedList<String>();
		String[] tableNames;
		Long currentTime = System.currentTimeMillis();
		Calendar cal = new GregorianCalendar();
		
		DateFormat formatter = new SimpleDateFormat("MM_dd_yyy HH:mm:ss");
		
	    cal.setTime(new Date(currentTime));

		for(int i = 0 ; i< 2; i++){		
			Date pastDay = cal.getTime();
			String date = formatter.format(pastDay);
			String tableName = date.split(" ")[0];
			tableNameList.add(tableName);
			System.out.println("day/time is "+date+ " epoch "+ pastDay.getTime()+ " hour"+ cal.get(Calendar.HOUR_OF_DAY));
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		
		tableNames = tableNameList.toArray(new String[tableNameList.size()]);
		
		for(String table : tableNames){
			System.out.println(table);
		}
		
		
	}
	
	public static Integer getHour(Long timestamp) {
    	GregorianCalendar gc = new GregorianCalendar();
    	gc.setTimeInMillis(timestamp);
    	gc.setTimeZone(TimeZone.getTimeZone("PST"));
    	return gc.get(GregorianCalendar.HOUR_OF_DAY);
	}
	public static Set<String> getRowKeysCurTableTwo(String domain,int curHour){
		Set<String> rowKeySet = new LinkedHashSet<String>();
		int hour = 24;
		
		while(true){
			if(hour <= curHour){
				break;
			}
			rowKeySet.add(domain+";"+String.format("%02d", hour--));

			
		}
		return rowKeySet;
	}
	public static Set<String> getRowKeysCurTableOne(String domain,int curHour){
		Set<String> rowKeySet = new LinkedHashSet<String>();
		
		while(true){
			if(curHour < 1){
				break;
			}
			rowKeySet.add(domain+";"+String.format("%02d", curHour--));
			

			
		}
		return rowKeySet;
	}
	
	public static String[] generateVolumeCurrentTableNames(Long currentTime){
		String[] tableNames = new String[2];
		
		Calendar cal = new GregorianCalendar();
		DateFormat formatter = new SimpleDateFormat("MM_dd_yyyy HH:mm:ss");
		
	    cal.setTime(new Date(currentTime));

		for(int i = 0 ; i< 2; i++){		
			Date pastDay = cal.getTime();
			String date = formatter.format(pastDay);
			String tableName = date.split(" ")[0];
			tableNames[i] = tableName;
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		
		return tableNames;
	}	
	
	public static void main(String args[]){
		//test("2016/07/26 16:06:54");
		//testepoch(System.currentTimeMillis());
		/*archiveTest(1470294000000L,1467702000000L);
		
		String test = new String();
		if(test.equals(""))
		System.out.println("Null string"+test);
		
		test = "test";
		System.out.println("Test string "+test);
		//newCurrentTest();
*/	
		String tables[];
		tables= generateVolumeCurrentTableNames(System.currentTimeMillis());
		for(String table: tables){
			System.out.println(table);
		}
		
		
		/*System.out.println("Hour"+getHour(System.currentTimeMillis()));
		
		System.out.println("Table one");
		Set<String> testSetOne = getRowKeysCurTableOne("google.com",01);
		for(String s : testSetOne ){
			System.out.println(s);
		}
		
		System.out.println("Table two");
		Set<String> testSet = getRowKeysCurTableTwo("google.com",01);
		for(String s : testSet ){
			System.out.println(s);
		}
		*/
		
		
	}
}
