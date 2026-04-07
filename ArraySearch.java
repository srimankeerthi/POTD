public class ArraySearch{
public static int search(int[] array,int target){
	for(int i=0;i<array.length;i++)
	{
	if(array[i]==target)
	{
	return i;
	}
	}
	return -1;
}
public static void main(String a[]){
	int[] array={10,20,30,40,50};
	int target=30;
	int index=search(array,target);
	if(index!=-1){
	System.out.println("Element "+target+"found at index:"+index);
}else{
System.out.println("element "+target+"not found in the array.");
}
}
}



	