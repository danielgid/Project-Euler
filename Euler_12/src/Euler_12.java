
public class Euler_12 {

	public static void main(String[] args) {
		long i,sum=0,deviders;

		for (i = 0; i <= 9223372036854775807L; i++) {
			sum+=i;
			deviders=numOfDeviders(sum);
			if(deviders>=2000)
			{
				System.out.println(sum+"\tNum of deviders:"+deviders);
				if(deviders>=501)
					break;
			}
		}
	}

	private static long numOfDeviders(long num) {
		long rc=1,counter,i;
		long temp=num;
		
		for (i = 2; (i <= Math.sqrt(num))||i<temp; i++) {
			counter=0;
			while(temp%i==0)
			{
				temp/=i;
				counter++;
			}
			if(counter>0)
				rc*=(counter+1);
		}
		
		
		return rc;
	}

}
