
public class Main {
    public static void main(String[] args) {
        InterpreteurMACH interpreter = new InterpreteurMACH();
        String[] P_CODE = {
                "INT", "3",
                "INT", "-2",
                "ADD",
                "PRN",
                "HLT"
        };
        interpreter.execute(P_CODE);
    }
}
