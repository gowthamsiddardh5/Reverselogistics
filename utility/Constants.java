package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

	//ADMIN
	public static final String ADMIN_EMAIL = "admin@gmail.com";
	public static final String ADMIN_PASS = "admin@123";
	
	//CLIENT
	public static final String RN_EMAIL = "renovate@gmail.com";
	public static final String RN_PASS = "renovate@123";

	//LOCATION 
	public static final String PROJ_LOCATION = "D:\\Yuvi_workspace\\REVERSE_LOGI\\";//"G:\\SISPL\\Z-2023\\SOURCE_CODE\\REVERSE_LOGI\\";
	public static final String PROJ_LOCATION_FOR_CSV = "D:/Yuvi_workspace/REVERSE_LOGI/";//"G:/SISPL/Z-2023/SOURCE_CODE/REVERSE_LOGI/";

	
	static Date now = new Date();
	String date = now.toString();
	static String DATE_FORMAT = "dd-MM-yyyy";
	static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	public static final String CURRENT_DATE = sdf.format(now);
}
