package euler_54;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class eruler_54 {

	private static player p1;
	private static player p2;

	private static int p1_win;

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
		euler54();

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + "ms");
	}

	@SuppressWarnings("resource")
	public static void euler54() throws FileNotFoundException {
		char c;
		int type = 0, value = 0;
		int tmp = 0;

		init();
		FileReader inputStream = null;

		try {
			inputStream = new FileReader("p054_poker.txt");

			for (int i = 0; i < 1000; i++) {
				for (int j = 0; j < 5; j++) {
					if ((tmp = inputStream.read()) == -1)
						return;

					c = (char) tmp;
					value = encode_card(c);
					if ((tmp = inputStream.read()) == -1)
						return;

					c = (char) tmp;
					type = encode_type(c);

					if ((tmp = inputStream.read()) == -1)
						return;
					p1.next_card(type, value);
				}

				for (int j = 0; j < 5; j++) {
					if ((tmp = inputStream.read()) == -1)
						return;

					c = (char) tmp;
					value = encode_card(c);
					if ((tmp = inputStream.read()) == -1)
						return;

					c = (char) tmp;
					type = encode_type(c);

					if ((tmp = inputStream.read()) == -1)
						return;
					p2.next_card(type, value);
				}


				game();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(p1_win);
	}

	public static void init() {
		p1_win = 0;

		p1 = new player();
		p2 = new player();
	}

	public static void game() {
		int[] p1_cards = null;
		int[] p2_cards = null;
		

		p1.ranking();
		p2.ranking();

		if (p1.get_result() > p2.get_result())
			p1_win++;
		else if (p1.get_result() == p2.get_result()) {
			p1_cards = p1.get_win_ranking();
			p2_cards = p2.get_win_ranking();

			for (int i = 4; i >= 0; i--) {
				if (p1_cards[i] > p2_cards[i]) {
					p1_win++;
					break;
				} else if (p1_cards[i] < p2_cards[i])
					break;
			}
		}
	}

	public static int encode_card(char ch) {
		switch (ch) {
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case 'T':
			return 10;
		case 'J':
			return 11;
		case 'Q':
			return 12;
		case 'K':
			return 13;
		case 'A':
			return 14;

		default:
			return 0;
		}
	}

	public static int encode_type(char ch) {

		switch (ch) {
		case 'C':
			return 1;
		case 'D':
			return 2;
		case 'H':
			return 3;
		case 'S':
			return 4;

		default:
			return 0;
		}
	}

}
