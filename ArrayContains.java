public class ArrayContains {
	public static Boolean contains(int[] array, int target){
	for(int num: array){
	if(num==target){
	return true;
	}
	}
return false;
}
public static void main(String a[]){
	int[] array={10,20,30,40,50};
int target = 30;
Boolean result=contains(array,target);
if(result){
System.out.println("the array contains the element: "+target);
}else{
	System.out.println("the array does not contain the element: "+target);
}
}
}