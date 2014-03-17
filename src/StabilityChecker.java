import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StabilityChecker {
	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		List<Integer> pings = new LinkedList<>();
		Pattern p = Pattern.compile("Reply from ([0-9\\.]+): bytes=32 time=([0-9]+).*");
		pings.add(10); //dummy
		boolean internet = true;
		while(true) {
			String currentLine = s.nextLine();
			Matcher m = p.matcher(currentLine);
			if(m.matches()) {
				int ping = Integer.parseInt(m.group(2));
				pings.add(0, ping);
				internet = true;
			} else {
				internet = false;
			}
			int size = (pings.size() - 1) < 5 ? pings.size() : 5;
			double average = 0;
			for (Integer i : pings.subList(0,  size)) {
				average +=i;
			}
			average /= size;
			System.out.print("                                                     \r");
			System.out.print((internet ? "Connected" : "Not Connected") + " avg of last " + size + " pings: " + average + "\r");
			System.out.flush();
		}
	}
}
