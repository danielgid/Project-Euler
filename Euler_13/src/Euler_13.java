import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

public class Euler_13 {

	public static void main(String[] args) {
		FileReader f = null;
		Scanner s = null;
		BigInteger temp = null, sum = new BigInteger("0");

		try {
			f = new FileReader("test.txt");
			s = new Scanner(new BufferedReader(f));
			while (s.hasNext()) {
				temp = s.nextBigInteger();
				sum = sum.add(temp);

			}
			System.out.println(sum.toString().substring(0, 10));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}

	}

}
