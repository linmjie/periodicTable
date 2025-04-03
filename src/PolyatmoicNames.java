public class PolyatmoicNames {

    public PolyatmoicNames(){

    }

    public String findName(String name){
        name = name.toLowerCase();
        switch(name){
            case "acetate":
                return "C2H3O2-";
            case "ammonium":
                return "NH4-";
            case "carbonate":
                return "CO3-2";
            case "chlorate":
                return "ClO3-";
            case "chlorite":
                return "ClO2-";
            case "chromate":
                return "C4O4 -2";
            case "cyanide":
                return "CN-";
            case "hydroxide":
                return "OH-";
            case "hypochlorate":
                return "ClO-";
            case "nitrate":
                return "NO3-";
            case "nitrite":
                return "NO2-";
            case "oxalate":
                return "C2O4 -2";
            case "phosphate":
                return "PO4 -3";
            case "sulfate":
                return "SO4 -2";
            case "sulfite":
                return "SO3 -2";
        }
        return null;
    }
}
