import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;



class Main {
  public static void main(String[] args) {
    String[] lines = importFile("dive.txt");
    System.out.println(lines.length);
    // think about how you might separate each of the lines
    // https://www.youtube.com/watch?v=sBApUWZ80GQ
    String bun = "100";
    int n = Integer.parseInt(bun);
    System.out.println(n);
    int depth = 0;
    int horz = 0;
    int aim = 0;
    for (String word : lines) {
      int num = Integer.parseInt(word.substring(word.length()-1));
      if (word.charAt(0) == 'd') {
        aim += num;
      } else if (word.charAt(0) == 'u') {
        aim -= num;
      } else {
        horz += num;
        depth += num * aim;
      }
    }

    System.out.println(horz*depth);
  }















  
// don't touch below this line...
 public static String[] importFile(String fileName){
    ArrayList<String> words = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        words.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    String[] wordArray = toArray(words);
    return wordArray;
  }

  public static String[] toArray(ArrayList<String> s){
    String[] words = new String[s.size()];
    for(int i = 0; i < words.length; i++){
      words[i] = s.get(i);
    }
    return words;
  }
}// end class