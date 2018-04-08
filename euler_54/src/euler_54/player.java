package euler_54;

public class player {

	private int index;
	private int result;

	private card[] cards;
	private card[] card_win;
	private card[] cards_by_type;

	private int next_index;
	private int large_value;
	private int small_value;

	public player() {
		this.cards = new card[5];
		this.card_win = new card[5];
		this.cards_by_type = new card[5];

		init();
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new card();
			card_win[i] = new card();
			cards_by_type[i] = new card();
		}
	}

	public void init() {
		index = 0;
		result = 1;
		large_value = 0;
		small_value = 0;
		next_index = 0;
	}

	public int get_result() {
		return result;
	}

	public int[] get_win_ranking() {
		int[] rc = new int[5];
		sort_by_card_win();

		for (int i = 0; i < rc.length; i++) {
			rc[i] = card_win[i].get_value();
		}

		return rc;
	}

	public int get_next() {
		if (next_index > 4)
			return 0;

		return cards[next_index++].get_value();
	}

	public void next_card(int type, int value) {
		if (index == 5) {
			init();
		}

		cards[index].set_card(type, value);
		card_win[index].set_card(type, value);
		cards_by_type[index].set_card(type, value);
		index++;
	}

	public void ranking() {
		sort_value();

		check_pair();

		if (result == 1) {
			check_straight();

			sort_type();
			check_flush();
		}
	}

	private void check_pair() {
		int i = 0, counter = 0;

		for (; i < 4; i++) {
			if (cards[i].get_value() == cards[i + 1].get_value())
				counter++;
			else if (counter != 0)
				break;
		}

		switch (counter) {
		case 1:
			result = 2;
			small_value = cards[i - 1].get_value();
			break;
		case 2:
			result = 4;
			large_value = cards[i - 1].get_value();
			break;
		case 3:
			result = 8;
			small_value = cards[i - 1].get_value();
			break;
		default:
			break;
		}

		if (i < 4) {
			check_pair(i);
		}
	}

	private void check_pair(int i) {
		int counter = 0;

		for (; i < 4; i++) {
			if (cards[i].get_value() == cards[i + 1].get_value())
				counter++;
			else if (counter != 0)
				break;
		}

		switch (counter) {
		case 1:
			if (result == 2) {
				result = 3;
				large_value = cards[i - 1].get_value();
			} else {
				result = 7;
				small_value = cards[i - 1].get_value();
			}
			break;
		case 2:
			result = 7;
			large_value = cards[i - 1].get_value();
			break;

		default:
			break;
		}
	}

	private void check_flush() {
		int i = 1;
		for (; i < cards.length && cards_by_type[i].get_type() == cards_by_type[0].get_type();) {
			i++;
		}

		if (i == 5) {
			if (result == 1)
				result = 6;
			else if (small_value == 10)
				result = 10;
			else
				result = 9;
		}
	}

	private void check_straight() {
		int i = 0;

		for (; i < cards.length - 1; i++) {
			if (cards[i].get_value() + 1 != cards[i + 1].get_value())
				return;
		}

		result = 5;
		small_value = cards[0].get_value();
	}

	private void sort_type() {
		int i = 0, j;
		card swap = new card();

		for (; i < cards_by_type.length; i++) {
			for (j = 0; j < cards_by_type.length - i - 1; j++) {
				if (cards_by_type[j].get_type() > cards_by_type[j + 1].get_type()) /* For descending order use < */
				{
					swap = cards_by_type[j];
					cards_by_type[j] = cards_by_type[j + 1];
					cards_by_type[j + 1] = swap;
				}
			}
		}

	}

	private void sort_value() {
		int i = 0, j;
		card swap = new card();

		for (; i < cards.length; i++) {
			for (j = 0; j < cards.length - 1; j++) {
				if (cards[j].get_value() > cards[j + 1].get_value()) /* For descending order use < */
				{
					swap = cards[j];
					cards[j] = cards[j + 1];
					cards[j + 1] = swap;
				}
			}
		}
	}

	private void sort_by_card_win() {
		switch (result) {
		case 2:
			sort_by_card_win_pair();
			break;
		case 3:
			sort_by_card_win_2pair();
			break;
		case 4:
			sort_by_card_win_three();
			break;
		case 7:
			sort_by_card_win_full();
			break;
		case 8:
			sort_by_card_win_four();
			break;

		default:
			sort_by_card_win_highest();
			break;
		}

	}

	private void sort_by_card_win_highest() {
		int i = 0, j;
		card swap = new card();

		for (; i < card_win.length; i++) {
			for (j = 0; j < card_win.length - i - 1; j++) {
				if (card_win[j].get_value() > card_win[j + 1].get_value()) /* For descending order use < */
				{
					swap = card_win[j];
					card_win[j] = card_win[j + 1];
					card_win[j + 1] = swap;
				}
			}
		}
	}

	private void sort_by_card_win_pair() {
		int index = 0;
		for (int i = 0; i < 5 && index < 3; i++) {
			if (card_win[i].get_value() != small_value) {
				card_win[index++] = card_win[i];
			}
		}

		card_win[4] = new card(1, small_value);
		card_win[3] = new card(1, small_value);
		sort_by_card_win_highest_pair();
	}

	private void sort_by_card_win_highest_pair() {
		int i = 0, j;
		card swap = new card();

		for (; i < 3; i++) {
			for (j = 0; j < 2; j++) {
				if (card_win[j].get_value() > card_win[j + 1].get_value()) /* For descending order use < */
				{
					swap = card_win[j];
					card_win[j] = card_win[j + 1];
					card_win[j + 1] = swap;
				}
			}
		}
	}

	private void sort_by_card_win_2pair() {
		for (int i = 0; i < card_win.length; i++) {
			if (card_win[i].get_value() != small_value && card_win[i].get_value() != large_value) {
				card_win[0] = card_win[i];
				break;
			}
		}

		card_win[4] = new card(1, large_value);
		card_win[3] = new card(1, large_value);
		card_win[2] = new card(1, small_value);
		card_win[1] = new card(1, small_value);
	}

	private void sort_by_card_win_three() {
		int index = 0;
		card tmp = null;
		for (int i = 0; i < card_win.length && index < 2; i++) {
			if (card_win[i].get_value() != large_value) {
				card_win[index++] = card_win[i];
			}
		}
		card_win[4] = new card(1, large_value);
		card_win[3] = new card(1, large_value);
		card_win[2] = new card(1, large_value);

		if (card_win[0].get_value() > card_win[1].get_value()) {
			tmp = card_win[0];
			card_win[0] = card_win[1];
			card_win[1] = tmp;
		}
	}

	private void sort_by_card_win_four() {
		for (int i = 0; i < card_win.length; i++) {
			if (card_win[i].get_value() != large_value) {
				card_win[0] = card_win[i];
				break;
			}
		}
		card_win[4] = new card(1, large_value);
		card_win[3] = new card(1, large_value);
		card_win[2] = new card(1, large_value);
		card_win[1] = new card(1, large_value);
	}

	private void sort_by_card_win_full() {
		card_win[4] = new card(1, large_value);
		card_win[3] = new card(1, large_value);
		card_win[2] = new card(1, large_value);
		card_win[1] = new card(1, small_value);
		card_win[0] = new card(1, small_value);
	}
}
