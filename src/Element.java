public class Element {
    private String elementName;
    private float atomicMass;
    private int atomicNumber;
    public Element (String elementName, float atomicMass, int atomicNumber){
        this.elementName=elementName;
        this.atomicMass=atomicMass;
        this.atomicNumber=atomicNumber;
    }
    //no atomic mass
    public Element (String elementName, int atomicNumber){
        this.elementName=elementName;
        this.atomicNumber=atomicNumber;
    }

    public String getElementName (){
       return elementName;
    }
    public float getAtomicMass(){
        return atomicMass;
    }
    public int getAtomicNumber (){
        return atomicNumber;
    }
    @Override
    public String toString(){
        return "Element Name: " + getElementName() + " , " + "Atomic Number: " + getAtomicNumber() + " , " + "Atomic Mass: " + getAtomicMass();
    }
}