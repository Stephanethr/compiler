
public class Main {
    public static void main(String[] args) {
        InterpreteurMACH interpreter = new InterpreteurMACH();
        String[] P_CODE = {
                "INT", "3",
                "INT", "2",
                "ADD",
                "PRN",
                "HLT"
        };
        interpreter.execute(P_CODE);
        // Exemple d'utilisation du compilateur avec l'analyseur lexical et la table des
        // symboles.
        String programmeSource = "program example ; const x = 42 ; var y ; begin write(x + y) ; end.";

        Compilateur compilateur = new Compilateur(programmeSource);
        compilateur.compiler();
        // Exemple d'utilisation pour générer une instruction P-Code LDA avec un
        // opérande.
        String instructionLDA = generer2(LDA, 42);
        System.out.println(instructionLDA);

        // Exemple d'utilisation pour générer une instruction P-Code ADD sans opérande.
        String instructionADD = generer1(ADD);
        System.out.println(instructionADD);
    }
}
