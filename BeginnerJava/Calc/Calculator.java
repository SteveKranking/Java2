public class Calculator{
    // public static Double num1;
    // public static String operantion;
    // public static Double num2;
    // public static Double answer;

    // public static void setOperandOne(Double num){
    //     num1 = num;
    // }
    // public static void setOperandTwo(Double num){
    //     num2 = num;
    // }
    // public static void setOperation(String operations){
    //     operantion = operations;
    // }

    // public static void performOperation(){
        

    //     if(operantion == "+"){
    //         answer = num1 + num2;
    //     }
    //     else if(operantion == "-") {
    //         answer = num1 - num2;
    //     }
    //     else if(operantion == "*") {
    //         answer = num1 * num2;
    //     }
    // }

    public static Object info;
    public static String uncomplied = "";
    public static Double total;

    public static void performOperation(Object info){
        if(info.getClass() == Integer.class){
            
            uncomplied += info.toString()+".0";
        } else if(info.getClass() == Double.class){
            uncomplied += info.toString();
        }else{
            uncomplied += info;
        }

    }
    public static void getResults(){
        
        Double value;
        Integer count=0;
        Integer start=0;
        for (int i=0; i<uncomplied.length(); i++) {
            String empty = "";
            
            

            if(count.equals(0)){
                for (int x= i; x<uncomplied.length(); x++){
                    String emptyx = "";
                    emptyx += uncomplied.charAt(x);
                    if(emptyx.equals("+") ||emptyx.equals("=") ||emptyx.equals("*") ||emptyx.equals("-")){
                        total = Double.parseDouble(uncomplied.substring(i, x));
                        i=x;
                        start = x;
                        count ++;
                        break;
                    }
                }
            }
            
            // if (empty.equals("+")||empty.equals("*") ||empty.equals("-")){
                for (int x= i+1; x<uncomplied.length(); x++){
                    String emptyx = "";
                    emptyx += uncomplied.charAt(x);

                    
                    if(emptyx.equals("+") ||emptyx.equals("=") ||emptyx.equals("*") ||emptyx.equals("-")){
                        value = Double.parseDouble(uncomplied.substring(i+1, x));
                        System.out.println(total);
                        
                        empty += uncomplied.charAt(i);

                        if(empty.substring(empty.length()-1).equals("+")){
                            total += value;
                            
                        }
                        else if(empty.substring(empty.length()-1).equals("*")){
                            total *= value;
                        }
                        else if(empty.substring(empty.length()-1).equals("-")){
                            total -= value;
                        }
                        i=x;
                        
                    //} .substring(empty.length()-1)
                }
                if (emptyx.equals("=")){
                    System.out.println("total is: " + total);
                    return;
                }
                
            }
         
        }
    }

    public static void main(String[] args){
        performOperation(10.5);
        performOperation("+");
        performOperation(5.2);
        performOperation("*");
        performOperation(10);
        performOperation("=");
        getResults();
    }
}