import java.util.ArrayList;
import java.util.*;

class SnowStorm {

  private ArrayList<Snowflake> storm;

  public SnowStorm() {
    this.storm = new ArrayList<Snowflake>();
  }

  public void addFlake(int points) {
    boolean added = false;
    for (int i = 0; i < storm.size(); i++) {
      if (storm.get(i).getPoints() == points) {
        storm.get(i).addFlake();
        added = true;
      }
    }
    if (!added) {
      Snowflake newFlake = new Snowflake(points);
      storm.add(newFlake);
    }
  }

  public void removeFlake(int points) {
    for (int i = 0; i < storm.size(); i++) {
      if (storm.get(i).getPoints() == points && storm.get(i).getNum() > 1) {
        storm.get(i).removeFlake();
        break;
      } else if (storm.get(i).getPoints() == points && storm.get(i).getNum() == 1) {
        storm.remove(i);
        break;
      }
    }
  }

  public void reportQty() {
    Comparator<Snowflake> compareByPoints = new Comparator<Snowflake>() {
	    public int compare(Snowflake one, Snowflake two) {
        if (one.getPoints() > two.getPoints()) {
          return 1;
        } else if (one.getPoints() < two.getPoints()) {
          return -1;
        } else {
          return 0;
        }
	    }
    };
    Collections.sort(storm, compareByPoints);
    for (int i = 0; i < storm.size(); i++) {
      System.out.println(storm.get(i).getPoints() + "\t" + storm.get(i).getNum());
    }
  }
}
