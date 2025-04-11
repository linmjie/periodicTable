import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//A class of static methods designed to perform the calculations necessary for all outputs by the program
public class ChemistryEquation {
    //HashMap of strings(element symbols) to the element objects
    private static final HashMap<String, Element> element = new HashMap<>(Symbol.createPeriodicTable());
    //22.4L/Mol at STP
    final static float LITERS_PER_MOLE = 22.4F;
    //Would be a non-static method applied to a HashMap if it was possible T_T
    //takes value(quantity of element) mapped to element (the element/element symbol) and adds to it if possible
        //otherwise, creates a new pair with inputted element and inputted Subscript
    private static void addElementSubscript(HashMap<Element,Integer> elementsQuantityMap, Element key, int subscript){
        if (elementsQuantityMap.containsKey(key)){
            int newSubscript = elementsQuantityMap.get(key) + subscript; //adds subscript passed through this method to value of value associated with key
            elementsQuantityMap.replace(key, newSubscript); //sets value to new value
        } else
            elementsQuantityMap.put(key,subscript);
    }
    private static HashMap<Element,Integer>convertCompound(String formula) {
        HashMap<Element,Integer>elementsQuantityMap= new HashMap<>();
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
                addElementSubscript(elementsQuantityMap, element.get(symbol), subscript);
            }
            //check for opening parenthesis
            //saves the substring within (   ) and inputs that into convertCompound recursively
            //return of convertCompound's quantities in elementsQuantityMap is added to main elementsQuantityMap
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
                Map<Element,Integer>tempElementsQuantityMap=convertCompound(formula.substring(startIndex,endIndex));
                for (Map.Entry<Element,Integer> entry: tempElementsQuantityMap.entrySet())
                    addElementSubscript(elementsQuantityMap, entry.getKey(), entry.getValue()*subscript);
            }
        }
        if (!elementsQuantityMap.isEmpty())
            return elementsQuantityMap;
        else
            //Invalid inputs that cannot be converted into elemental composition and thus would leave hashmap empty(i.e. "oKi{4}d)
            throw new NumberFormatException("Inputted String cannot be converted into elemental composition");
    }
    /*method used to convert an equation with:
        reactant HashMap of compound(String) to its quantity(int)
        product HashMap of compound(String) to its quantity(int)
        used to breakdown a full equation into more usable chunks of compounds and coefficients
     */
    private static ArrayList<HashMap<String,Integer>> convertEquation(String formula){
        ArrayList<HashMap<String,Integer>> formulaBreakdown = new ArrayList<>(2);
        //HashMap of a compound String in an equation (either reactant or product) to its quantity (coefficient)
        HashMap<String,Integer> reactantHashMap = new HashMap<>();
        HashMap<String,Integer> productHashMap = new HashMap<>();
        //Primary iterator over the inputted String named formula to process
        boolean doProducts=false;
        for (int i=0; i<formula.length(); i++){
            int coefficient=1;
            if (Character.isDigit((formula.charAt(i)))) {
                final int startIndex=i;
                int endIndex=i+1;
                while (formula.length() > i + 1 && Character.isDigit(formula.charAt(i + 1))) {
                    i++;
                    endIndex++;
                }
                i++;
                coefficient=Integer.parseInt(formula.substring(startIndex,endIndex));
            }
            final int startIndex=i;
            int endIndex=i+1;
            while (formula.length()>i+1 && formula.charAt(i+1)!='+' && formula.charAt(i+1)!='='){ //a '+' or '=' terminates this while loop
                i++;
                endIndex++;
            }
            if (!doProducts)
                reactantHashMap.put(formula.substring(startIndex,endIndex), coefficient);
            else
                productHashMap.put(formula.substring(startIndex,endIndex), coefficient);
            if (formula.length()>i+1 && formula.charAt(i+1)=='+')
                i++;
            if (formula.length()>i+1 && formula.charAt(i+1)=='='){
                i++;
                doProducts=true;
            }

        }
        formulaBreakdown.addLast(reactantHashMap);
        formulaBreakdown.addLast(productHashMap);
        return formulaBreakdown;
    }
    public static float findMolarMass (String formula){
        float molarMass=0;
        Map<Element,Integer> elementQuantityMap = new HashMap<>(convertCompound(formula));
        for (Map.Entry<Element, Integer> entry: elementQuantityMap.entrySet()){
            molarMass+=entry.getKey().getAtomicMass()*entry.getValue();
        }
        return molarMass;
    }
    public static void findPercentComposition (String formula){
        float molarMass=0;
        Map<Element,Integer> elementQuantityMap = new HashMap<>(convertCompound(formula));
        for (Map.Entry<Element, Integer> entry: elementQuantityMap.entrySet()){
            molarMass+=entry.getKey().getAtomicMass()*entry.getValue();
        }
        for (Map.Entry<Element, Integer> entry: elementQuantityMap.entrySet()){
            System.out.println("    "+entry.getKey().getElementName() + ": " +  //gets element name of entry
                    ((entry.getKey().getAtomicMass()*entry.getValue())/molarMass)*100 +"%");  //gets percent composition of entry
        }
    }
    public static float molarStoichiometry (String formula, float givenMoles, String givenCompound, String outputCompound){
        float outputMoles=0F;
        ArrayList<HashMap<String,Integer>> equationMapAccess=new ArrayList<>(convertEquation(formula)); //bundle for two hashmaps
        HashMap<String,Integer> reactantsMap=new HashMap<>(equationMapAccess.getFirst());
        HashMap<String,Integer> productsMap=new HashMap<>(equationMapAccess.getLast());
        outputMoles=givenMoles*((float) productsMap.get(outputCompound) /
                                        reactantsMap.get(givenCompound));
        if (outputMoles==0F)
            throw new NumberFormatException("Could not convert to float number of moles");
        return outputMoles;
    }
    // converts units (moles, grams, or liters) to moles
    public static float convertToMoles (String inputUnit, float amount, String inputCompound){
        return switch (inputUnit) {
            case "1", "mol", "mole", "moles" -> amount; //moles stay same because it is the same unit
            case "2", "g", "gram", "grams" -> amount / findMolarMass(inputCompound); //grams divided by g/mol(from molar mass of compound) to get moles
            case "3", "l", "liter", "liters" -> amount / LITERS_PER_MOLE; //liters divided by l/mol(gas at STP: 22l/mol) to get moles
            default -> throw new IllegalArgumentException("Input did not match any unit input case");
        };
    }
    // converts moles to unit (mole, gram, or liter)
    public static float molesToUnit (String outputUnit, float moles, String outputCompound){
        return switch (outputUnit) {
            case "1", "mol", "mole", "moles" -> moles; //moles stays same because it is the same unit
            case "2", "g", "gram", "grams" -> moles * findMolarMass(outputCompound); //moles times g/mol(from molar mass of compound) to get grams
            case "3", "l", "liter", "liters" -> moles * LITERS_PER_MOLE; //moles times l/mol(gas at STP: 22l/mol) to get liters
            default -> throw new IllegalArgumentException("Input did not match any unit output case");
        };
    }
}
