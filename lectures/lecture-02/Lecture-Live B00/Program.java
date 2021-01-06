import java.util.*;
public class Program{
	public static Integer sumNumbers(String str) {
		if (str == null || str.length() == 0) return null;
		Integer result = 0;
		int i = 0;
		int size = str.length();
		
		String tmp = "";
		boolean notNull = false;
		boolean run = false;
		while (i < size) {
			
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				tmp += str.charAt(i);		
				notNull = true;
				if (i != size - 1)
					run = true;
				else {
					run = false;
				}
			}
			else {
				run = false;
			}
			if (!run && tmp != ""){
				result += Integer.parseInt(tmp);
				tmp = "";
			}
			i++;
		}
		return notNull?result:null;
	}
	public static int[] evenOdd(int[] arr) {
		if (arr== null || arr.length == 0) return null;
		
		int[] result = new int[arr.length];
		ArrayList<Integer> evens = new ArrayList<>();
		ArrayList<Integer> odds = new ArrayList<>();
		int esize = 0, osize = 0;
		for (int i: arr) {
			if (i%2 == 0) {
				evens.add(i);
				esize++;
			}
			else {
				odds.add(i);
				osize++;
			}
		}
		for (int i = 0; i < esize; i++) {
			result[i] = evens.get(i);
		}
		for (int i = esize; i < esize + osize; i++) {
			result[i] = odds.get(i-esize);
		}
		return result;
	}
	
	
}