class Movement {

  private String direction;
  private int distance;

  public Movement(String words) {
    this.direction = words.substring(0, words.indexOf(" "));
    this.distance = Integer.parseInt(words.substring(words.length()-1));
  }

  public String getDirection() {
    return direction;
  }

  public int getDistance() {
    return distance;
  }
}
