import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;
import java.util.LinkedHashSet;

public class TextAdministrator extends FileClass {
  int numFiles, numFilesFixed;
  File tempFile, tempFolder;
  Scanner tempReaderFiles;
  String[] pathnames, userfileNames, pathnamesfixed;

  public TextAdministrator() throws FileNotFoundException {
    this.tempReaderFiles = new Scanner(System.in);
  }

  public String getTheFolderPath() { // Returns fixed folder path
    String path = this.tempFile.getAbsolutePath();
    String newPath = path.replace(this.tempFile.getName(), "");
    return newPath.substring(0, newPath.length() - 1);
  }

  public void fixedFileName() {
    this.pathnamesfixed = new String[this.numFiles];
    for (int i = 0; i < this.numFiles; i++) {
      int iend = this.userfileNames[i].indexOf(".");
      if (iend != -1) {
        this.pathnamesfixed[i] = this.userfileNames[i].substring(0, iend);
      }
    }
    LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(this.pathnamesfixed));
    this.pathnamesfixed = linkedHashSet.toArray(new String[] {});
  }

  public FileClass[] hasTheSameName() {// return the file where it does make match
    this.numFilesFixed = this.pathnamesfixed.length;
    FileClass[] fileClasses = new FileClass[numFilesFixed];
    for (int i = 0; i < this.numFilesFixed; i++) {
      fileClasses[i] = new FileClass();
      for (int j = 0; j < this.userfileNames.length; j++) {
        if (this.userfileNames[j].contains(this.pathnamesfixed[i])) {
          fileClasses[i].setclassNames(this.userfileNames[j]);
        }
      }
      fileClasses[i].setClassName(this.pathnamesfixed[i]);
    }
    return fileClasses;
  }

  public String getFileNames(int numFiles) { // Fills an array with the userfileNames, and retruns the first
                                             // string
    this.numFiles = numFiles;
    this.userfileNames = new String[numFiles];
    for (int i = 0; i < numFiles; i++) {
      this.userfileNames[i] = tempReaderFiles.nextLine();
      File tempFile_ = new File(userfileNames[i]);
      if (!tempFile_.exists()) {
        System.out.println("File with the name " + userfileNames[i] + " does not exists");
        System.exit(1);
      }
    }
    this.tempReaderFiles.close();
    return userfileNames[0];
  }

  public void setFile(String fileName) {// Sets the name of the file to get all the files in the directory
    this.tempFile = new File(fileName);
    this.tempFolder = new File(getTheFolderPath());
    this.pathnames = this.tempFolder.list();
    fixedFileName();
  }
}
