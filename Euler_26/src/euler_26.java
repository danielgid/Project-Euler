

public class euler_26 {
	 public static void main(String[] args) {
        BruteForce();            
     }

     public static void BruteForce() {        

         int sequenceLength = 0;
         int num = 0;

         for (int i = 1000; i > 1; i--) {
             if (sequenceLength >= i) {
                 break;
             }

             int[] foundRemainders = new int[i];
             int value = 1;
             int position = 0;

             while (foundRemainders[value] == 0 && value != 0) {
                 foundRemainders[value] = position;
                 value *= 10;
                 value %= i;
                 position++;
             }

             if (position - foundRemainders[value] > sequenceLength) {
                 num = i;
                 sequenceLength = position - foundRemainders[value];    
             }
         }
         System.out.println("The number with the longest recurring cycle is "+num+", and the cycle is length is "+ sequenceLength);

     }

}
