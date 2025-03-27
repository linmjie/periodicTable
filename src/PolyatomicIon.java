import java.util.HashMap;
public class PolyatomicIon extends Element{
    private HashMap<Element,Integer> elementCount = new HashMap<>();
    public PolyatomicIon(HashMap<Element,Integer> elementCount, String ionName, int charge, float atomicMass, int atomicNumber){
        //calculate molar mass here
        //no element name, ion name only (i.e. nitrate); hence elementName is null
        super(ionName, charge,null, atomicMass, atomicNumber);
        this.elementCount=elementCount;
    }
    public HashMap<Element,Integer> getElementCount(){
        return elementCount;
    }
    @Override
    public String toString(){
        return "Ion Name: " + getIonName() + " , " + "Ion Charge: " + getCharge() + ","
                + "Atomic Number: " + getAtomicNumber() + " , " + "Molecular Mass: " + getAtomicMass();
    }
}
