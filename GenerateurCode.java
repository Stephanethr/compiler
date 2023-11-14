public class GenerateurCode {
    // Vous pouvez définir des constantes pour les opérations P-Code.
    private static final String LDA = "LDA";
    private static final String STO = "STO";
    private static final String ADD = "ADD";
    private static final String SUB = "SUB";
    private static final String MUL = "MUL";
    private static final String DIV = "DIV";
    private static final String PRN = "PRN";
    private static final String INN = "INN";
    private static final String HLT = "HLT";
    private static final String JMP = "JMP";
    private static final String JPC = "JPC";

    // Votre programme pourrait contenir d'autres attributs et méthodes nécessaires.

    // Méthode pour générer une instruction P-Code à un seul opérande.
    private static String generer1(String operation) {
        return operation;
    }

    // Méthode pour générer une instruction P-Code à deux opérandes.
    private static String generer2(String operation, int operand) {
        return operation + " " + operand;
    }

    // Méthode pour générer une instruction P-Code à deux opérandes (pour les branchements conditionnels).
    private static String generer2(String operation, String label) {
        return operation + " " + label;
    }

    // Ajoutez d'autres méthodes de génération de code en fonction de vos besoins.

    public static void main(String[] args) {

    }
}
