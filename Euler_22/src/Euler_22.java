import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Euler_22 {

	public static void main(String[] args) throws IOException {
		String[] names;

		names = namesArr();
		sortNames(names);
		
		System.out.println(namesScores(names));
	}
	
	public static int namesScores(String[] names){
		int i, j, rc = 0, sum;
		for (i = 0; i < names.length; i++) {
			sum = 0;
			for (j = 0; j < names[i].length(); j++)
				sum += names[i].charAt(j) - 'A' + 1;

			rc += ((i + 1) * sum);
		}
		return rc;
	}
	
	
	public static void sortNames(String[] names) {
		int i, j, smallest;
		String temp;
		for (i = 0; i < names.length - 1; i++) {
			smallest = i;
			for (j = i + 1; j < names.length; j++) {
				if (ifFirst(names[smallest], names[j]))
					smallest = j;
			}
			if (smallest != i) {
				temp = names[smallest];
				names[smallest] = names[i];
				names[i] = temp;
			}
		}
	}

	public static boolean ifFirst(String first, String second) {
		int minLength = first.length() < second.length() ? first.length()
				: second.length(), i;

		for (i = 0; i < minLength; i++) {
			if (first.charAt(i) < second.charAt(i))
				return false;
			if (first.charAt(i) > second.charAt(i))
				return true;
		}

		if (first.length() > second.length())
			return true;
		return false;
	}

	public static String[] namesArr() throws IOException {
		String[] names = new String[numOfWords()];
		FileReader f = null;
		BufferedReader b = null;
		int temp, counter = 0;
		char c;

		try {
			f = new FileReader("names.txt");
			b = new BufferedReader(f);

			names[counter] = "";
			while ((temp = b.read()) != -1) {
				c = (char) temp;
				if (c == ',') {
					names[++counter] = "";
				} else if (c == '"')
					continue;
				else {
					names[counter] += c;
				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (f != null) {
				f.close();
			}
		}// finally

		return names;
	}

	public static int numOfWords() throws IOException {
		FileReader f = null;
		BufferedReader b = null;
		int i, counter = 1;
		char c;

		try {
			f = new FileReader("names.txt");
			b = new BufferedReader(f);

			while ((i = b.read()) != -1) {
				c = (char) i;
				if (c == ',')
					counter++;
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (f != null) {
				f.close();
			}
		}// finally

		return counter;
	}

}
