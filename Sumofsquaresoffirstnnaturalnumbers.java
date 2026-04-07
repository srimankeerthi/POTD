import java.util.*;
public class Sumofsquaresoffirstnnaturalnumbers{
	public static void main(String a[]){
	int i ;
	int sum=0;
	Scanner sc=new Scanner(System.in);
	System.out.print("enter the number :");
	int n = sc.nextInt();
	for(i=1;i<=n;i++){
	sum+=(i*i);
	}
	System.out.print(sum);
	}
	}
	
	