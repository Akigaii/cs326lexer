import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
import java.util.List;


public class Main {

    static class Token {
        int category;
        String categoryName;
        String value;
        boolean error;

        public Token(int category, String categoryName, String value) {
            this.category = category;
            this.categoryName = categoryName;
            this.value = value;
            this.error = false;
        }

        public Token(String value, boolean error) {
            this.category = -1;
            this.categoryName = "ERROR";
            this.value = value;
            this.error = true;
        }

        public void printToken() {
            if (error) System.out.println("ERROR: " + this.value + " is invalid.");
            else System.out.println("Token Category: " + category + ", Category Name: " + categoryName + ", Value: " + value);
        }
    }


    public static boolean isOperator(char character){
        char[] operators = {':', '.', ',', '=', '>', '<', '+', '-', '*', '/', '[', ']', '(', ')', '\"'};
        for (char operator : operators) if (character == operator) return true;
        return false;
    }

    public static boolean isLetter(char character){
        int ascii = (int) character;
        if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) return true;
        return false;
    }

    public static boolean isDigit(char character){
        int ascii = (int) character;
        if ((ascii >= 48 && ascii <= 57)) return true;
        return false;
    }


    public static void repopulate (ArrayList<Token> victim, ArrayList<Token> target){
        victim.clear();
        victim.addAll(target);
    }

    public static char lookAheadOneChar(int currentPosition, String filePath) {
        try { // Returns the next character of a reader without updating it.
            BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
            tempReader.skip(currentPosition);
            int ascii =  tempReader.read();
            char character = (char) ascii;
            return character;
        } catch (Exception e) {
            return '\0';
        }
    }

    public static int matchCaseDistance(int currentPosition, char match, String filePath) {
        try { // Finds distance between reader position on a single match character.
            int distance = 0;
            BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
            tempReader.skip(currentPosition);
            while (true) {
                int tempAscii = tempReader.read();
                char tempCharacter = (char) tempAscii;
                if (tempAscii == -1 || tempCharacter == match) break;
                distance++;
            }
            return distance;

        }
        catch (Exception e) {
            return -999;
        }
    }

    public static int matchCaseDistance2(int currentPosition, char match1, char match2, String filePath) {
        try { // Finds distance between reader position on two sequential match characters.
            int distance = 0;
            BufferedReader slow = new BufferedReader(new FileReader(filePath));
            BufferedReader fast = new BufferedReader(new FileReader(filePath));
            slow.skip(currentPosition);
            fast.skip(currentPosition + 1);
            while (true) {
                int slowAscii = slow.read();
                int fastAscii = fast.read();
                char slowCharacter = (char) slowAscii;
                char fastCharacter = (char) fastAscii;
                if (fastAscii == -1) break;
                if (distance != 0 && slowCharacter == match1 && fastCharacter == match2) {
                    distance += 2;
                    break;
                }
                distance++;
            }
            return distance;

        }
        catch (Exception e) {
            return -999;
        }
    }


    public static boolean matchCaseExists(int currentPosition, char match, String filePath) {
        try{ // Traverse method to find a single-character match case.
            BufferedReader lookAheadReader = new BufferedReader(new FileReader(filePath));
            lookAheadReader.skip(currentPosition);
            while (true) {
                int tempAscii = lookAheadReader.read();
                char tempCharacter = (char) tempAscii;
                if (tempAscii == -1) return false;
                else if (tempCharacter == match) return true;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    public static boolean matchCaseExists2(int currentPosition, char match1, char match2, String filePath) {
        try{ // Utilize two-pointer method to find a two-character match case.
            BufferedReader slow = new BufferedReader(new FileReader(filePath));
            BufferedReader fast = new BufferedReader(new FileReader(filePath));
            slow.skip(currentPosition);
            fast.skip(currentPosition + 1);
            int lookAhead = 0;
            while (true) {
                int slowAscii = slow.read();
                int fastAscii = fast.read();
                char slowCharacter = (char) slowAscii;
                char fastCharacter = (char) fastAscii;
                if (fastAscii == -1) return false;
                if (slowCharacter == match1 && fastCharacter == match2 && lookAhead != 0) {
                    return true;
                }
                lookAhead++;
            }
        }
        catch (Exception e) {
            return false;
        }
    }


    public static String appendChars(int amt, String str, BufferedReader reader, int readerPosition) {
        try { // Appends characters from reader to a string 'amt' times.
            for (int i = 0; i < amt; i++) {
                int ascii = reader.read();
                readerPosition++;
                char character = (char) ascii;
                str = str + character;
            }
            return str;
        }
        catch (Exception e) {
            return "";
        }
    }


    public static void main(String[] args) throws Exception{
        // Read in input files located inside a directory.
        String directoryPath = "/Users/xmastersteel/IdeaProjects/Lexer/InputFiles";
        File dir = new File(directoryPath);
        File[] directoryListing = dir.listFiles();

        // Redirect all console output into "Output.txt" instead.
        PrintStream fileOut = new PrintStream("Output.txt");
        System.setOut(fileOut);

        // Iterate through all input files.
        for (File child : directoryListing) {
            System.out.println("\n =========     ALL TOKENS FOR " + "\"" + child.getName() + "\""+  "     =========");
            lexer(directoryPath + '/' + child.getName());
        }
    }


    public static void lexer(String filePath){
        try {
            ArrayList<Token> KeywordCandidates = new ArrayList<>(TokenTypes);
            ArrayList<Token> LexedTokens       = new ArrayList<>();
            BufferedReader reader              = new BufferedReader(new FileReader(filePath));
            int readerPosition                 = 0;
            String temp                        = "";

            // Loop through every character in the input file.
            while (true) {

                // Current input file character's attributes.
                int ascii = reader.read();
                char character = (char) ascii;
                readerPosition++;

                // EDGE CASE: If ASCII is an EOF, stop reading input file.
                if (ascii == -1){
                    if (!temp.isEmpty()) { // Clears hanging identifiers.
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        repopulate(KeywordCandidates, TokenTypes);
                    }
                    break;
                }

                // EDGE CASE: If ASCII is a ' ' or a '\n', disregard.
                if (character == ' ' || character == '\n') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        repopulate(KeywordCandidates, TokenTypes);
                    }
                    temp = "";
                    continue;
                }

                // EDGE CASE: Strings
                if (character == '"') {
                    if (matchCaseExists(readerPosition, '"', filePath)) {
                        int lookAhead = matchCaseDistance(readerPosition, '"', filePath) + 1;
                        temp += character + appendChars(lookAhead, temp, reader, readerPosition);
                        readerPosition += lookAhead;
                        LexedTokens.add(new Token(67, "STRING", temp));
                        temp = "";
                        continue;
                    }
                }

                // EDGE CASE: Comments
                if (character == '/') {
                    // Single-line comments.
                    if (lookAheadOneChar(readerPosition, filePath) == '/') {
                        int lookAhead = matchCaseDistance(readerPosition + 1, '\n', filePath) + 1;
                        temp += character + appendChars(lookAhead, temp, reader, readerPosition);
                        readerPosition += lookAhead;
                        LexedTokens.add(new Token(68, "COMMENT", temp));
                        temp = "";
                        continue;
                    }
                    // Multi-line comments.
                    if (lookAheadOneChar(readerPosition, filePath) == '*') {
                        if (matchCaseExists2(readerPosition, '*','/', filePath)) {
                            int lookAhead = matchCaseDistance2(readerPosition, '*', '/', filePath);
                            temp = character + appendChars(lookAhead, temp, reader, readerPosition);
                            readerPosition += lookAhead;
                            LexedTokens.add(new Token(68, "COMMENT", temp));
                            temp = "";
                            continue;
                        }
                    }
                }

                // EDGE CASES: Operators.
                if (isOperator(character)) {
                    // Since operators are delimiters, temp (if it exists) must be an ID.
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    // Go through all possible operators in TokenTypes.
                    for (Token token : TokenTypes) {
                        if (token.value.charAt(0) == character) {
                            if (character == '<' || character == '>') {
                                if (lookAheadOneChar(readerPosition, filePath) == '=') {
                                    reader.read();
                                    readerPosition++;
                                    if (character == '<') LexedTokens.add(new Token(62, "LESS_EQUAL_operator", "<="));
                                    if (character == '>') LexedTokens.add(new Token(63, "GREATER_EQUAL_operator", ">="));
                                }
                                else LexedTokens.add(new Token(token.category, token.categoryName, String.valueOf(character)));
                                break;
                            }
                            LexedTokens.add(new Token(token.category, token.categoryName, String.valueOf(character)));
                            break;
                        }
                    }
                    continue;
                }

                temp = temp + character;
                boolean match = false;

                // EDGE CASE: Keywords
                for (int i = 0; i < KeywordCandidates.size(); i++) {

                    // Loop through every potential candidate.
                    if (temp.equals(KeywordCandidates.get(i).value)) {
                        match = true;

                        // EDGE CASE: Keyword contains an operator.
                        if (temp.equals("not") || temp.equals("Not")) {
                            if (lookAheadOneChar(readerPosition, filePath) == '=') {
                                LexedTokens.add(new Token(46, "NOTEQUALS_Keyword", temp + (char) reader.read()));
                                readerPosition++;
                                temp = "";
                                repopulate(KeywordCandidates, TokenTypes);
                                break;
                            } else if (!Character.isLetterOrDigit(lookAheadOneChar(readerPosition, filePath)) &&
                                        lookAheadOneChar(readerPosition, filePath) != '_'){
                                LexedTokens.add(new Token(45, "NOT_Keyword", temp));
                                temp = "";
                                repopulate(KeywordCandidates, TokenTypes);
                                break;
                            }
                        }

                        // If this is triggered, it is not a keyword anymore, it's an identifier.
                        // This also handles the "return" vs "returns" edge case.
                        char lookAhead = lookAheadOneChar(readerPosition, filePath);
                        if (!Character.isLetterOrDigit(lookAhead) && lookAhead != '_') {
                            Token token = new Token(KeywordCandidates.get(i).category, KeywordCandidates.get(i).categoryName, KeywordCandidates.get(i).value);
                            LexedTokens.add(token);
                            temp = "";
                        }
                        repopulate(KeywordCandidates, TokenTypes);
                        break;
                    }
                }

                // If no match, filter out any non-candidates.
                if (!match) {
                    String temp_ = temp;
                    KeywordCandidates.removeIf(cand -> !cand.value.startsWith(temp_));
                }

                // EDGE CASE: Identifiers, Integers, Decimals, or Errors
                if (KeywordCandidates.isEmpty()) {

                    // If beginning ASCII is 0-9, it must be an integer or decimal.
                    if (isDigit(temp.charAt(0))) {

                        // Now, keep reading for all integers until you reach a non-integer.
                        BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                        tempReader.skip(readerPosition);
                        int lookAhead = 0;
                        boolean isDecimal = false;

                        // Loop through every character in the input file.
                        while (true) {
                            int tempAscii = tempReader.read();
                            char tempCharacter = (char) tempAscii;
                            if       (tempCharacter == '.' && !isDecimal)  isDecimal = true;
                            else if  (tempCharacter == '.' && isDecimal)   break;
                            else if  (!isDigit(tempCharacter))             break;
                            lookAhead++;
                        }

                        // Determine if it is an integer or decimal.
                        temp = appendChars(lookAhead, temp, reader, readerPosition);
                        readerPosition += lookAhead;
                        if       (!isDecimal) LexedTokens.add(new Token(64, "INTEGER", temp));
                        else if  (isDecimal)  LexedTokens.add(new Token(65, "DECIMAL", temp));

                    }

                    // If beginning ASCII is A-Z or a-z, it must be an identifier.
                    else if (isLetter(temp.charAt(0))) {

                        // Now, scan the last character to see if its a valid symbol.
                        BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                        tempReader.skip(readerPosition);
                        int lookAhead = 0;

                        // If identifier, next characters must be a-z, A-Z, 0-9, or an underscore.
                        while (true) {
                            int tempAscii = tempReader.read();
                            char tempCharacter = (char) tempAscii;
                            if  (!((isLetter(tempCharacter))
                                 || (isDigit(tempCharacter))
                                 || (tempCharacter == '_'))) break;
                            lookAhead++;
                        }

                        // Classify as an identifier.
                        temp = appendChars(lookAhead, temp, reader, readerPosition);
                        readerPosition += lookAhead;
                        LexedTokens.add(new Token(66, "Identifier", temp));
                    }

                    // If no matches above, the token must be an error.
                    else LexedTokens.add(new Token(temp, true));

                    // Reset candidates and temp String.
                    repopulate(KeywordCandidates, TokenTypes);
                    temp = "";
                }
            }

            // Print out all stored tokens.
            for (Token lexedToken : LexedTokens) lexedToken.printToken();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found.");
        } catch (Exception e) {
            System.out.println("ERROR: Something went wrong.");
        }
    }

    public static final ArrayList<Token> TokenTypes = new ArrayList<>(List.of(
            new Token(1, "OUTPUT_Keyword", "output"),
            new Token(2, "ON_Keyword", "on"),
            new Token(3, "CREATE_Keyword", "create"),
            new Token(4, "CONSTANT_Keyword", "constant"),
            new Token(5, "ELSEIF_Keyword", "elseif"),
            new Token(6, "ME_Keyword", "me"),
            new Token(7, "UNTIL_Keyword", "until"),
            new Token(8, "PUBLIC_Keyword", "public"),
            new Token(9, "PRIVATE_Keyword", "private"),
            new Token(10, "ALERT_Keyword", "alert"),
            new Token(11, "DETECT_Keyword", "detect"),
            new Token(12, "ALWAYS_Keyword", "always"),
            new Token(13, "CHECK_Keyword", "check"),
            new Token(14, "PARENT_Keyword", "parent"),
            new Token(15, "BLUEPRINT_Keyword", "blueprint"),
            new Token(16, "SYSTEM_Keyword", "system"),
            new Token(17, "INHERITS_Keyword", "is"),
            new Token(18, "CAST_Keyword", "cast"),
            new Token(19, "INPUT_Keyword", "input"),
            new Token(20, "SAY_Keyword", "say"),
            new Token(21, "NOW_Keyword", "now"),
            new Token(22, "WHILE_Keyword", "while"),
            new Token(23, "PACKAGE_Keyword", "package"),
            new Token(24, "TIMES_Keyword", "times"),
            new Token(25, "REPEAT_Keyword", "repeat"),
            new Token(26, "ELSE_Keyword", "else"),
            new Token(27, "RETURNS_Keyword", "returns"),
            new Token(28, "RETURN_Keyword", "return"),
            new Token(29, "AND_Keyword", "and"),
            new Token(30, "OR_Keyword", "or"),
            new Token(31, "UNDEFINED_Keyword", "undefined"),
            new Token(32, "SHARED_Keyword", "shared"),
            new Token(33, "ACTION_Keyword", "action"),
            new Token(34, "INTEGER_Keyword", "integer"),
            new Token(35, "NUMBER_Keyword", "number"),
            new Token(36, "TEXT_Keyword", "text"),
            new Token(37, "BOOLEAN_Keyword", "boolean"),
            new Token(38, "USE_Keyword", "use"),
            new Token(39, "MODULO_Keyword", "mod"),
            new Token(40, "IF_Keyword", "if"),
            new Token(41, "END_Keyword", "end"),
            new Token(42, "CLASS_Keyword", "class"),
            new Token(43, "TRUE_Keyword", "true"),
            new Token(44, "FALSE_Keyword", "false"),
            new Token(45, "NOT_Keyword", "not"),
            new Token(45, "NOT_Keyword", "Not"),
            new Token(46, "NOTEQUALS_Keyword", "not="),
            new Token(46, "NOTEQUALS_Keyword", "Not="),
            new Token(47, "COLON_operator", ":"),
            new Token(48, "PERIOD_operator", "."),
            new Token(49, "COMMA_operator", ","),
            new Token(50, "EQUALITY_operator", "="),
            new Token(51, "GREATER_operator", ">"),
            new Token(52, "LESS_operator", "<"),
            new Token(53, "PLUS_operator", "+"),
            new Token(54, "MINUS_operator", "-"),
            new Token(55, "MULTIPLY_operator", "*"),
            new Token(56, "DIVIDE_operator", "/"),
            new Token(57, "LEFT_SQR_BRACE_operator", "["),
            new Token(58, "RIGHT_SQR_BRACE_operator", "]"),
            new Token(59, "LEFT_PAREN_operator", "("),
            new Token(60, "RIGHT_PAREN_operator", ")"),
            new Token(61, "DOUBLE_QUOTE_operator", "\""),
            new Token(62, "LESS_EQUAL_operator", "<="),
            new Token(63, "GREATER_EQUAL_operator", ">="),
            new Token(64, "INT", ""),
            new Token(65, "DECIMAL", ""),
            new Token(66, "IDENTIFIER", ""),
            new Token(67, "STRING", ""),
            new Token(68, "COMMENT", "")
    ));
}





