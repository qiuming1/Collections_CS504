import java.util.*;
import java.io.*;

public class StudentCourse {

  public static void main(String[] args) throws IOException {

     File f = new File("student.txt");
     Scanner scan = new Scanner(f);

     TreeMap<String, ArrayList<String>> tm = new TreeMap<String, ArrayList<String>>();

     while (scan.hasNextLine()) {
       String s = scan.nextLine();

       String[] s_arr = s.split("\t");
       String nm = s_arr[0];
       String course = s_arr[1];

       // System.out.println("name=" + nm + "  course=" + course);

       if (tm.containsKey(nm)) {
         // contains key
         ArrayList<String> al = tm.get(nm);
         al.add(course);
         Collections.sort(al);
         tm.put(nm,al);

       } else {
         // does not contain key
         ArrayList<String> al = new ArrayList<String>();
         al.add(course);
         Collections.sort(al);
         tm.put(nm,al);
       }
     }

     for (Map.Entry<String,ArrayList<String>> entry : tm.entrySet()) {
       String key = entry.getKey();
       ArrayList<String> al = entry.getValue();
       System.out.println("Name=" + key);
       for (String s: al)
         System.out.print("    " + s);
       System.out.println("");
     }

     System.out.println("The number of students is " + tm.size());

     TreeMap<String,Integer> tmCourse = new TreeMap<String,Integer>();

     for (Map.Entry<String,ArrayList<String>> entry : tm.entrySet()) {
       String key = entry.getKey();
       ArrayList<String> al = entry.getValue();
       for (String courseName: al) {
         if (tmCourse.containsKey(courseName)) {
           Integer iObj = tmCourse.get(courseName);
           int i =iObj.intValue() + 1;
           tmCourse.put(courseName, new Integer(i));        

         } else {
           tmCourse.put(courseName, new Integer(1));
         }         
       }
     }
     
     System.out.println("The number of courses is: " + tmCourse.size());
     
     for (Map.Entry<String,Integer> entry : tmCourse.entrySet()) {
       String key = entry.getKey();
       Integer iObj = entry.getValue();
       System.out.println("Course=" + key + "  number of student:" + iObj.intValue());
     }
  }
}
