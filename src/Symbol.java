import java.util.HashMap;

public class Symbol {
    static Element H = new Element ( "hydrogen", 1.00794F, 1);
    static Element He = new Element ("helium", 4.00260F, 2);
    static Element Li = new Element ("lithium", 6.941F, 3);
    static Element Be = new Element ("beryllium", 9.012182F, 4);
    static Element B = new Element ("boron", 10.81F, 5);
    static Element C = new Element ("carbon", 12.0111F, 6);
    static Element N = new Element ("nitrogen", 14.0067F, 7);
    static Element O = new Element ("oxygen", 15.9994F, 8);
    static Element F = new Element ("fluorine", 18.9984032F, 9);
    static Element Ne = new Element ("neon", 20.1797F, 10);
    static Element Na = new Element ("sodium", 22.98977F, 11);
    static Element Mg = new Element ("magnesium", 24.305F, 12);
    static Element Al = new Element ("aluminum", 26.9815154F, 13);
    static Element Si = new Element ("silicon", 28.0855F, 14);
    static Element P = new Element ("phosphorus", 30.973756F, 15);
    static Element S = new Element ("sulfur", 32.06F, 16);
    static Element Cl = new Element ("chlorine", 35.453F, 17);
    static Element Ar = new Element ("argon", 39.948F, 18);
    static Element K = new Element ("potassium", 39.0983F, 19);
    static Element Ca = new Element ("calcium", 40.08F, 20);
    static Element Sc = new Element ("scandium", 44.9559F, 21);
    static Element Ti = new Element ("titanium", 47.88F, 22);
    static Element V = new Element ("vanadium", 50.9415F, 23);
    static Element Cr = new Element ("chromium", 51.996F, 24);
    static Element Mn = new Element ("manganese", 54.9380F, 25);
    static Element Fe = new Element ("iron", 55.847F, 26);
    static Element Co = new Element ("cobalt", 58.9332F, 27);
    static Element Ni = new Element ("nickel", 58.69F, 28);
    static Element Cu = new Element ("copper", 63.546F, 29);
    static Element Zn = new Element ("zinc", 65.39F, 30);
    static Element Ga = new Element ("gallium", 69.72F, 31);
    static Element Ge = new Element ("germanium", 72.59F, 32);
    static Element As = new Element ("arsenic", 74.9216F, 33);
    static Element Se = new Element ("selenium", 78.96F, 34);
    static Element Br = new Element ("bromine",79.904F, 35);
    static Element Kr = new Element ("krypton", 83.80F, 36);
    static Element Rb = new Element ("rubidium", 85.4678F, 37);
    static Element Sr = new Element ("strontium", 87.62F, 38);
    static Element Y = new Element ("yttrium" , 88.9059F, 39);
    static Element Zr = new Element ("zirconium", 91.224F, 40);
    static Element Nb = new Element ("niobium", 92.9064F, 41);
    static Element Mo = new Element ("molybdenum", 95.94F, 42);
    static Element Tc = new Element ("technetium", 98F, 43);
    static Element Ru = new Element ("ruthenium", 101.07F, 44);
    static Element Rh = new Element ("rhodium", 102.906F, 45);
    static Element Pd = new Element ("palladium", 106.42F, 46);
    static Element Ag = new Element ("silver", 107.868F, 47);
    static Element Cd = new Element ("cadmium", 112.41F, 48);
    static Element In = new Element ("indium", 114.82F, 49);
    static Element Sn = new Element ("tin", 118.71F, 50);
    static Element Sb = new Element ("antimony", 121.75F, 51);
    static Element Te = new Element ("tellurium", 127.60F, 52);
    static Element I = new Element ("iodine", 126.905F, 53);
    static Element Xe = new Element ("xenon", 131.29F, 54);
    static Element Cs = new Element ("cesium", 132.905F, 55);
    static Element Ba = new Element ("barium", 137.33F, 56);
    static Element La = new Element ("La", 138.906F, 57);
    static Element Ce = new Element ("cerium", 140.12F, 58);
    static Element Pr = new Element ("praseodymium", 140.908F, 59);
    static Element Nd = new Element ("neodymium", 144.24F, 60);
    static Element Pm = new Element ("promethium", 145F, 61);
    static Element Sm = new Element ("samarium", 150.36F, 62);
    static Element Eu = new Element ("europium", 151.96F, 63);
    static Element Gd = new Element ("gadolinium", 157.25F, 64);
    static Element Tb = new Element ("terbium", 158.925F, 65);
    static Element Dy = new Element ("dysprosium", 162.50F, 66);
    static Element Ho = new Element ("holmium", 164.9390F, 67);
    static Element Er = new Element ("erbium", 167.26F, 68);
    static Element Tm = new Element ("thulium", 168.934F, 69);
    static Element Yb = new Element ("ytterbium", 173.04F, 70);
    static Element Lu = new Element ("lutetium", 174.967F, 71);
    static Element Hf = new Element ("hafnium", 178.49F, 72);
    static Element Ta = new Element ("tantalum", 180.948F, 73);
    static Element W = new Element ("tungsten", 183.85F, 74);
    static Element Re = new Element ("rhenium", 186.207F, 75);
    static Element Os = new Element ("osmium", 190.2F, 76);
    static Element Ir = new Element ("iridium", 192.22F, 77);
    static Element Pt = new Element ("platinum", 195.08F, 78);
    static Element Au = new Element ("gold", 196.967F, 79);
    static Element Hg = new Element ("mercury", 200.59F, 80);
    static Element Tl = new Element ("thallium", 204.383F, 81);
    static Element Pb = new Element ("lead", 207.2F, 82);
    static Element Bi = new Element ("bismuth", 208.980F, 83);
    static Element Po = new Element ("polonium", 209F, 84);
    static Element At = new Element ("astatine", 210F, 85);
    static Element Rn = new Element ("radon", 222F, 86);
    static Element Fr = new Element ("francium", 223F, 87);
    static Element Ra = new Element ("radium", 226.025F, 88);
    static Element Ac = new Element ("actinium", 227.028F, 89);
    static Element Th = new Element ("thorium", 232.038F, 90);
    static Element Pa = new Element ("protactinium", 231.036F, 91);
    static Element U = new Element ("uranium", 238.029F, 92);
    static Element Np = new Element ("neptunium", 237.048F, 93);
    static Element Pu = new Element ("plutonium", 244F, 94);
    static Element Am = new Element ("americium", 243F, 95);
    static Element Cm = new Element ("curium", 247F, 96);
    static Element Bk = new Element ("berkelium", 247F, 97);
    static Element Cf = new Element ("californium", 251F, 98);
    static Element Es = new Element ("einsteinium", 252F, 99);
    static Element Fm = new Element ("fermium", 257F, 100);
    static Element Md = new Element ("mendelevium", 258F, 101);
    static Element No = new Element ("nobelium", 259F, 102);
    static Element Lr = new Element ("lawrencium", 262F, 103);
    static Element Rf = new Element ("rutherfordium", 261F, 104);
    static Element Db = new Element ("Dubnium", 262F, 105);
    static Element Sg = new Element ("seaborgium", 263F, 106);
    static Element Bh = new Element ("bohrium", 262F, 107);
    static Element Hs = new Element ("hassium", 265F, 108);
    static Element Mt = new Element ("meitnerium", 266F, 109);
    /*
    static Element Ds = new Element ("darmstadtium", 110);
    static Element Rg = new Element ("roentgenium", 272F, 111);
    static Element Uub = new Element ("ununbium", 112);
    static Element Uut = new Element ("ununtrium", 113);
    static Element Uuq = new Element ("ununquadium", 114);
    static Element Uup = new Element ("ununpentium", 115);
    static Element Uuh = new Element ("ununhexium", 116);
    static Element Uus = new Element ("ununseptium", 117);
    static Element Uuo = new Element ("ununoctium", 118);
     */
    public static HashMap<String, Element> createPeriodicTable (){
        return new HashMap<>(109){{
            put("H",H); put("He",He);
            put("Li",Li); put("Be",Be); put("B",B); put("C",C); put("N",N); put("O",O); put("F",F); put("Ne",Ne);
            put("Na",Na); put("Mg",Mg); put("Al",Al); put("Si",Si); put("P",P); put("S",S); put("Cl",Cl); put("Ar",Ar);
            put("K",K); put("Ca",Ca); put("Sc",Sc); put("Ti",Ti); put("V",V); put("Cr",Cr); put("Mn",Mn); put("Fe",Fe); put("Co",Co); put("Ni",Ni); put("Cu",Cu); put("Zn",Zn); put("Ga",Ga); put("Ge",Ge); put("As",As); put("Se",Se); put("Br",Br); put("Kr",Kr);
            put("Rb",Rb); put("Sr",Sr); put("Y",Y); put("Zr",Zr); put("Nb",Nb); put("Mo",Mo); put("Tc",Tc); put("Ru",Ru); put("Rh",Rh); put("Pd",Pd); put("Ag",Ag); put("Cd",Cd); put("In",In); put("Sn",Sn); put("Sb",Sb); put("Te",Te); put("I",I); put("Xe",Xe);
            put("Cs",Cs); put("Ba",Ba); put("La",La);
            put("Ce",Ce); put("Pr",Pr); put("Nd",Nd); put("Pm",Pm); put("Sm",Sm); put("Eu",Eu); put("Gd",Gd); put("Tb",Tb); put("Dy",Dy); put("Ho",Ho); put("Er",Er); put("Tm",Tm); put("Yb",Yb); put("Lu",Lu);
            put("Hf",Hf); put("Ta",Ta); put("W",W); put("Re",Re); put("Os",Os); put("Ir",Ir); put("Pt",Pt); put("Au",Au); put("Hg",Hg); put("Tl",Tl); put("Pb",Pb); put("Bi",Bi); put("Po",Po); put("At",At); put("Rn",Rn);
            put("Fr",Fr); put("Ra",Ra); put("Ac",Ac);
            put("Th",Th); put("Pa",Pa); put("U",U); put("Np",Np); put("Pu",Pu); put("Am",Am); put("Cm",Cm); put("Bk",Bk); put("Cf",Cf); put("Es",Es); put("Fm",Fm); put("Md",Md); put("No",No); put("Lr",Lr);
            put("Rf",Rf); put("Db",Db); put("Sg",Sg); put("Bh",Bh); put("Hs",Hs); put("Mt",Mt);
        }};
    }
}