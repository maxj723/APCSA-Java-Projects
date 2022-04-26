class Snowflake {
  
  private int points;
  private int numOfType;

  public Snowflake(int points) {
    this.points = points;
    this.numOfType = 1;
  }

  public int getPoints() {
    return points;
  }
  
  public int getNum() {
    return numOfType;
  }
  
  public void addFlake() {
    numOfType++;
  }

  public void removeFlake() {
    numOfType--;
  }
}
