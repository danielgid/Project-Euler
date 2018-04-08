import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Euler11 {
	
	public static void main(String[] args)  throws IOException
	{
		int [][] matriz = new int [20][20];
		File f=null;
		Scanner s=null;
		int i,j,temp=0,max=0;
		
		try
		{
			f = new File("f.txt");
			s = new Scanner(f);
			
			
			for (i = 0; i < matriz.length; i++) {
				for (j = 0; j < matriz.length; j++) {
					matriz[i][j] = s.nextInt();
				}
			}
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
		
		
		for (i = 0; i < matriz.length; i++) {
			for (j = 0; j < matriz.length; j++) {
				if(i+3<matriz.length)
				{
					temp=matriz[i][j]*matriz[i+1][j]*matriz[i+2][j]*matriz[i+3][j];
					if(temp>max)
						max=temp;
					if(j+3<matriz.length)
					{
						temp=matriz[i][j]*matriz[i+1][j+1]*matriz[i+2][j+2]*matriz[i+3][j+3];
						if(temp>max)
							max=temp;
					}
				}
				if(j+3<matriz.length)
				{
					temp=matriz[i][j]*matriz[i][j+1]*matriz[i][j+2]*matriz[i][j+3];
					if(temp>max)
						max=temp;
					if(i-3>=0)
					{
						temp=matriz[i][j]*matriz[i-1][j+1]*matriz[i-2][j+2]*matriz[i-3][j+3];
						if(temp>max)
							max=temp;
					}
				}
			}
		}

		System.out.println(max);
		
	}
	
	public static void print_Matriz(int [][] matriz)
	{
		int i,j;
		for (i = 0; i < matriz.length; i++) {
			for (j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
	}
}
