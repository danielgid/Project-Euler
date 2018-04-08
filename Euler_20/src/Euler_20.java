import java.math.BigInteger;


public class Euler_20 {

	public static void main(String[] args) {
		BigInteger b = new BigInteger("1");
		BigInteger c;
		int i,sum=0;
		
		for (i = 1; i <= 100; i++) {
			c=b.multiply(new BigInteger(Integer.toString(i)));
			b=c;
		}
		for (i = 0; i < b.toString().length(); i++) {
			sum+=b.toString().charAt(i)-48;
		}
		System.out.println(sum);
	}

}
