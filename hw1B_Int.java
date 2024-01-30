package cs402_hw;
import java.util.Random;

public class hw1B_Int {
	private static int a;
	//Function to generate random matrix with integer values
	public static int[][] randMatGen(int rows, int cols){
		//Creating a matrix with 500 rows and 300 columns
		int[][] matrix = new int[rows][cols];
		
		//creating new instance of random library
		Random random =new Random();
		//Inserting random values into 
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				a=random.nextInt(100);
				System.out.println(a);
				matrix[i][j] = a;
			}
		}
		return matrix;
	}
	
	//Function to multiply two integer matrices
	private static void mulMatrix(int[][]A, int[][]B,int rows1,int cols1, int rows2, int cols2){
		
		if(cols1 !=rows2) {
			System.out.println("Matrix cannot be multiplied. Please check values");
			
		}
		else {
			int[][] matAns = new int[rows1][cols2];
			
			for(int i=0;i<rows1;i++)
				for(int j=0;j<cols2;j++)
					for(int k=0;k<cols1;k++) {
						matAns[i][j]=A[i][k] * B[k][j];
					}
			
			
			//Printing the answer
			for(int i=0;i<rows1;i++) {
				for(int j=0;j<cols2;j++) {
					System.out.print(matAns[i][j]+ "  ");
				}
			System.out.println();
			}
		}			
	}
	
	
	public static void main(String[] args) {
		
		int rows1=500,cols1=300,rows2=300,cols2=600;
		int[][] a= new int[rows1][cols1];
		int[][] b= new int[rows2][cols2];
		
		//Start time
		long startTime = System.nanoTime();
		a=randMatGen(rows1,cols1);
		b=randMatGen(rows2,cols2);	
		System.out.println("Answer:");
		mulMatrix(a,b,rows1,cols1,rows2,cols2);
		//end time
		long endTime = System.nanoTime();
		//time difference measured
		long timeElapsed = endTime - startTime;
		System.out.println("Time elapsed on macOS: "+ timeElapsed +" nano seconds" );

		
	}
	
	

}
