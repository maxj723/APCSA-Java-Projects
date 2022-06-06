package quiz;

public class Main {

	public static void main(String[] args) {
		Game quiz = new Game("Quiz");
		if(quiz.current > 7) {
			quiz.setVisible(false);
		}
	}
	
	

}
