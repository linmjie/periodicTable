import java.util.HashMap;
import java.util.Scanner;

public class Main {
    //HashMap of strings(element symbols) to the element objects
    static HashMap<String, Element> element = new HashMap<>(Symbol.createPeriodicTable());
    static PolyatmoicNames polyNames = new PolyatmoicNames();
    public static void main(String[] args) {
        //take input
        System.out.println("Type \"quit\" to end program");
        String equationTypeInput = "";
        while (!equationTypeInput.equalsIgnoreCase("quit")) {
            System.out.println("""
                    Please choose the number from the list of what to compute:
                       1. Molar Mass
                       2. Percent Composition
                       3. Polyatomic ion finder""");
            System.out.print("Program Type Input: ");
            Scanner mainEquationTypeInput = new Scanner(System.in);
            //takes next string inputted by user
            equationTypeInput = mainEquationTypeInput.next();
            if (equationTypeInput.equalsIgnoreCase("quit"))
                break;
            equationTypeInput = equationTypeInput.trim();
            switch (equationTypeInput) {
                case ("1"): {
                    System.out.println("""
                            
                            Type "break" to go back
                            "quit" command will not work here
                            Input a compound to compute its molar mass""");
                    String mainInput = "";
                    while (!mainInput.equalsIgnoreCase("break")) {
                        System.out.print("Equation or Compound Input: ");
                        Scanner mainCompoundInput = new Scanner(System.in);
                        //takes next string inputted by user
                        mainInput = mainCompoundInput.next();
                        if (mainInput.equalsIgnoreCase("break")) {
                            System.out.println();
                            break;
                        }
                        mainInput = mainInput.trim();
                        System.out.println("Your input: " + mainInput);
                        //calculate molar mass
                        try {
                            System.out.println("Molar Mass of " + mainInput + ": " + ChemistryEquation.findMolarMass(mainInput));
                        } catch (Exception e) {
                            System.out.println("    Please input a valid string");
                            System.out.println("    Example input: \"Mg(NO4)2\" with a subscript after the element or compound");
                        }
                    }
                    break;
                }
                case ("2"): {
                    System.out.println("""
                            
                            Type "break" to go back
                            "quit" command will not work here
                            Input a compound to compute its percent composition""");
                    String mainInput = "";
                    while (!mainInput.equalsIgnoreCase("break")) {
                        System.out.print("Equation or Compound Input: ");
                        Scanner mainCompoundInput = new Scanner(System.in);
                        //takes next string inputted by user
                        mainInput = mainCompoundInput.next();
                        if (mainInput.equalsIgnoreCase("break")) {
                            System.out.println();
                            break;
                        }
                        mainInput = mainInput.trim();
                        System.out.println("Your input: " + mainInput);
                        //calculate molar mass
                        try {
                            System.out.println("Molar Mass of " + mainInput + ": " + ChemistryEquation.findMolarMass(mainInput));
                            ChemistryEquation.findPercentComposition(mainInput);
                        } catch (Exception e) {
                            System.out.println("    Please input a valid string");
                            System.out.println("    Example input: \"Mg(NO4)2\" with a subscript after the element or compound");
                        }
                    }
                    break;
                }
                case "3":{
                    System.out.println("""
                            
                            Type "break" to go back
                            "quit" command will not work here
                            Now finding polyatomic ions. Type a name (eg. "nitrate")""");
                    String mainInput = "";
                    while (!mainInput.equalsIgnoreCase("break")) {
                        System.out.print("Compound: ");
                        Scanner mainCompoundInput = new Scanner(System.in);
                        //takes next string inputted by user
                        mainInput = mainCompoundInput.next();
                        if (mainInput.equalsIgnoreCase("break")) {
                            System.out.println();
                            break;
                        }
                        mainInput = mainInput.trim();
                        System.out.println("Your input: " + mainInput);
                        try{
                            String output = polyNames.findName(mainInput);
                            if(output!=null){
                                System.out.println("The formula for "+mainInput+" is "+output);
                            }
                            else{
                                System.out.println("That is not a valid or currently included polyatomic ion");
                            }
                        } catch (Exception e) {
                            System.out.println("That is not a valid or currently included polyatomic ion");
                        }
                    }
                    break;
                }
                default:
                    System.out.println("    Please type the number associated with the calculation from the list");
                    System.out.println();
                    break;
            }
        }
    }
}