import java.util.*;

class BowlingScore {
	public static void main(String[] Args) throws RuntimeException {
		String game_string = "X|7/|9-|X|-8|8/|-6|X|X|X||81";
		if (Args.length >= 1)
		{
			// Turns out java doesn't have the first argument as the program name like C++ or something.
			System.out.println("Game passed: " + Args[0]);
			game_string = Args[0];
		}
		int game_score = scoreGame(game_string);
		System.out.format("Total score: %d\n", game_score);
	}

	public static int scoreGame(String game) throws RuntimeException {
		String[] frames = game.split("\\|{1,2}");
		List<Integer> balls = new ArrayList<Integer>();
		List<Integer> frame_scores = new ArrayList<Integer>();
		List<Integer> frame_balls = new ArrayList<Integer>();

		for (String i : frames) {
			System.out.println(i);
		}

		int total_score = 0;
		int current_ball = 0;

		if (frames.length < 10) {
			RuntimeException e = new RuntimeException("Not enough frames.");
			throw e;
		}
		for (String i : frames) {
			String[] frame = i.split("(?!^)");
			for (String ball : frame) {
				if (ball.equals("X")) {
					balls.add(10);
				}
				else if (ball.equals("-")) {
					balls.add(0);
				}
				else if (current_ball > 0 && ball.equals("/")) {
					balls.add(10 - balls.get(balls.size()-1));
				}
				else {
					try {
						balls.add(Integer.valueOf(ball));
					}
					catch (NumberFormatException e) {
						RuntimeException e2 = new RuntimeException("Invalid ball: " + ball);
						throw e2;
					}
				}
				current_ball++;
			}
		}
		current_ball = 0;
		for (int current_frame = 0; current_frame < frames.length; current_frame++) {
			frame_balls.add(frames[current_frame].length());
			int frame_score = 0;
			for (int frame_ball = 0; frame_ball < frames[current_frame].length(); frame_ball++, current_ball++) {
				frame_score += balls.get(current_ball);
			}
			frame_scores.add(frame_score);
		}
		current_ball = 0;
		for (int current_frame = 0; current_frame < 10; current_frame++) {
			int score_added = 0;
			score_added += frame_scores.get(current_frame);
			current_ball += frame_balls.get(current_frame);
			if (frame_scores.get(current_frame) == 10) {
				for (int i = 0; i < (3 - frames[current_frame].length()) && i+current_ball < balls.size(); i++) {
					score_added += balls.get(current_ball+i);
				}
			}
			total_score += score_added;
		}
		return total_score;
	}
}
