import java.io.IOException;
import java.util.Scanner;

class secondProgram {
  public static void main(String[] args) throws IOException {

    // Ask for how many files
    Scanner sc = new Scanner(System.in);
    System.out.println("How many files are you going to add");
    int numFiles = sc.nextInt();

    TextAdministrator fromatter = new TextAdministrator(); // Create object TextAdministrator

    // Sets the files and folder where is being executed
    String fileName = fromatter.getFileNames(numFiles);
    fromatter.setFile(fileName);

    FileClass[] fileClasses = new FileClass[fromatter.numFilesFixed]; // Create object FilesClass
    fileClasses = fromatter.hasTheSameName(); // Gets an array of FileClass with data organized

    MagicCalculations LDC = new MagicCalculations(); // Create object MagicCalculations
    for (int i = 0; i < fileClasses.length; i++) {// Passing values
      for (int j = 0; j < fileClasses[i].getClassNamesLength(); j++) {
        LDC.setFileName(fileClasses[i].getClassNames(j));
      }
      LDC.set(fileClasses[i].getClassName());
      LDC = new MagicCalculations(); // Reset values object MagicCalculations
    }
    sc.close();
  }
}