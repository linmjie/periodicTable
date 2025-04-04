import java.util.HashMap;
import java.util.Map;

public class ChemistryEquation {
    //HashMap of strings(element symbols) to the element objects
    private static final HashMap<String, Element> element = new HashMap<>(Symbol.createPeriodicTable());
    //22.4L/Mol at STP
    private final static float LITERS_PER_MOLE = 22.4F;
    //Would be a non-static method applied to a HashMap if it was possible T_T
    //takes value(quantity of element) mapped to element (the element/element symbol) and adds to it if possible
        //otherwise, creates a new pair with inputted element and inputted coefficient
    private static void addElementCoefficient(HashMap<Element,Integer> elementsQuantityMap, Element key, int coefficient){
        if (elementsQuantityMap.containsKey(key)){
            int newCoefficient = elementsQuantityMap.get(key) + coefficient;
            elementsQuantityMap.replace(key, newCoefficient);
        } else
            elementsQuantityMap.put(key,coefficient);
    }
    //
    private static HashMap<Element,Integer>convertEquation(String formula) {
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
                addElementCoefficient(elementsQuantityMap, element.get(symbol), subscript);
            }
            //check for opening parenthesis
            //saves the substring within (   ) and inputs that into convertEquation recursively
            //return of convertEquation's quantities in elementsQuantityMap is added to main elementsQuantityMap
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
                Map<Element,Integer>tempElementsQuantityMap=convertEquation(formula.substring(startIndex,endIndex));
                for (Map.Entry<Element,Integer> entry: tempElementsQuantityMap.entrySet())
                    addElementCoefficient(elementsQuantityMap, entry.getKey(), entry.getValue()*subscript);
            }
        }
        if (!elementsQuantityMap.isEmpty())
            return elementsQuantityMap;
        else
            //Invalid inputs that cannot be converted into elemental composition and thus would leave hashmap empty(i.e. "oKi{4}d)
            throw new NumberFormatException("Inputted String cannot be converted into elemental composition");
    }
    public static float findMolarMass (String formula){
        float molarMass=0;
        Map<Element,Integer> elementQuantityMap = new HashMap<>(convertEquation(formula));
        for (Map.Entry<Element, Integer> entry: elementQuantityMap.entrySet()){
            molarMass+=entry.getKey().getAtomicMass()*entry.getValue();
        }
        return molarMass;
    }
    public static void findPercentComposition (String formula){
        float molarMass=0;
        Map<Element,Integer> elementQuantityMap = new HashMap<>(convertEquation(formula));
        for (Map.Entry<Element, Integer> entry: elementQuantityMap.entrySet()){
            molarMass+=entry.getKey().getAtomicMass()*entry.getValue();
        }
        for (Map.Entry<Element, Integer> entry: elementQuantityMap.entrySet()){
            System.out.println(entry.getKey().getElementName() + ": " +
                    ((entry.getKey().getAtomicMass()*entry.getValue())/molarMass)*100 +"%");
        }
    }
}
