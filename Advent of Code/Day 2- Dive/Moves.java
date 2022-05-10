import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;



class Moves {
  
  private ArrayList<Movement> directionList;
  private int depth;
  private int horz;

  public Moves(String fileName) {
    this.directionList = importFile(fileName);
    this.depth = 0;
    this.horz = 0;
  }

  public void setList(String fileName) {
    directionList = importFile(fileName);
  }

  public void getNewDepth() {
    for (Movement move : directionList) {
      if (move.getDirection().charAt(0) == 'd') {
        depth += move.getDistance();
      } else if (move.getDirection().charAt(0) == 'u') {
        depth -= move.getDistance();
      }
    }
  }

  public void getNewHorz() {
    for (Movement move : directionList) {
      if (move.getDirection().charAt(0) == 'f') {
        horz += move.getDistance();
      }
    }
  }

  public int getProduct() {
    return horz * depth;
  }








  
 public static ArrayList<Movement> importFile(String fileName){
    ArrayList<Movement> words = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        Movement objData = new Movement(data);
        words.add(objData);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    //String[] wordArray = toArray(words);
    return words;
  }

  public static String[] toArray(ArrayList<String> s){
    String[] words = new String[s.size()];
    for(int i = 0; i < words.length; i++){
      words[i] = s.get(i);
    }
    return words;
  }
}// end class