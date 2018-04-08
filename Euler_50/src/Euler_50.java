import java.util.LinkedList;

public class Euler_50 {

	public static void main(String[] args) {
		int i, max = 0;
		LinkedList<PrimesNum> head = new LinkedList<>();
		head.addFirst(new PrimesNum(2));

		for (i = 3; i < 1000000; i++) {
			if (ifPrime(i))
				head.addLast(new PrimesNum(i));
		} // for i->1000000

		for (i = 0; head.get(i).getValue() < 1000000; i++) {
			head.get(i).setSteps(
					numOfSteps(head.get(i).getValue(), head.get(i).getValue(),
							0, 0, i, head));
			if (head.get(max).getSteps() < head.get(i).getSteps()) {
				max = i;
			}
		} // for i->size

		System.out.println(head.get(max).getValue());
	}

	public static boolean ifPrime(int num) {
		int i;
		if (num % 2 == 0)
			return false;
		for (i = 3; i <= (int) Math.sqrt((double) num); i += 2) {
			if (num % i == 0)
				return false;
		}

		return true;
	}

	public static int numOfSteps(int num, int originalNum, int steps,
			int index, int maxIndex, LinkedList<PrimesNum> head) {
		int withCurr, withoutCurr;

		if (num == 0)
			return steps;
		if (index >= head.size())
			return 0;
		if (num < 0)
			return 0;
		if (num < head.get(index).getValue())
			return 0;
		if (index>=maxIndex)
			return 0;

		withoutCurr = numOfSteps(originalNum, originalNum, 0, index + 1,
				maxIndex, head);
		if (steps != 0)
			withCurr = numOfSteps(num - head.get(index).getValue(),
					originalNum, steps + 1, index + 1, maxIndex, head);
		else
			withCurr = numOfSteps(originalNum - head.get(index).getValue(),
					originalNum, 1, index + 1, maxIndex, head);

		return withCurr > withoutCurr ? withCurr : withoutCurr;
	}
	
	

}
