public class Rocketship {

	public static void main(String[] args) {
		rocket(3);
	}

	
	public static void rocket(int width) {
		// comibining all pieces to make the rocketship
		cone(width);
		divider(width);
		body(width);
		body2(width);
		divider(width);
		body2(width);
		body(width);
		divider(width);
		cone(width);
	}
	
	public static void cone(int width) {
		// uses ct to calculate how many lines to make it
		for (int ct = width * 2 - 1; ct > 0; ct--) {
			System.out.print(" ");
			int spacect = 0;
			// spacect is how many spaces are printed. used to calculate the number of slashes
			for (int space = 0; space < ct - 1; space++) {
				System.out.print(" ");
				spacect++;
			}
			for (int slash = 1; slash <= width * 2 - 1 - spacect; slash++) {
				System.out.print("/");
			}
			System.out.print("**");
			for (int slash = 1; slash <= width * 2 - 1 - spacect; slash++) {
				System.out.print("\\");
			}
			System.out.println();
		}
	}
	
	public static void divider(int width) {
		System.out.print("+");
		// this runs it four times to make it long enough
		for (int ct = 1; ct <= 4; ct++) {
			// prints the divider long enough according to width
			for (int print = 1; print <= width; print++) {
				// to make sure the * and = alternate
				if (width % 2 == 0) {
					if (print % 2 != 0) {
						System.out.print("=");
					} else {
						System.out.print("*");
					}
				} else {
					if (ct % 2 == 0) {
						if (print % 2 == 0) {
							System.out.print("=");
						} else {
							System.out.print("*");
						}
					} else {
						if (print % 2 != 0) {
							System.out.print("=");
						} else {
							System.out.print("*");
						}
					}
				}
			}
		}
		System.out.println("+");
	}

	public static void body(int width) {
		// width is the width to print
		for (int line = width - 1; line >= 0; line--) {
			System.out.print("|");
			// ct loop to print twice
			for (int ct = 1; ct <= 2; ct++) {
				// line is how many lines there will be
				int dotct = 0;
				for (int dot = line; dot > 0; dot--) {
					System.out.print(".");
					dotct++;
					// dot is how many dots will be printed
				}
				for (int slash = width - line; slash > 0; slash--) {
					// slash is how many slashes will be printed
					if (width % 2 == 0) {
						if ((slash - dotct) % 2 == 0) {
							// if statement is to determine the correct slash direction
							System.out.print("/");
						} else {
							System.out.print("\\");
						}
					} else {
						if ((slash - line) % 2 == 0) {
							// if statement is to determine the correct slash direction
							System.out.print("\\");
						} else {
							System.out.print("/");
						}
					}
				}
				for (int slash = width - line; slash > 0; slash--) {
					if (slash % 2 == 0) {
						System.out.print("/");
					} else {
						System.out.print("\\");
					}
				}
				for (int dot = line; dot > 0; dot--) {
					System.out.print(".");
				}
			}
			System.out.print("|");
			System.out.println();
		}
	}

	public static void body2(int width) {
		for (int line = width - 1; line >= 0; line--) {
			System.out.print("|");
			for (int ct = 1; ct <= 2; ct++) {
				for (int dot = width - line - 1; dot > 0; dot--) {
					System.out.print(".");
				}
				for (int slash = line + 1; slash > 0; slash--) {
					if ((slash - line) % 2 == 0) {
						System.out.print("/");
					} else {
						System.out.print("\\");
					}
				}
				for (int slash = line + 1; slash > 0; slash--) {
					if ((slash) % 2 == 0) {
						System.out.print("\\");
					} else {
						System.out.print("/");
					}
				}
				for (int dot = width - line - 1; dot > 0; dot--) {
					System.out.print(".");
				}
			}
			System.out.print("|");
			System.out.println();
		}

	}

}
