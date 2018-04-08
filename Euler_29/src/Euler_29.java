import java.math.BigInteger;
import java.util.LinkedList;


public class Euler_29 {

	public static void main(String[] args) {
		int i,j;
		BigInteger b,c;
		LinkedList<BigInteger> l = new LinkedList<BigInteger>();
		l.addFirst(new BigInteger(Integer.toString(4)));
		
		for ( i = 2; i <= 100; i++) {
			for ( j = 2; j <= 100; j++) {
				b=new BigInteger(Integer.toString(i));
				c=b.pow(j);
				l.addLast(c);
			}
		}
		sortList(l);
		System.out.println(l.size());
	}
	
	public static void sortList(LinkedList<BigInteger> L)
	{
		int i,j;
		System.out.println("Start Sort");
		
		for (i = 0; i < L.size()-1; i++) {
			for ( j = i+1; j < L.size(); j++) {
				if(L.get(i).toString().equals(L.get(j).toString()))
					L.remove(j--);
			}
		}//for i
		
		System.out.println("End Sort");
	}

}
