import java.util.Stack;

public class InterpreteurMACH {
    private Stack<Integer> MEM = new Stack<>();
    private int SP = 0;
    private String[] P_CODE;
    public void execute(String[] P_CODE) {
        for (int i = 0; i < P_CODE.length; i++) {
            String INST = P_CODE[i];
            switch (INST) {
                case "ADD":
                    add();
                    break;
                case "SUB":
                    sub();
                    break;
                case "MUL":
                    mul();
                    break;
                case "DIV":
                    div();
                    break;
                case "EQL":
                    eql();
                    break;
                case "NEQ":
                    neq();
                    break;
                case "GTR":
                    gtr();
                    break;
                case "LSS":
                    lss();
                    break;
                case "GEQ":
                    geq();
                    break;
                case "LEQ":
                    leq();
                    break;
                case "PRN":
                    prn();
                    break;
                case "INN":
                    inn();
                    break;
                case "INT":
                    intInstruction(Integer.parseInt(P_CODE[i + 1]));
                    i++; // Pour sauter le paramètre de l'instruction INT.
                    break;
                case "LDI":
                    ldi(Integer.parseInt(P_CODE[i + 1]));
                    i++; // Pour sauter le paramètre de l'instruction LDI.
                    break;
                case "LDA":
                    lda(Integer.parseInt(P_CODE[i + 1]));
                    i++; // Pour sauter le paramètre de l'instruction LDA.
                    break;
                case "LDV":
                    ldv();
                    break;
                case "STO":
                    sto();
                    break;
                case "BRN":
                    brn(Integer.parseInt(P_CODE[i + 1]));
                    i++; // Pour sauter le paramètre de l'instruction BRN.
                    break;
                case "BZE":
                    bze(Integer.parseInt(P_CODE[i + 1]));
                    i++; // Pour sauter le paramètre de l'instruction BZE.
                    break;
                case "HLT":
                    return; // Arrête l'exécution.
                default:
                    // Gérer les erreurs d'instructions inconnues.
                    System.err.println("Instruction inconnue : " + INST);
                    break;
            }
        }
    }

    private void add() {
        int a = MEM.pop();
        int b = MEM.pop();
        MEM.push(a + b);
    }

    private void sub() {
        int a = MEM.pop();
        int b = MEM.pop();
        MEM.push(b - a);
    }

    private void mul() {
        int a = MEM.pop();
        int b = MEM.pop();
        MEM.push(a * b);
    }

    private void div() {
        int a = MEM.pop();
        int b = MEM.pop();
        MEM.push(b / a);
    }

    private void eql() {
        int a = MEM.pop();
        int b = MEM.pop();
        MEM.push(a == b ? 1 : 0);
    }

    private void neq() {
        int a = MEM.pop();
        int b = MEM.pop();
        MEM.push(a != b ? 1 : 0);
    }

    private void gtr() {
        int a = MEM.pop();
        int b = MEM.pop();
        MEM.push(b > a ? 1 : 0);
    }

    private void lss() {
        int a = MEM.pop();
        int b = MEM.pop();
        MEM.push(b < a ? 1 : 0);
    }

    private void geq() {
        int a = MEM.pop();
        int b = MEM.pop();
        MEM.push(b >= a ? 1 : 0);
    }

    private void leq() {
        int a = MEM.pop();
        int b = MEM.pop();
        MEM.push(b <= a ? 1 : 0);
    }

    private void prn() {
        System.out.println(MEM.peek());
        MEM.pop();
    }

    private void inn() {
        // Simule la lecture d'un entier depuis l'entrée.
        int inputValue = 42; // Remplacez par votre propre logique de saisie.
        MEM.push(inputValue);
    }

    private void intInstruction(int c) {
        SP += c;
    }

    private void ldi(int v) {
        MEM.push(v);
    }

    private void lda(int a) {
        MEM.push(SP + a);
    }

    private void ldv() {
        int a = MEM.pop();
        MEM.push(MEM.get(a));
    }

    private void sto() {
        int a = MEM.pop();
        int v = MEM.pop();
        MEM.set(a, v);
    }

    private void brn(int i) {
        // Implémentez ici la logique pour effectuer le branchement non conditionnel.
        // Vous pouvez mettre en œuvre cela en ajustant la variable 'i' selon vos besoins.
        // Par exemple, en utilisant un saut absolu ou relatif dans le tableau P_CODE.
        // Assurez-vous de gérer les cas où 'i' est en dehors des limites du tableau.
    
        // Exemple de saut absolu :
        if (i >= 0 && i < P_CODE.length) {
            i = i - 1; // Correction pour l'incrémentation ultérieure dans la boucle 'for'.
        } else {
            // Gérer les erreurs de branchement hors limites.
            System.err.println("Erreur de branchement absolu en dehors des limites : " + i);
            return;
        }
    
        // Effectuer le saut absolu.
        i = i - 1; // Correction pour l'incrémentation ultérieure dans la boucle 'for'.
    }
    
    private void bze(int i) {
        // Récupérer la condition à partir de la pile.
        int condition = MEM.pop();
    
        // Vérifier si la condition est égale à zéro.
        if (condition == 0) {
            // Si la condition est vraie (égal à zéro), effectuer le saut conditionnel.
    
            // Ajuster 'i' pour l'utiliser comme index dans le tableau P_CODE.
            int targetIndex = i - 1;
    
            // Vérifier que l'index de saut est valide.
            if (targetIndex >= 0 && targetIndex < P_CODE.length) {
                // Effectuer le saut conditionnel.
                i = targetIndex;
            } else {
                // Gérer les erreurs de branchement hors limites.
                System.err.println("Erreur de branchement conditionnel en dehors des limites : " + i);
                return;
            }
        }
    
        // Si la condition n'est pas vraie, continuer l'exécution normale.
    }
    

}
