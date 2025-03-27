import java.util.HashMap;
import java.util.Scanner;

public class Main{
    static HashMap<String, Element> element = new HashMap<>(Symbol.createPeriodicTable());
    public static void main(String[] args) {
        //take input
        System.out.println("Type \"quit\" to end program");
        String input = "";
        while (!input.equalsIgnoreCase("quit")){
            System.out.print("Input: ");
                Scanner mainInput = new Scanner(System.in);
                input = mainInput.next();
                if (input.equalsIgnoreCase("quit"))
                    break;
                input=input.trim();
                System.out.println("Your input: " + input);
            //process
            try {
                System.out.println("Molar Mass of " + input + ": " + findMolarMass(input));
            } catch(Exception e){
                System.out.println("    Please input a valid string");
                System.out.println("    Example input: \"AgNO4\" with a single digit subscript after the element");
            }
        }
    }
    public static float findMolarMass(String formula){
        float molarMass=0F;
        for(int i=0; i<formula.length(); i++){
            String symbol = formula.substring(i, i + 1);
            int subscript=1;
            //System.out.println("Start");
            //plan for implementing parenthesis:
                //save the substring from opening bracket to closing bracket then pass it through self method recursively and add the returned molar mass to main molar mass
            /*
            if (formula.charAt(i)=='('){
                System.out.println("Conditional pass");
                int subFormulaEnd;
                for (int j = i+1; j<formula.substring(i+1).length(); j++){
                    System.out.println(formula.charAt(j));
                    if (formula.charAt(j)==')') {
                        System.out.println("i:"+i);
                        subFormulaEnd = i + j +1;
                        System.out.println(subFormulaEnd);
                        System.out.println(formula.substring((i+1),subFormulaEnd));
                        molarMass += findMolarMass(formula.substring(i+1, subFormulaEnd));
                    }
                }
            }
             */
            i++;
            if ((formula.length()>i)&&Character.isLowerCase(formula.charAt(i))) {
                symbol+=formula.charAt(i);
            } else
                i--;
            i++;
            if ((formula.length()>i)&&Character.isDigit(formula.charAt(i))) {
                subscript = Character.getNumericValue(formula.charAt(i));
            } else
                i--;
            molarMass+=element.get(symbol).getAtomicMass()*subscript;
        }
        return molarMass;
    }
}