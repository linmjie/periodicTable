import java.util.HashMap;
import java.util.Scanner;

public class Main{
    //HashMap of strings(element symbols) to the element objects
    static HashMap<String, Element> element = new HashMap<>(Symbol.createPeriodicTable());
    public static void main(String[] args) {
        //take input
        System.out.println("Type \"quit\" to end program");
        String input = "";
        while (!input.equalsIgnoreCase("quit")){
            System.out.print("Input: ");
            Scanner mainInput = new Scanner(System.in);
            //takes next string inputted by user
            input = mainInput.next();
            if (input.equalsIgnoreCase("quit"))
                break;
            input=input.trim();
            System.out.println("Your input: " + input);
            //calculate molar mass
            try {
                System.out.println("Molar Mass of " + input + ": " + findMolarMass(input));
            } catch (Exception e){
                System.out.println("    Please input a valid string");
                System.out.println("    Example input: \"Mg(NO4)2\" with a subscript after the element or compound");
            }
        }
    }
    public static float findMolarMass(String formula) {
        float molarMass = 0F;
        //many incrementations for i within loop, advancing the index of the inputted string "formula"
        //each full iteration of loop should be one element or a compound within parentheses
        for (int i = 0; i < formula.length(); i++) {
            //check for char being uppercase
            //full block checks for one element and its subscript
            if (Character.isUpperCase(formula.charAt(i))) {
                String symbol = formula.substring(i,i+1);
                int subscript=1;
                //check for if next char is lower case
                    //not lower case-symbol is one char (i.e. H)
                    //is lower case-symbol includes the lower case char (i.e. He)
                if (formula.length()>i+1 && Character.isLowerCase(formula.charAt(i+1))) {
                    i++;
                    symbol += formula.charAt(i);
                }
                //check for if next char is a digit
                    //creates a substring from the first digit char until String formula ends or next char is not a digit
                    //uses this substring and parses to int to determine subscript
                if (formula.length()>i+1 && Character.isDigit((formula.charAt(i+1)))) {
                    i++;
                    final int startIndex=i;
                    int endIndex=i+1;
                    while (formula.length() > i + 1 && Character.isDigit(formula.charAt(i + 1))) {
                        i++;
                        endIndex++;
                    }
                    subscript=Integer.parseInt(formula.substring(startIndex,endIndex));
                }
                molarMass+=element.get(symbol).getAtomicMass()*subscript;
            }
            //check for opening parenthesis
            //saves the substring within (   ) and inputs that into findMolarMass recursively
            //return of findMolarMass is added to the main molar mass method as called in main
            else if(formula.charAt(i)=='('){
                int subscript=1;
                i++;
                final int startIndex=i;
                //end index is not i+1 in this case as that would save the closing ')'
                int endIndex=i;
                while (formula.length() > i+1 && !(formula.charAt(i)==')')){
                    i++;
                    endIndex++;
                }
                //check for if char after ')' is a digit
                    //creates a substring from the first digit char until String formula ends or next char is not a digit
                    //uses this substring and parses to int to determine subscript of compound within(   )
                    //same methodology as the version above except for application to compounds in parentheses
                if (formula.length()>i+1 && Character.isDigit((formula.charAt(i+1)))){
                    i++;
                    final int subscriptStartIndex=i;
                    int subscriptEndIndex=i+1;
                    while (formula.length() > i + 1 && Character.isDigit(formula.charAt(i + 1))) {
                        i++;
                        subscriptEndIndex++;
                    }
                    subscript=Integer.parseInt(formula.substring(subscriptStartIndex, subscriptEndIndex));
                }
                molarMass+=findMolarMass(formula.substring(startIndex,endIndex))*subscript;
            }
        }
        if (molarMass>0)
            return molarMass;
        else
            //Invalid inputs that cannot be converted into elemental composition (i.e. "oKi{4}d"
            throw new NumberFormatException("Inputted String cannot be converted into elemental composition");
    }
}