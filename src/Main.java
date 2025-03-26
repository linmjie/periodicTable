import java.util.HashMap;
import java.util.Scanner;

public class Main{
    static HashMap<String, Element> element = new HashMap<>(Symbol.createPeriodicTable());
    public static void main(String[] args) {
        //take input
        System.out.println("Type \"quit\" to end program");
        String input = "";
        while (!input.equalsIgnoreCase("quit")){
            {System.out.print("Input: ");
                Scanner mainInput = new Scanner(System.in);
                input = mainInput.next();
                if (input.equalsIgnoreCase("quit"))
                    break;
                if (!checkInputValidity(input)) {
                    System.out.println("please input something valid");
                    continue;
                }
                input=input.trim();
                System.out.println("Your input: " + input);}
            //process
            System.out.println("Molar Mass of " + input + ": " + findMolarMass(input));
        }
    }
    public static float findMolarMass(String formula){
        float molarMass=0F;
        for(int i=0; i<formula.length(); i++){
            String symbol = formula.substring(i, i + 1);
            int subscript=1;
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
    public static boolean checkInputValidity(String input){
        //placeholder
        return true;
    }
}