import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.File; // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class MagicCalculations extends TextAdministrator {
  int t, i, b, d, m, a;
  String filename;

  public MagicCalculations() throws FileNotFoundException {
    this.t = this.i = this.d = this.m = this.b = this.a = 0;
  }

  public void setFileName(String filename) throws FileNotFoundException {
    this.tempFile = new File(filename);
    this.tempReaderFiles = new Scanner(this.tempFile);
    doRead();
  }

  public void set(String fileclass) {
    this.filename = fileclass;
  }

  public void doRead() {
    int no = 0;
    boolean comment = false;
    while (tempReaderFiles.hasNextLine()) {
      String data = tempReaderFiles.nextLine();
      data = data.trim();
      if (data.startsWith("//") || "".equals(data) || "{".equals(data) || "}".equals(data) || "};".equals(data)) {
        no++;
      }
      if (comment) {
        no++;
      }
      if (data.endsWith("*/")) {
        no--;
      }
      if (data.startsWith("/*")) {
        comment = true;
        no++;
      }
      if (data.endsWith("*/")) {
        comment = false;
        no++;
      }

      if (data.contains("//.i")) {
        i++;
      }
      if (data.contains("//.m")) {
        m++;
      }
      if (data.contains("//.b=")) {
        data = data.replaceAll("[\\D]", "");
        int number = Integer.parseInt(data);
        b += number;
      }
      if (data.contains("//.d=")) {
        data = data.replaceAll("[\\D]", "");
        int number = Integer.parseInt(data);
        d += number;
      }
      t++;
    }
    t = t - no;
    a = t - b + d;
    // Sorting
  }

  public void sorting() {

  }

  public void printInfo() {
  }
}
