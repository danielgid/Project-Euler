public class Euler_30 {

	public static void main(String[] args) {
		long i, sum = 0, counter = 0, temp, temp2;

		for (i = 2; i < Math.pow(2, 63) - 1; i++) {
			temp = i;
			sum = 0;
			while (temp >= 10) {
				if(i==4405)
					System.out.print("");
				temp2 = temp % 10;
				temp /= 10;
				sum += Math.pow(temp2, 5);
				if (sum > i)
					break;
			}
			sum += Math.pow(temp, 5);
			if (sum == i){
				counter += sum;
				System.out.println(i+"\t"+counter);
			}
		}
		System.out.println(counter);
	}

}
