public class Element {
    private String elementName;
    private float atomicMass;
    private int atomicNumber;

    private String ionName;
    private int charge;
    public Element (String elementName, float atomicMass, int atomicNumber){
        this.elementName=elementName;
        this.atomicMass=atomicMass;
        this.atomicNumber=atomicNumber;
    }
    //for ions
    public Element(String ionName, int charge, String elementName, float atomicMass, int atomicNumber){
        this.elementName=elementName;
        this.atomicMass=atomicMass;
        this.atomicNumber=atomicNumber;
        this.ionName=ionName;
        this.charge=charge;
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

    public String getIonName(){
        return ionName;
    }
    public int getCharge(){
        return charge;
    }
    @Override
    public String toString(){
        if (this.ionName==null)
            //not ion
            return "Element Name: " + getElementName() + " , " + "Atomic Number: " + getAtomicNumber() + " , " + "Atomic Mass: " + getAtomicMass();
        else
            //ion
            return "Ion Name: " +  getIonName() + " , " + "Element Name: " + "Ion Charge: " + getCharge() + "," +
                    getElementName() + " , " + "Atomic Number: " + getAtomicNumber() + " , " + "Atomic Mass: " + getAtomicMass();
    }
}