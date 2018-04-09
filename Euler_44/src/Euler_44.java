import java.util.LinkedList;

public class Euler_44 {

	public static void main(String[] args) {
		long i, j, temp, min = (long) Math.pow(2, 60);

		LinkedList<Long> head = new LinkedList<Long>();
		head.addFirst((long) 1);

		for (i = 2; i <= Math.pow(2, 15); i++)
			head.addLast(pentagonNumbers(i));
		
		System.out.println("Start\t"+head.size());
		
		for (int ii = 1; ii < head.size() - 1; ii++) {
			for (int jj = ii + 1; jj < head.size(); jj++) {
				temp = distance(head.get(ii), head.get(jj));
				if (temp > 0 && temp < min){
					min = temp;
					System.out.println(min);
				}
			}
		}

		System.out.println(min);
	}

	public static long pentagonNumbers(long num) {
		return (num * (3 * num - 1) / 2);
	}

	public static long distance(long numA, long numB) {
		long checking;

		checking = numB - numA;
		if ((Math.sqrt((double) 24 * checking + 1) + 1) % 6 != 0)
			return -1;
		checking = numB + numA;
		if ((Math.sqrt((double) 24 * checking + 1) + 1) % 6 != 0)
			return -1;

		return numB - numA;
	}

}
