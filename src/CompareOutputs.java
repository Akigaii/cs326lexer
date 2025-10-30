import java.io.*;

public class CompareOutputs {
    public static void main(String[] args) {
        String file1 = "Output.txt";
        String file2 = "BaseOutput.txt";

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2))) {

            String line1, line2;
            int lineNumber = 1;
            boolean identical = true;

            while (true) {
                line1 = br1.readLine();
                line2 = br2.readLine();

                // if both lines are null, we've reached the end of both files
                if (line1 == null && line2 == null) {
                    break;
                }

                // if one line is null (different lengths) or lines differ
                if (line1 == null || line2 == null || !line1.equals(line2)) {
                    identical = false;
                    System.out.println("Mismatch at line " + lineNumber + ":");
                    System.out.println("Output.txt: " + (line1 != null ? line1 : "EOF"));
                    System.out.println("BaseOutput.txt: " + (line2 != null ? line2 : "EOF"));
                    break;
                }

                lineNumber++;
            }

            if (identical) {
                System.out.println("Files are identical!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("One of the files was not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An I/O error occurred while reading the files.");
            e.printStackTrace();
        }
    }
}