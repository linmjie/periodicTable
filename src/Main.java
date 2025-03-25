import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        HashMap<String, Element> element = new HashMap<>(Symbol.createPeriodicTable());
        System.out.println(element.get("F"));
    }
}