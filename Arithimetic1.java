public class Arithimetic1 {
    public static void main(String args[]){
        if(args.length!=3){
            System.out.println("Usage:java arithemetic <int 1> <int 2><operator>");
            return;
        }
        int num1=Integer.parseInt(args[0]);
        int num2=Integer.parseInt(args[1]);
        String operator= args[2];
        int result =0;
        Boolean Validoperator=true;
        switch(operator){
            case "+":
            result=num1+num2;
            break;
            case"-":
            result=num1-num2;
            break;
            case"*":
            result=num1*num2;
            break;

            case"/":
            if(num2==0){
                System.out.println("Error:Division by zero is not allowed.");
                return;
            }
            result=num1/num2;
            break;
            default:
            Validoperator=false;
            System.out.println("enter unssupported operator use +,-,* or /.");
        }
        if (Validoperator){
            System.out.println("the result:"+result);
        }            
    }     
}