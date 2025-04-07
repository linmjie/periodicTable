public class Element {
    private String elementName;
    private float atomicMass;
    private int atomicNumber;

    private String ionName;
    private int charge;
    private int[]chargeArray;
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
    //ions with multiple charges
    public Element(String ionName, int[]chargeArray, String elementName, float atomicMass, int atomicNumber){
        this.elementName=elementName;
        this.atomicMass=atomicMass;
        this.atomicNumber=atomicNumber;
        this.ionName=ionName;
        this.chargeArray=chargeArray;
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
    public void setAtomicMass(float atomicMass){
        this.atomicMass=atomicMass;
    }
    public String getIonName(){
        return ionName;
    }
    public int getCharge(){
        return charge;
    }
    public int[]getChargeArray(){
        return chargeArray;
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