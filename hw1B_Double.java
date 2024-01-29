package cs402_hw;
import java.util.Random;

public class hw1_d {
	
	//Function to generate random matrix with float values
	public static double[][] randMatGenD(int rows, int cols){
		double a;
		//Creating a matrix with 500 rows and 300 columns
		double[][] mat = new double[rows][cols];
		//creating new instance of random library
		Random rand = new Random();
		//Inserting random values into 
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				a=rand.nextDouble()*100.0;
				System.out.println(a);
				mat[i][j] = a;
			}
		}
		return mat;
	}
	
	//Function to multiply two integer matrices
	private static void mulMatrix(double [][]A, double[][]B,int rows1,int cols1, int rows2, int cols2){
			
		if(cols1 !=rows2) {
			System.out.println("Matrix cannot be multiplied. Please check values");	
		}
		else {
			double[][] matAns = new double[rows1][cols2];
				
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
		double[][] a= new double[rows1][cols1];
		double[][] b= new double[rows2][cols2];
		
		//Start time
		long startTime = System.nanoTime();
		a=randMatGenD(rows1,cols1);
		b=randMatGenD(rows2,cols2);	
		System.out.println("Answer:");
		mulMatrix(a,b,rows1,cols1,rows2,cols2);
		//end time
		long endTime = System.nanoTime();
		//time difference measured
		long timeElapsed = endTime - startTime;
		System.out.println("Time elapsed on macOS: "+ timeElapsed +" nano seconds" );

	}

}
