import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

class Token {
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
        else
            System.out.println("Token Category: " + category + ", Category Name: " + categoryName + ", Value: " + value);
    }

    public String getToken() {
        if (error) return "ERROR: " + this.value + " is invalid.";
        else
            return "Token Category: " + category + ", Category Name: " + categoryName + ", Value: " + value;
    }

}


public class Main {

    public static void main(String[] args) throws Exception{
        String directoryPath = "/Users/xmastersteel/IdeaProjects/Lexer/InputFiles";
        File dir = new File(directoryPath);
        File[] directoryListing = dir.listFiles();
        for (File child : directoryListing) {
            System.out.println("\n =====   ALL TOKENS FOR " + "\"" + child.getName() + "\""+  "   =====");
            lexer(directoryPath + '/' + child.getName());
        }
    }

    public static void lexer(String filePath){
        ArrayList<Token> TokenTypes = new ArrayList<>();
        if (true) {
            TokenTypes.add(new Token(1, "OUTPUT_Keyword", "output"));
            TokenTypes.add(new Token(2, "ON_Keyword", "on"));
            TokenTypes.add(new Token(3, "CREATE_Keyword", "create"));
            TokenTypes.add(new Token(4, "CONSTANT_Keyword", "constant"));
            TokenTypes.add(new Token(5, "ELSEIF_Keyword", "elseif"));
            TokenTypes.add(new Token(6, "ME_Keyword", "me"));
            TokenTypes.add(new Token(7, "UNTIL_Keyword", "until"));
            TokenTypes.add(new Token(8, "PUBLIC_Keyword", "public"));
            TokenTypes.add(new Token(9, "PRIVATE_Keyword", "private"));
            TokenTypes.add(new Token(10, "ALERT_Keyword", "alert"));
            TokenTypes.add(new Token(11, "DETECT_Keyword", "detect"));
            TokenTypes.add(new Token(12, "ALWAYS_Keyword", "always"));
            TokenTypes.add(new Token(13, "CHECK_Keyword", "check"));
            TokenTypes.add(new Token(14, "PARENT_Keyword", "parent"));
            TokenTypes.add(new Token(15, "BLUEPRINT_Keyword", "blueprint"));
            TokenTypes.add(new Token(16, "SYSTEM_Keyword", "system"));
            TokenTypes.add(new Token(17, "INHERITS_Keyword", "is"));
            TokenTypes.add(new Token(18, "CAST_Keyword", "cast"));
            TokenTypes.add(new Token(19, "INPUT_Keyword", "input"));
            TokenTypes.add(new Token(20, "SAY_Keyword", "say"));
            TokenTypes.add(new Token(21, "NOW_Keyword", "now"));
            TokenTypes.add(new Token(22, "WHILE_Keyword", "while"));
            TokenTypes.add(new Token(23, "PACKAGE_Keyword", "package"));
            TokenTypes.add(new Token(24, "TIMES_Keyword", "times"));
            TokenTypes.add(new Token(25, "REPEAT_Keyword", "repeat"));
            TokenTypes.add(new Token(26, "ELSE_Keyword", "else"));
            TokenTypes.add(new Token(27, "RETURNS_Keyword", "returns"));
            TokenTypes.add(new Token(28, "RETURN_Keyword", "return"));
            TokenTypes.add(new Token(29, "AND_Keyword", "and"));
            TokenTypes.add(new Token(30, "OR_Keyword", "or"));
            TokenTypes.add(new Token(31, "UNDEFINED_Keyword", "undefined"));
            TokenTypes.add(new Token(32, "SHARED_Keyword", "shared"));
            TokenTypes.add(new Token(33, "ACTION_Keyword", "action"));
            TokenTypes.add(new Token(34, "INTEGER_Keyword", "integer"));
            TokenTypes.add(new Token(35, "NUMBER_Keyword", "number"));
            TokenTypes.add(new Token(36, "TEXT_Keyword", "text"));
            TokenTypes.add(new Token(37, "BOOLEAN_Keyword", "boolean"));
            TokenTypes.add(new Token(38, "USE_Keyword", "use"));
            TokenTypes.add(new Token(39, "MODULO_Keyword", "mod"));
            TokenTypes.add(new Token(40, "IF_Keyword", "if"));
            TokenTypes.add(new Token(41, "END_Keyword", "end"));
            TokenTypes.add(new Token(42, "CLASS_Keyword", "class"));
            TokenTypes.add(new Token(43, "TRUE_Keyword", "true"));
            TokenTypes.add(new Token(44, "FALSE_Keyword", "false"));

            TokenTypes.add(new Token(45, "NOT_Keyword", "not"));
            TokenTypes.add(new Token(45, "NOT_Keyword", "Not"));
            TokenTypes.add(new Token(46, "NOTEQUALS_Keyword", "not="));
            TokenTypes.add(new Token(46, "NOTEQUALS_Keyword", "Not="));

            TokenTypes.add(new Token(47, "COLON_operator", ":"));
            TokenTypes.add(new Token(48, "PERIOD_operator", "."));
            TokenTypes.add(new Token(49, "COMMA_operator", ","));
            TokenTypes.add(new Token(50, "EQUALITY_operator", "="));
            TokenTypes.add(new Token(51, "GREATER_operator", ">"));
            TokenTypes.add(new Token(52, "LESS_operator", "<"));
            TokenTypes.add(new Token(53, "PLUS_operator", "+"));
            TokenTypes.add(new Token(54, "MINUS_operator", "-"));
            TokenTypes.add(new Token(55, "MULTIPLY_operator", "*"));
            TokenTypes.add(new Token(56, "DIVIDE_operator", "/"));
            TokenTypes.add(new Token(57, "LEFT_SQR_BRACE_operator", "["));
            TokenTypes.add(new Token(58, "RIGHT_SQR_BRACE_operator", "]"));
            TokenTypes.add(new Token(59, "LEFT_PAREN_operator", "("));
            TokenTypes.add(new Token(60, "RIGHT_PAREN_operator", ")"));
            TokenTypes.add(new Token(61, "DOUBLE_QUOTE_operator", "\""));

            TokenTypes.add(new Token(62, "LESS_EQUAL_operator", "<="));
            TokenTypes.add(new Token(63, "GREATER_EQUAL_operator", ">="));

            TokenTypes.add(new Token(64, "INT", ""));
            TokenTypes.add(new Token(65, "DECIMAL", ""));
            TokenTypes.add(new Token(66, "IDENTIFIER", ""));
            TokenTypes.add(new Token(67, "STRING", ""));
            TokenTypes.add(new Token(68, "COMMENT", ""));

        }

        ArrayList<Token> LexedTokens = new ArrayList<>();
//        String filePath = "/Users/xmastersteel/IdeaProjects/Lexer/src/Garbage.txt";

        try {
            int readerPosition = 0; // Tracks which character the reader is on in the input file.
            String temp = "";       // Temporary string to contain char buffers.
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            ArrayList<Token> Candidates = new ArrayList<>(TokenTypes);  // All possible matches.

            while (true) { // Loop through every character in the input file.
                // Read the character as an ASCII
                int ascii = reader.read();
                char character = (char) ascii;
                readerPosition++;

                // EDGE CASE: If ASCII is an EOF, stop reading input file.
                if (ascii == -1){
                    if (!temp.isEmpty()) {
                        Token token = new Token(66, "Identifier", temp);
                        LexedTokens.add(token);
                    }
                    break;
                }


                // EDGE CASE: If ASCII is a ' ' or a '\n', disregard.
                if (character == ' ' || character == '\n') {

//                    System.out.println("space or newline ecnountered w/ temp = " + temp);
                    if (!temp.isEmpty()) {
                        Token token = new Token(66, "Identifier", temp);
                        LexedTokens.add(token);
                        Candidates.clear();
                        Candidates.addAll(TokenTypes);
                    }

                    temp = "";
                    continue;
                }

                // EDGE CASE: Strings
                if (character == '"') {
                    BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                    tempReader.skip(readerPosition);
                    boolean doubleQuoteExists = false;
                    int lookAhead = 0;
                    while (true) {
                        int tempAscii = tempReader.read();
                        char tempCharacter = (char) tempAscii;
                        if (tempAscii == -1) break;
                        if (tempCharacter == '"') {
                            doubleQuoteExists = true;
                            break;
                        }
                        ;
                        lookAhead++;
                    }

                    if (doubleQuoteExists) {
                        for (int i = 0; i < lookAhead + 1; i++) {
                            ascii = reader.read();
                            readerPosition++;
                            character = (char) ascii;
                            temp = temp + character;
                        }
                        temp = '"' + temp;
                        LexedTokens.add(new Token(67, "STRING", temp));
                        temp = "";
                        continue;
                    }
                }


                // EDGE CASE: Single line comments
                if (character == '/') {
//                    System.out.println("/ IS HIT!!!!: " + " [" + character + " ]");
                    boolean isComment = false;
                    BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                    tempReader.skip(readerPosition);
                    int lookAhead = 0;
                    if (tempReader.read() == '/') {
                        isComment = true;
                        while (true) {
                            int tempAscii = tempReader.read();
                            char tempCharacter = (char) tempAscii;
                            if (tempAscii == -1 || tempCharacter == '\n') break;
                            lookAhead++;
                        }
                    }
                    if (isComment) {
                        for (int i = 0; i < lookAhead + 1; i++) {
                            ascii = reader.read();
                            readerPosition++;
                            character = (char) ascii;
                            temp = temp + character;
                        }
                        temp = '/' + temp;
                        LexedTokens.add(new Token(68, "COMMENT", temp));
                        temp = "";
                        continue;
                    }
                }

                // EDGE CASE: Multi line comments
                if (character == '/') {
                    boolean isComment = false;
                    BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                    tempReader.skip(readerPosition);
                    int tempAscii3 = tempReader.read();
                    char tempCharacter3 = (char) tempAscii3;
                    int lookAhead = 0;
                    if (tempCharacter3 == '*') {
                        String potentialComment = "";
                        BufferedReader slow = new BufferedReader(new FileReader(filePath));
                        slow.skip(readerPosition);
                        while (true) {
                            int slowAscii = slow.read();
                            char slowCharacter = (char) slowAscii;
                            int tempAscii = tempReader.read();
                            char tempCharacter = (char) tempAscii;
                            if (tempAscii == -1) break;
                            if (slowCharacter == '*' && tempCharacter == '/' && lookAhead != 0) {
//                                System.out.println("isComment = true");
//                                System.out.println("slowCharacter = " + slowCharacter + " tempCharacter = " + tempCharacter + " tempCharacter3 = " + tempCharacter3 + " character = " + character );
                                isComment = true;
                                break;
                            }
                            potentialComment = potentialComment + tempCharacter;
//                            System.out.println("potentialComment: " + potentialComment);
                            lookAhead++;
                        }
                    }
                    if (isComment) {
                        for (int i = 0; i < lookAhead + 2; i++) {
                            ascii = reader.read();
                            readerPosition++;
                            character = (char) ascii;
                            temp = temp + character;
                        }
                        temp = '/' + temp;
                        LexedTokens.add(new Token(68, "COMMENT", temp));
                        temp = "";
                        continue;
                    }
                }


                // EDGE CASES: Single-char operators.
                if (character == ':') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(47, "COLON_operator", ":"));
                    continue;
                } else if (character == '.') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(48, "PERIOD_operator", "."));
                    continue;
                } else if (character == ',') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(49, "COMMA_operator", ","));
                    continue;
                } else if (character == '=') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(50, "EQUALITY_operator", "="));
                    continue;
                } else if (character == '>') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    // EDGE CASE: Two-char operator
                    BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                    tempReader.skip(readerPosition); // Lookahead.
                    if (tempReader.read() == '=') {
                        reader.read();
                        readerPosition++;
                        LexedTokens.add(new Token(63, "GREATER_EQUAL_operator", ">="));
                        continue;
                    }
                    LexedTokens.add(new Token(51, "GREATER_operator", ">"));
                    continue;
                } else if (character == '<') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    // EDGE CASE: Two-char operator
                    BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                    tempReader.skip(readerPosition); // Lookahead.
                    if (tempReader.read() == '=') {
                        reader.read();
                        readerPosition++;
                        LexedTokens.add(new Token(62, "LESS_EQUAL_operator", "<="));
                        continue;
                    }
                    LexedTokens.add(new Token(52, "LESS_operator", "<"));
                    continue;
                } else if (character == '+') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(53, "PLUS_operator", "+"));
                    continue;
                } else if (character == '-') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(54, "MINUS_operator", "-"));
                    continue;
                } else if (character == '*') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(55, "MULTIPLY_operator", "*"));
                    continue;
                } else if (character == '/') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(56, "DIVIDE_operator", "/"));
                    continue;
                } else if (character == '[') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(57, "LEFT_SQR_BRACE_operator", "["));
                    continue;
                } else if (character == ']') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(58, "RIGHT_SQR_BRACE_operator", "]"));
                    continue;
                } else if (character == '(') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(59, "LEFT_PAREN_operator", "("));
                    continue;
                } else if (character == ')') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(60, "RIGHT_PAREN_operator", ")"));
                    continue;
                } else if (character == '"') {
                    if (!temp.isEmpty()) {
                        LexedTokens.add(new Token(66, "Identifier", temp));
                        temp = "";
                    }
                    LexedTokens.add(new Token(61, "DOUBLE_QUOTE_operator", "\""));
                    continue;
                }

                temp = temp + character;
                boolean match = false;

                // EDGE CASE: Keywords
                for (int i = 0; i < Candidates.size(); i++) {
                    // Loop through every potential candidate.
//
                    if (temp.equals(Candidates.get(i).value)) { // Exact match!
//
                        match = true;

                        if (temp.equals("not") || temp.equals("Not")) {
                            BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                            tempReader.skip(readerPosition); // Lookahead.
                            int tempAscii = tempReader.read();
                            char tempCharacter = (char) tempAscii;
                            if (tempCharacter == '=') {
                                int x = reader.read();
                                temp = temp + (char) x;
                                readerPosition++;
                                LexedTokens.add(new Token(46, "NOTEQUALS_operator", temp));
                                temp = "";
                                Candidates.clear();
                                Candidates.addAll(TokenTypes);
                                break;
                            } else if (!Character.isLetterOrDigit(tempCharacter)){
                                LexedTokens.add(new Token(45, "NOT_operator", temp));
                                temp = "";
                                Candidates.clear();
                                Candidates.addAll(TokenTypes);
                                break;
                            }
                            else{ // It's an identifier
                                BufferedReader tempReader2 = new BufferedReader(new FileReader(filePath));
                                tempReader2.skip(readerPosition); // Lookahead.
                                int lookAhead = 0;
                                while (true){
                                    int tempAscii2 = tempReader2.read();
                                    char tempCharacter2 = (char) tempAscii2;
                                    if (!Character.isLetterOrDigit(tempCharacter2)) break;
                                    lookAhead++;
                                }
                                for (int j = 0; i < lookAhead + 1; i++){
                                    int x = reader.read();
                                    char y =  (char) x;
                                    temp = temp + y;
                                    readerPosition++;
                                }
                                Token token = new Token(66, "Identifier", temp);
                                temp = "";
                                LexedTokens.add(token);
                                Candidates.clear();
                                Candidates.addAll(TokenTypes);
                                break;
                            }
                        }

                        // Lookahead one token to finally confirm its a keyword.
                        BufferedReader tempReader2 = new BufferedReader(new FileReader(filePath));
                        tempReader2.skip(readerPosition);
                        int tempAscii2 = tempReader2.read();
                        char tempCharacter2 = (char) tempAscii2;

                        // If this is triggered, it is not a keyword anymore, it's an identifier.
                        if (!Character.isLetterOrDigit(tempCharacter2)) {
                            Token token = new Token(Candidates.get(i).category, Candidates.get(i).categoryName, Candidates.get(i).value);
                            LexedTokens.add(token);
                            temp = "";
                            Candidates.clear();
                            Candidates.addAll(TokenTypes);
                            break;
                        } else {
                            Candidates.clear();
                            Candidates.addAll(TokenTypes);
                            break;
                        }

                    }

                }

                if (!match) { // No match is found.
                    // Clear any candidate that doesn't match.
                    String temp_ = temp;
                    Candidates.removeIf(cand -> !cand.value.startsWith(temp_));
                }

                // EDGE CASE: Identifiers, Integers, Decimals, or Errors
                if (Candidates.isEmpty()) {

                    // If beginning ASCII is 0-9, it must be an integer.
                    if (temp.charAt(0) >= 48 && temp.charAt(0) <= 57) {

                        // Now, keep reading for all integers until you reach a non-integer.
                        BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                        tempReader.skip(readerPosition);
                        int lookAhead = 0;
                        boolean isDecimal = false;

                        while (true) { // Loop through every character in the input file.
                            // Read the character as an ASCII
                            int tempAscii = tempReader.read();
                            if (tempAscii == 46 && !isDecimal) {
                                // If a '.' is ever read in FOR THE FIRST TIME, it must be a decimal.
                                isDecimal = true;
                            } else if (tempAscii == 46 && isDecimal) {
                                // If a '.' is read in for the SECOND TIME, it's invalid.
                                break;
                            } else if (!(tempAscii >= 48 && tempAscii <= 57)) break;
                            lookAhead++;
                        }

                        if (!isDecimal) {
                            for (int i = 0; i < lookAhead; i++) {
                                int tempAscii = reader.read();
                                char tempCharacter = (char) tempAscii;
                                readerPosition++;
                                temp = temp + tempCharacter;
//                                System.out.println("Temp: " + temp);
                            }
                            Token token = new Token(64, "INTEGER", temp);
                            LexedTokens.add(token);
                        } else if (isDecimal) {

                            for (int i = 0; i < lookAhead; i++) {
                                int tempAscii = reader.read();
                                char tempCharacter = (char) tempAscii;
                                readerPosition++;
                                temp = temp + tempCharacter;
                            }

                            Token token = new Token(65, "DECIMAL", temp);
                            LexedTokens.add(token);

                        }


                    }

                    // If beginning ASCII is A-Z or a-z, it must be an identifier.
                    else if ((temp.charAt(0) >= 65 && temp.charAt(0) <= 90) || (temp.charAt(0) >= 97 && temp.charAt(0) <= 122)) {

                        // Now, scan the last character to see if its a valid symbol.
                        BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                        tempReader.skip(readerPosition);
                        int lookAhead = 0;

                        while (true) { // Loop through every character in the input file.
                            // Read the character as an ASCII
                            int tempAscii = tempReader.read();
//                            System.out.println("tempAscii: " + tempAscii);
//                            if (tempAscii == 32 || tempAscii == 10) {break;}
                            if (!((tempAscii >= 65 && tempAscii <= 90) || (tempAscii >= 97 && tempAscii <= 122) || (tempAscii >= 48 && tempAscii <= 57) || tempAscii == 95))
                                break;
                            lookAhead++;
                        }

                        for (int i = 0; i < lookAhead; i++) {
                            int tempAscii = reader.read();
                            char tempCharacter = (char) tempAscii;
                            readerPosition++;
                            temp = temp + tempCharacter;
                        }

                        if (temp.equals("returns")) {
                            Token token = new Token(27, "RETURNS_keyword", temp);
                            LexedTokens.add(token);
                        } else if (temp.equals("not=")) {
                            Token token = new Token(46, "NOTEQUALS_keyword", temp);
                            LexedTokens.add(token);
                        } else {
                            Token token = new Token(66, "Identifier", temp);
                            LexedTokens.add(token);
                        }

                    }
                    // If no matches above, the token must be an error.
                    else {
                        Token token = new Token(temp, true);
                        LexedTokens.add(token);
                    }

                    // Reset candidates and temp String.
                    Candidates.clear();
//                    System.out.println("Refreshing the candidates.");
                    Candidates.addAll(TokenTypes);
                    temp = "";
                }

            }


            for (int i = 0; i < LexedTokens.size(); i++) {
                LexedTokens.get(i).printToken();
            }

//            String fileName = "TEST_return_not=output.txt";
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//                for (int i = 0; i < LexedTokens.size(); i++) {
//                    writer.write(LexedTokens.get(i).getToken());
//                    writer.newLine();
//                }
//                System.out.println("Content successfully written to " + fileName);
//            } catch (IOException e) {
//                System.err.println("An error occurred while writing to the file: " + e.getMessage());
//            }





        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found.");
        } catch (Exception e) {
            System.out.println("ERROR: Something went wrong.");
        }



    }
}


