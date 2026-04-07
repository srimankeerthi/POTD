//p2
import java .util.*;
public class P2{
 public static void main(String a[]){
 Scanner sc= new Scanner(System.in);
 int n =sc.nextInt();
 for(int i =1;i<=n;i++){//n=5 ; n(n+1)/2 
	for(int j=1;j<=i;j++){
	System .out.print("* ");
 }
	System.out.println();
 }
 }
 }
 // timec=n(n+1)/2
 //(n^2)/2 + n/2 
//n^2 
//tc - O(n^2)