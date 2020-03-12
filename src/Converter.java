import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class Converter {

    public static void main(String[] args) {
        String output = "";

        try {
            File inputFile = new File("index.html");
            File outputFile = new File("output.txt");
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            Scanner scanner = new Scanner(inputFile);

            // Read line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                output += line + "\\n";
                outputStream.write(output.getBytes());
            }
            scanner.close();
            outputStream.close();
            System.out.println("String written to \"" + outputFile + "\"");

        } catch (IOException e) {
            System.out.println("Copy a file with the name index.html");
            e.printStackTrace();
        }

        // Copy the string to the clipboard
        StringSelection stringSelection = new StringSelection(output);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        System.out.println("String copied to Clipboard");
    }
}