import java.util.ArrayList;
//shout out to ariel and sophia for making the tests :) srry if they are wrong :/
class Main {
  public static void main(String[] args) {
    
    int[] a = {3,3,3,2,5};
    int[] b = {2,1,5,7};
    int[] c = {3,4,6,6};
    int[] d = {1,2,3};
    int[] e = {5,3,9,8};
    int[] f = {1};
    
    printArray(sym(a,b,c,d,e,f));
    
  }
    
  public static int[] sym(int[] a, int[] b){
    ArrayList<Integer> nums = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      boolean equals = false;
      for (int j = 0; j < b.length; j++) {
        if (a[i] == b[j]) {
          equals = true;
          break;
        }
      }
      if (!equals) {
        nums = add(nums, a[i]);
      }
    }
    for (int i = 0; i < b.length; i++) {
      boolean equals = false;
      for (int j = 0; j < a.length; j++) {
        if (b[i] == a[j]) {
          equals = true;
          break;
        }
      }
      if (!equals) {
        nums = add(nums, b[i]);
      }
    }
    int[] tempArray = convertToArray(nums);
    return tempArray;
  }

  public static int[] sym(int[] a, int[] b, int[] c) {
    return sym(sym(a,b), c);
  }

  public static int[] sym(int[] a, int[] b, int[] c, int[] d) {
    return sym(sym(a,b,c), d);
  }

  public static int[] sym(int[] a, int[] b, int[] c, int[] d, int[] e) {
    return sym(sym(a,b,c,d), e);
  }

  public static int[] sym(int[] a, int[] b, int[] c, int[] d, int[] e, int[] f) {
    return sym(sym(a,b,c,d,e), f);
  }
  
  
  public static ArrayList<Integer> add(ArrayList<Integer> nums, int n) {
    if (!nums.contains(n)) {
      if (nums.size() == 0) {
        nums.add(n);
        return nums;
      }
      boolean added = false;
      for (int i = 0; i < nums.size(); i++) {
        if (n < nums.get(i)) {
          nums.add(i, n);
          added = true;
          break;
        }
      }
      if (!added) {
        nums.add(n);
      }
    }
    return nums;
  }

  public static int[] convertToArray(ArrayList<Integer> nums) {
    int[] arr = new int[nums.size()];
    for (int i = 0; i < nums.size(); i++) {
      arr[i] = nums.get(i);
    }
    return arr;
  }

  public static void printArray(int[] nums) {
    for (int num : nums) {
      System.out.print(num);
    }
    System.out.println();
  }
  
}
