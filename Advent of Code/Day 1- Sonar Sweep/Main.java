import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

class Main {
  // https://adventofcode.com/2021/day/1
  // go read the question....

  
  public static void main(String[] args) {
    
    ArrayList<Integer> nums = importFile("sonar.txt");
    int[] sonarsweep = listToArray(nums);
    System.out.println(sonarsweep.length);
    // don't touch above here...
    // https://adventofcode.com/2021/day/1
    // once you get the test data to work, put your data in sonar.txt
    System.out.println(increaseByThree(sonarsweep));

    
  }

  public static int increaseByOne(int[] nums) {
    int ct = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i-1]) {
        ct++;
      }
    }
    return ct;
  }

  public static int increaseByThree(int[] nums) {
    int ct = 0;
    for (int i = 1; i < nums.length - 2; i++) {
      int threeTwo = nums[i] + nums[i+1] + nums[i+2];
      int threeOne = nums[i-1] + nums[i] + nums[i+1];
      if (threeTwo > threeOne) {
        ct++;
      }
    }
    return ct;
  }




  // ######################## don't touch below here....
  public static int[] listToArray(ArrayList<Integer> nums){
    int[] numArray = new int[nums.size()];
    for(int i = 0; i < numArray.length; i++){
      numArray[i] = nums.get(i);
    }
    return numArray;
  }



  
  public static ArrayList<Integer> importFile(String fileName) {
		ArrayList<Integer> nums = new ArrayList<>();
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				int data = myReader.nextInt();
				//int num = Integer.parseInt(data);
				nums.add(data);
				// add the data to an arraylist
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return nums;
	}

}