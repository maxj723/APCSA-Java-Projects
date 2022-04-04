
import java.util.Scanner;


class HawaiianWords {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    enterWord(input);
    
  }
  
  public static String makeWord(String s){
    if (isValid(s)) {
      return s.toUpperCase() + " is pronounced " + pronun(s.toLowerCase());
    } else {
      return invalidLetter(s) + " is not a valid hawaiian character";
    }
  }

  public static boolean isValid(String str) {
    String s = str.toLowerCase();
    for (int i = 0; i < s.length(); i++) {
      if (!(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'h' || s.charAt(i) == 'k' || s.charAt(i) == 'l' || s.charAt(i) == 'm' || s.charAt(i) == 'n' || s.charAt(i) == 'p' || s.charAt(i) == 'w' || s.charAt(i) == '\'' || s.charAt(i) == ' ')) {
        return false;
      }
    }
    return true;
  }

  public static String invalidLetter(String str) {
    String s = str.toLowerCase();
    String letter = "";
    for (int i = 0; i < str.length(); i++) {
      if (!(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'h' || s.charAt(i) == 'k' || s.charAt(i) == 'l' || s.charAt(i) == 'm' || s.charAt(i) == 'n' || s.charAt(i) == 'p' || s.charAt(i) == 'w' || s.charAt(i) == '\'' || s.charAt(i) == ' ')) {
        letter = s.substring(i,i+1);
        return letter.toUpperCase();
      }
    }
    return letter.toUpperCase();
  }

  public static boolean isVowel(String str) {
    if (!(str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u')) {
      return false;
    }
    return true;
  }

  public static String pronun(String str) {
    final String[][] vowels = {{"a","ah"}, {"e", "eh"}, {"i", "ee"}, {"o", "oh"}, {"u", "oo"}};
    final String[][] twoVowels = {{"ai", "eye"}, {"ae", "eye"}, {"ao", "ow"}, {"au", "ow"}, {"ei", "ay"}, {"eu", "eh-oo"}, {"iu", "ew"}, {"oi", "oy"}, {"ou", "ow"}, {"ui", "ooey"}};
    String word = "";
    boolean isTwo = false;
    for (int i = 0; i < str.length(); i++) {
      if (isVowel(str.substring(i,i+1))) {
        if (i != str.length()-1) {
          if (isVowel(str.substring(i,i+1)) && isVowel(str.substring(i+1,i+2))) {
            boolean match = false;
            for (int j = 0; j < twoVowels.length; j++) {
              if (str.substring(i,i+2).equals(twoVowels[j][0])) {
                if (i == str.length()-2) {
                  word += twoVowels[j][1];
                  match = true;
                  isTwo = true;
                } else if (!str.substring(i+2, i+3).equals(" ") && !str.substring(i+2, i+3).equals("'")) {
                  word += twoVowels[j][1] + "-";
                  match = true;
                  isTwo = true;
                } else {
                  word += twoVowels[j][1];
                  match = true;
                  isTwo = true;
                }
              } 
            }
            if (!match) {
              for (int k = 0; k < vowels.length; k++) {
                if (str.substring(i,i+1).equals(vowels[k][0])) {
                  if (i == str.length()-1) {
                    word += vowels[k][1];
                    isTwo = false;
                  } else if (!str.substring(i+1, i+2).equals(" ") && !str.substring(i+1, i+2).equals("'")) {
                    word += vowels[k][1] + "-";
                    isTwo = false;
                  } else {
                    word += vowels[k][1];
                    isTwo = false;
                  }
                } 
              }
            }
        
            

            
          } else {
            for (int j = 0; j < vowels.length; j++) {
              if (str.substring(i,i+1).equals(vowels[j][0])) {
                if (i == str.length()-1) {
                  word += vowels[j][1];
                  isTwo = false;
                } else if (!str.substring(i+1, i+2).equals(" ") && !str.substring(i+1, i+2).equals("'")) {
                  word += vowels[j][1] + "-";
                  isTwo = false;
                } else {
                  word += vowels[j][1];
                  isTwo = false;
                }
              } 
            }
          }
        } else {
          if (!isTwo) {
            for (int j = 0; j < vowels.length; j++) {
              if (str.substring(i,i+1).equals(vowels[j][0])) {
                if (i == str.length()-1) {
                  word += vowels[j][1];
                } else if (!str.substring(i+1, i+2).equals(" ") && !str.substring(i+1, i+2).equals("'")) {
                  word += vowels[j][1] + "-";
                } else {
                  word += vowels[j][1];
                }
              } 
            }
          }
        }
        
        
          
          
      } else {
        if (str.substring(i,i+1).equals("w") && i != 0 && (str.substring(i-1,i).equals("a") || str.substring(i-1,i).equals("e") || str.substring(i-1,i).equals("i"))) {
          word += "v";
        } else {
          word += str.substring(i,i+1);
        }
      }
    }
    
    return word.substring(0,1).toUpperCase() + word.substring(1);
  }

  public static void enterWord(Scanner input) {
    System.out.print("Enter a hawaiian word to pronounce ==> ");
    String word = input.nextLine();
    System.out.println(makeWord(word));
    anotherWord(input);
  }

  public static void anotherWord(Scanner input) {
    System.out.print("Do you want to enter another word? Y/YES/N/NO ==> ");
    String word = input.nextLine();
    if (word.equals("Y") || word.equals("YES")) {
      enterWord(input);
    } else if (!word.equals("N") && !word.equals("NO")) {
      System.out.println("Enter Y, YES, N or NO");
      anotherWord(input);
    }
  }
  
}
