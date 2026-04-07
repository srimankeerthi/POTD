public class ArrayToString{
public static String arrayToString(int[] array){
	if(array==null|| array.length==0){
	return "[]";
	}
	StringBuilder result=new StringBuilder("[");
	for(int i=0;i< array.length;i++){
		result.append(array[i]);
	if(i<array.length-1){
	result.append(",");
	}
	

	
}
result.append("]");
return result.toString();
}
public static void main(String a[]){
	int[] array ={10,20,30,40,50};
	String result=arrayToString(array);
	System.out.println("Array as String:"+ result);
}
}
	