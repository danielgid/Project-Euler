public class Euler_14 {

	public static void main(String[] args) {
		long[] steps = new long[1000000];
		int i,max=0;
		
		for (i = 2; i < 1000000; i++) {
			steps[i] = notReqFun(i);
			//System.out.println(i+"\t"+steps[i]);
		}		
		for (i = 1; i < 1000000; i++) {
			if (steps[i] > steps[max])
				max = i;
		}
		System.out.println(max);
	}

	
	private static long notReqFun(int intNum){
		long steps=1,num=(long)intNum;
		
		while(num!=1)
		{
			if (num % 2 == 0)
				num = (num / 2);
			else
				num = ((3 * num) + 1);
			steps++;
		}
		
		return steps;
	}
	
}
