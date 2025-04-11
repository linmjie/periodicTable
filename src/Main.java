import java.util.Scanner;

public class Main {
    //object to access a switch statement for all the polyatomic names
    //definitely will delete this later when implementing usage of ions lol
    static PolyatomicNames polyNames = new PolyatomicNames();

    public static void main(String[] args) {
        //take input
        System.out.println("Type \"quit\" to end program");
        String equationTypeInput = "";
        while (!equationTypeInput.equalsIgnoreCase("quit")) {
            System.out.println("""
                    Please choose the number from the list of what to compute:
                       1. Molar Mass
                       2. Percent Composition
                       3. Perform Stoichiometry
                       4. Polyatomic ion finder""");
            System.out.print("Program Type Input: ");
            Scanner mainEquationTypeInput = new Scanner(System.in);
            equationTypeInput = mainEquationTypeInput.next();
            if (equationTypeInput.equalsIgnoreCase("quit"))
                break;
            equationTypeInput = equationTypeInput.trim();

            //switch statement for handling calculation type input
            switch (equationTypeInput.toLowerCase()) {
                case "1","mass": { //molar mass
                    createHeader("Input a compound to compute its molar mass");
                    String mainInput = "";
                    while (!mainInput.equalsIgnoreCase("break")) {
                        System.out.print("  Compound Input: ");
                        Scanner mainCompoundInput = new Scanner(System.in);
                        mainInput = mainCompoundInput.next();
                        if (mainInput.equalsIgnoreCase("break")) {
                            System.out.println();
                            break;
                        }
                        mainInput = mainInput.trim();
                        System.out.println("    Your input: " + mainInput);
                        //calculate molar mass
                        try {
                            System.out.println("    Molar Mass of " + mainInput + ": " + ChemistryEquation.findMolarMass(mainInput));
                        } catch (Exception e) {
                            System.out.println("        Please input a valid string");
                            System.out.println("        Example input: \"Mg(NO4)2\" with a subscript after the element or compound");
                        }
                    }
                    break;
                }
                case "2","percent", "composition": { //percent composition
                    createHeader("Input a compound to compute its percent composition");
                    String mainInput = "";
                    while (!mainInput.equalsIgnoreCase("break")) {
                        System.out.print("  Compound Input: ");
                        Scanner mainCompoundInput = new Scanner(System.in);
                        mainInput = mainCompoundInput.next();
                        if (mainInput.equalsIgnoreCase("break")) {
                            System.out.println();
                            break;
                        }
                        mainInput = mainInput.trim();
                        System.out.println("    Your input: " + mainInput);
                        //calculates percent composition
                        try {
                            System.out.println("    Molar Mass of " + mainInput + ": " + ChemistryEquation.findMolarMass(mainInput));
                            ChemistryEquation.findPercentComposition(mainInput);
                        } catch (Exception e) {
                            System.out.println("        Please input a valid string");
                            System.out.println("        Example input: \"Mg(NO4)2\" with a subscript after the element or compound");
                        }
                    }
                    break;
                }
                case "3", "stoichiometry": { //stoichiometry
                    createHeader("First step: input your equation");
                    System.out.println("Please do not use spaces in your equation and use an equal sign to show a reaction. ex. \"3AgNO4+AlS=Al(NO4)3+Ag3S\"");
                    String mainInput = "";
                    while (!mainInput.equalsIgnoreCase("break")) {
                        System.out.print("  Equation Input: ");
                        Scanner mainCompoundInput = new Scanner(System.in);
                        mainInput = mainCompoundInput.next();
                        if (mainInput.equalsIgnoreCase("break")) {
                            System.out.println();
                            break;
                        }
                        mainInput = mainInput.trim();
                        System.out.println("    Your input: " + mainInput);
                        //input compound
                        System.out.println("        Now type the given compound (i.e. AgNO4) exactly how you typed it in the equation");
                        String givenCompound="";
                        System.out.print("        Your input (input compound): ");
                        Scanner givenCompoundInput=new Scanner(System.in);
                        givenCompound=givenCompoundInput.next();
                        if (givenCompound.equalsIgnoreCase("break")){
                            System.out.println();
                            break;
                        }
                        System.out.println("\n"+"       Now type your resultant compound whose quantity you want to find exactly how you typed it in the equation");
                        String outputCompound="";
                        System.out.print("        Your input (resultant compound): ");
                        Scanner outputCompoundInput=new Scanner(System.in);
                        outputCompound=outputCompoundInput.next();
                        if (outputCompound.equalsIgnoreCase("break")){
                            System.out.println();
                            break;
                        }
                        System.out.println("""
                                
                                Now type the number associated with the unit of matter you have of your inputted compound:
                                    1. Moles
                                    2. Grams
                                    3. Liters (assumed to be gas at STP)""");
                        String inputUnit = "";
                        System.out.print("      Your input (unit): ");
                        Scanner inputUnitInput=new Scanner(System.in);
                        inputUnit=inputUnitInput.next();
                        float amount = 0F;
                        while (true) {
                            System.out.print("        Amount: ");
                            Scanner amountInput = new Scanner(System.in);
                            try {
                                amount = amountInput.nextFloat();
                                break;
                            } catch (Exception e) {
                                System.out.println("Please input a number");
                            }
                        }
                        if (inputUnit.equalsIgnoreCase("break")){
                            System.out.println();
                            break;
                        }
                        System.out.println("""
                                
                                Now type the number associated with the unit of matter you have of your resultant compound:
                                    1. Moles
                                    2. Grams
                                    3. Liters (assumed to be gas at STP)""");
                        String outputUnit = "";
                        System.out.print("      Your input (unit): ");
                        Scanner outputUnitInput=new Scanner(System.in);
                        outputUnit=outputUnitInput.next();
                        if (outputUnit.equalsIgnoreCase("break")){
                            System.out.println();
                            break;
                        }
                        try{
                            float moleInput = ChemistryEquation.convertToMoles(inputUnit, amount, givenCompound);
                            float outputMoles = ChemistryEquation.molarStoichiometry(mainInput, moleInput, givenCompound, outputCompound);
                            float outputInProperUnit = ChemistryEquation.molesToUnit(outputUnit, outputMoles, outputCompound);
                            String properUnit;
                            switch (outputUnit.toLowerCase()){
                                case "1", "mol", "mole", "moles"->properUnit="mol";
                                case "2", "g", "gram", "grams"->properUnit="g";
                                case "3", "l", "liter", "liters"->properUnit="l";
                                default->throw new IllegalArgumentException("Unit did not match units listed");
                            }
                            System.out.println("      "+outputInProperUnit+properUnit+" of "+outputCompound);
                        } catch (Exception e) {
                            System.out.println("        Something went wrong, try again");
                        }
                        //System.out.println(ChemistryEquation.molarStoichiometry("3AgNO4+AlS=Al(NO4)3+Ag3S",1,"AgNO4","Ag3S")); //test
                    }
                    break;
                }
                case "4", "find": { //find supported polyatomic ion
                    createHeader("Now finding polyatomic ions. Type a name (eg. \"nitrate\")");
                    String mainInput = "";
                    while (!mainInput.equalsIgnoreCase("break")) {
                        System.out.print("  Compound: ");
                        Scanner mainCompoundInput = new Scanner(System.in);
                        mainInput = mainCompoundInput.next();
                        if (mainInput.equalsIgnoreCase("break")) {
                            System.out.println();
                            break;
                        }
                        mainInput = mainInput.trim();
                        System.out.println("    Your input: " + mainInput);
                        try {
                            String output = polyNames.findName(mainInput);
                            if (output != null) {
                                System.out.println("    The formula for " + mainInput + " is " + output);
                            } else {
                                System.out.println("    That is not a valid or currently included polyatomic ion");
                            }
                        } catch (Exception e) {
                            System.out.println("    That is not a valid or currently included polyatomic ion");
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
    //shortcut for creating the header of each switch case
    public static void createHeader(String finalHeaderLine) {
        System.out.println("""
                
                   Type "break" to go back
                   "quit" command will not work here"""
                +"\n"+finalHeaderLine);
    }
}