import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class main {
	public static Piramida p;
	public static File f = null;
	public static FileReader fr = null;
	public static BufferedReader br = null;
	
	public static void main(String[] args) throws FileNotFoundException {
		p = new Piramida();

		buildPyramidFromFile();
		System.out.println("The max sum is : " + p.getMaxsum());
	}

	public static void buildPyramidFromFile() throws FileNotFoundException {
		int readNum = 0, tmp = 0;
		boolean ifUsed = false;

		try {
			f = new File("file.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			while ((readNum = br.read()) != -1) {
				if (readNum >= 48 && readNum <= 58) {
					tmp *= 10;
					tmp = tmp + (readNum - '0');
					ifUsed = true;
				} else {
					if (ifUsed)
						p.addNode(tmp);

					tmp = 0;
					ifUsed = false;
				}
			}

			br.close();
			fr.close();
		} catch (Exception e) {
			e.getMessage();
			System.out.println("File not found!!");
		}

	}

}
