import java.util.HashMap;
import java.util.Map;

public class PolyatomicIon extends Element{
    private final Map<Element,Integer>elementCount;
    public PolyatomicIon(HashMap<Element,Integer> elementCount, String ionName, int charge){
        //calculate molar mass here
        //no element name, ion name only (i.e. nitrate); hence elementName is null
        super(ionName, charge,null, 0, 0);
        this.elementCount=elementCount;
        float tempMass=0F;
        for (Map.Entry<Element,Integer> entry: elementCount.entrySet()){
            tempMass+=entry.getKey().getAtomicMass()*entry.getValue();
        }
        super.setAtomicMass(tempMass);
    }
    public Map<Element,Integer> getElementCount(){
        return elementCount;
    }
    @Override
    public String toString(){
        return "Ion Name: " + getIonName() + " , " + "Ion Charge: " + getCharge() + ","
                + "Atomic Number: " + getAtomicNumber() + " , " + "Molecular Mass: " + getAtomicMass();
    }
}
