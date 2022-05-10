class Main {
  public static void main(String[] args) {
    Moves moves = new Moves("dive.txt");
    moves.getNewDepth();
    moves.getNewHorz();
    System.out.println(moves.getProduct());
  }
}
