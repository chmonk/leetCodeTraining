package search_sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Runnable run = () -> {
			System.out.println("run");
		};
		Runnable run1 = () -> System.out.println("run");
		
		(new Thread(run)).start();;
		(new Thread(run1)).start();;
		

//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//
//		sdf.setLenient(false);
//
//		System.out.println("1999-02-18".replaceAll("-|/", ""));
//
//		Date dgd1 = sdf.parse("1999-02-18".replace("-|/", ""));
//		Date dgd = sdf.parse("1999-13-1".replace("-|/", ""));
//
//		System.out.println(dgd1);
//		System.out.println(dgd);

	}

}
