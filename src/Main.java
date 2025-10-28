import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

class Token{
    int category;
    String categoryName;
    String value;
    boolean error;

    public Token(int category, String categoryName, String value){
        this.category = category;
        this.categoryName = categoryName;
        this.value = value;
        this.error = false;
    }

    public Token(String value, boolean error){
        this.category = -1;
        this.categoryName = "ERROR";
        this.value = value;
        this.error = true;
    }

    public void printToken() {
        if (error) System.out.println("ERROR: " + this.value + " is not a token.");
        else System.out.println("Token Category: " + category + ", Category Name: " + categoryName + ", Value: " + value);
    }
}



public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Token> TokenTypes = new ArrayList<>();
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
        TokenTypes.add(new Token(17, "IS_Keyword", "is"));
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


        ArrayList<Token> LexedTokens = new ArrayList<>();
        String filePath = "/Users/xmastersteel/IdeaProjects/Lexer/src/test.txt";

        try{

            int readerPosition = 0; // Tracks which character the reader is on in the input file.
            String temp = "";       // Temporary string to contain char buffers.
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            ArrayList<Token> Candidates = new ArrayList<>(TokenTypes);  // All possible matches.

            while(true){ // Loop through every character in the input file.
                // Read the character as an ASCII
                int ascii = reader.read();
                char character = (char) ascii;
                readerPosition++;

                // EDGE CASE: If ASCII is an EOF, stop reading input file.
                if (ascii == -1) break;

                // EDGE CASE: If ASCII is a ' ' or a '\n', disregard.
                if (character == ' ' || character == '\n') {
//                    Candidates.clear(); // If a space is encountered, then it cannot be a keyword.
                    System.out.println("Char: " +  " [" + character + " ]");
                    System.out.println("Space encountered, clearing the candidates.");
                    System.out.println("temp " + temp);

                    if (!temp.isEmpty()) {
                        Token token = new Token(66, "Identifier", temp);
                        LexedTokens.add(token);
                    }

                    temp = "";
                    continue;
                }

                // EDGE CASES: Single-char operators.
                if (character == ':') {
                    LexedTokens.add(new Token(47, "COLON_operator", ":"));
                    continue;
                } else if (character == '.') {
                    LexedTokens.add(new Token(48, "PERIOD_operator", "."));
                    continue;
                } else if (character == ',') {
                    LexedTokens.add(new Token(49, "COMMA_operator", ","));
                    continue;
                } else if (character == '=') {
                    LexedTokens.add(new Token(50, "EQUALITY_operator", "="));
                    continue;
                } else if (character == '>') {
                    // EDGE CASE: Two-char operator
                    BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                    tempReader.skip(readerPosition); // Lookahead.
                    if (tempReader.read() == '='){
                        reader.read();
                        readerPosition++;
                        LexedTokens.add(new Token(63, "GREATER_EQUAL_operator", ">="));
                        continue;
                    }
                    LexedTokens.add(new Token(51, "GREATER_operator", ">"));
                    continue;
                } else if (character == '<') {
                    // EDGE CASE: Two-char operator
                    BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                    tempReader.skip(readerPosition); // Lookahead.
                    if (tempReader.read() == '='){
                        reader.read();
                        readerPosition++;
                        LexedTokens.add(new Token(62, "LESS_EQUAL_operator", "<="));
                        continue;
                    }
                    LexedTokens.add(new Token(52, "LESS_operator", "<"));
                    continue;
                } else if (character == '+') {
                    LexedTokens.add(new Token(53, "PLUS_operator", "+"));
                    continue;
                } else if (character == '-') {
                    LexedTokens.add(new Token(54, "MINUS_operator", "-"));
                    continue;
                } else if (character == '*') {
                    LexedTokens.add(new Token(55, "MULTIPLY_operator", "*"));
                    continue;
                } else if (character == '/') {
                    LexedTokens.add(new Token(56, "DIVIDE_operator", "/"));
                    continue;
                } else if (character == '[') {
                    LexedTokens.add(new Token(57, "LEFT_SQR_BRACE_operator", "["));
                    continue;
                } else if (character == ']') {
                    LexedTokens.add(new Token(58, "RIGHT_SQR_BRACE_operator", "]"));
                    continue;
                } else if (character == '(') {
                    LexedTokens.add(new Token(59, "LEFT_PAREN_operator", "("));
                    continue;
                } else if (character == ')') {
                    LexedTokens.add(new Token(60, "RIGHT_PAREN_operator", ")"));
                    continue;
                } else if (character == '"') {
                    LexedTokens.add(new Token(61, "DOUBLE_QUOTE_operator", "\""));
                    continue;
                }

                temp = temp + character;
                System.out.println("-  Temp: " + temp);
                boolean match = false;

                // EDGE CASE: Keywords
                for (int i = 0; i < Candidates.size(); i++) {
                    // Loop through every potential candidate.
//
                    if (temp.equals(Candidates.get(i).value)) { // Exact match!
//
                        match = true;
                        System.out.println("Candidate found: " + Candidates.get(i).value);

                        // Create new token, and add it to found tokens.
                        Token token = new Token(Candidates.get(i).category, Candidates.get(i).categoryName, Candidates.get(i).value);
                        LexedTokens.add(token);
                        temp = "";

                        // Repopulate the Candidates ArrayList.
                        Candidates.clear();
                        Candidates.addAll(TokenTypes);
//                        keyword = true;
                        break;
                    }

                }

                if (!match){ // No match is found.
                    // Clear any candidate that doesn't match.
                    String temp_ = temp;
                    Candidates.removeIf(cand -> !cand.value.startsWith(temp_));
                }

                // EDGE CASE: Identifiers, Integers, Decimals, or Errors
                if(Candidates.isEmpty()){
                    System.out.println("NO CANDIDATES FOUND!");


                    // If beginning ASCII is 0-9, it must be an integer.
                    if (temp.charAt(0) >= 48 && temp.charAt(0) <= 57) {
                        System.out.println("Must be an integer");

                        // Now, keep reading for all integers until you reach a non-integer.
                        BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                        tempReader.skip(readerPosition);
                        int lookAhead = 0;
                        boolean isDecimal = false;

                        while(true) { // Loop through every character in the input file.
                            // Read the character as an ASCII
                            int tempAscii = tempReader.read();
                            if (tempAscii == 46 && !isDecimal) {
                                // If a '.' is ever read in FOR THE FIRST TIME, it must be a decimal.
                                isDecimal = true;
                            }
                            else if (tempAscii == 46 && isDecimal){
                                // If a '.' is read in for the SECOND TIME, it's invalid.
                                System.out.println("Period appeared twice");
                                break;
                            }
                            else if (!(tempAscii >= 48 && tempAscii <= 57)) break;
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
                        }
                        else if (isDecimal){

                            for (int i = 0; i < lookAhead; i++) {
                                int tempAscii = reader.read();
                                char tempCharacter = (char) tempAscii;
                                readerPosition++;
                                temp = temp + tempCharacter;
                                System.out.println("Temp: " + temp);
                            }

                            Token token = new Token(65, "DECIMAL", temp);
                            LexedTokens.add(token);

                        }




                    }

                    // If beginning ASCII is A-Z or a-z, it must be an identifier.
                    else if ((temp.charAt(0) >= 65 && temp.charAt(0) <= 90) || (temp.charAt(0) >= 97 && temp.charAt(0) <= 122)){
                        System.out.println("Must be an identifier");

                        // Now, scan the last character to see if its a valid symbol.
                        BufferedReader tempReader = new BufferedReader(new FileReader(filePath));
                        tempReader.skip(readerPosition);
                        int lookAhead = 0;

                        while(true) { // Loop through every character in the input file.
                            // Read the character as an ASCII
                            int tempAscii = tempReader.read();
//                            System.out.println("tempAscii: " + tempAscii);
//                            if (tempAscii == 32 || tempAscii == 10) {break;}
                            if (!((tempAscii >= 65 && tempAscii <= 90) || (tempAscii >= 97 && tempAscii <= 122) || (tempAscii >= 48 && tempAscii <= 57))) break;
                            lookAhead++;
                        }

//                        System.out.println("lookAhead: " + lookAhead);

                        for (int i = 0; i < lookAhead; i++) {
                            int tempAscii = reader.read();
                            char tempCharacter = (char) tempAscii;
                            readerPosition++;
                            temp = temp + tempCharacter;
                        }

                        Token token = new Token(66, "Identifier", temp);
                        LexedTokens.add(token);
                    }
                    // If no matches above, the token must be an error.
                    else{
                        System.out.println("Must be an error");

                        Token token = new Token(temp, true);
                        LexedTokens.add(token);
                    }

                    // Reset candidates and temp String.
                    Candidates.clear();
                    System.out.println("Refreshing the candidates.");
                    Candidates.addAll(TokenTypes);
                    temp = "";
                }

            }







            System.out.println("\n =====   ALL TOKENS   ===== ");
            for (int i = 0; i < LexedTokens.size(); i++) {
                LexedTokens.get(i).printToken();
            }






        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found.");
        } catch (Exception e){
            System.out.println("ERROR: Something went wrong.");

        }


    }
}


