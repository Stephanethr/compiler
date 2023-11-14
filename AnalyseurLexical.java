import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalyseurLexical {
    private String input; // Le programme source en entrée.
    private int currentPos; // La position actuelle dans le programme source.

    // Les mots-clés du langage.
    private final List<String> keywords = Arrays.asList("program", "const", "var", "begin", "end", "if", "then", "while", "do", "write", "read");

    // Les symboles spéciaux du langage.
    private final List<Character> symbols = Arrays.asList(';', ':', ',', '(', ')', '+', '-', '*', '/');

    public AnalyseurLexical(String input) {
        this.input = input;
        this.currentPos = 0;
    }

    // Méthode principale pour effectuer l'analyse lexicale.
    public List<Token> analyser() {
        List<Token> tokens = new ArrayList<>();

        while (currentPos < input.length()) {
            char currentChar = input.charAt(currentPos);

            // Ignorer les espaces et les retours à la ligne.
            if (Character.isWhitespace(currentChar)) {
                currentPos++;
                continue;
            }

            // Identifier les mots-clés, les identificateurs et les numéros.
            if (Character.isLetter(currentChar)) {
                String lexeme = getIdentifier();
                if (keywords.contains(lexeme)) {
                    tokens.add(new Token(TokenType.KEYWORD, lexeme));
                } else {
                    tokens.add(new Token(TokenType.IDENTIFIER, lexeme));
                }
            } else if (Character.isDigit(currentChar)) {
                String lexeme = getNumber();
                tokens.add(new Token(TokenType.NUMBER, lexeme));
            } else if (symbols.contains(currentChar)) {
                // Identifier les symboles spéciaux.
                tokens.add(new Token(TokenType.SYMBOL, String.valueOf(currentChar)));
                currentPos++;
            } else {
                // Gérer les caractères inattendus.
                System.err.println("Caractère inattendu : " + currentChar);
                currentPos++;
            }
        }

        return tokens;
    }

    // Méthode pour obtenir un identificateur à partir de la position actuelle.
    private String getIdentifier() {
        StringBuilder identifier = new StringBuilder();

        while (currentPos < input.length() && (Character.isLetterOrDigit(input.charAt(currentPos)))) {
            identifier.append(input.charAt(currentPos));
            currentPos++;
        }

        return identifier.toString();
    }

    // Méthode pour obtenir un nombre à partir de la position actuelle.
    private String getNumber() {
        StringBuilder number = new StringBuilder();

        while (currentPos < input.length() && Character.isDigit(input.charAt(currentPos))) {
            number.append(input.charAt(currentPos));
            currentPos++;
        }

        return number.toString();
    }

    // Enumération pour représenter les types de tokens.
    public enum TokenType {
        KEYWORD,
        IDENTIFIER,
        NUMBER,
        SYMBOL
    }

    // Classe pour représenter un token.
    public static class Token {
        private final TokenType type;
        private final String lexeme;

        public Token(TokenType type, String lexeme) {
            this.type = type;
            this.lexeme = lexeme;
        }

        @Override
        public String toString() {
            return "[" + type + ": " + lexeme + "]";
        }
    }

    public static void main(String[] args) {
        // Exemple d'utilisation de l'analyseur lexical.
        String programmeSource = "program example ; const x = 42 ; var y ; begin write(x + y) ; end.";

        AnalyseurLexical analyseurLexical = new AnalyseurLexical(programmeSource);
        List<Token> tokens = analyseurLexical.analyser();

        // Afficher les tokens obtenus.
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}

