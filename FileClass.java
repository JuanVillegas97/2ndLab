import java.util.Vector;

public class FileClass {
 private String className;
 private Vector<String> classNames;

 public FileClass() {
  this.className = "";
  this.classNames = new Vector<>();
 }

 public String getClassName() {
  return className;
 }

 public void setClassName(String className) {
  this.className = className;
 }

 public int getClassNamesLength() {
  return classNames.size();
 }

 public void setclassNames(String classNames) {
  this.classNames.add(classNames);
 }

 public String getClassNames(int index) {
  return classNames.get(index);
 }
}
