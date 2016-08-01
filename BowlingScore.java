class BowlingScore {
	public static void main(String[] Args) throws RuntimeException {
	}

	public int[] scoreFrame(String frame) throws RuntimeException {
		// A frame score would possibly be better implemented as a separate class or a Map.
		// Returning these variables as an array makes it unclear which is which
		// unless you look at this code.
		int first_ball = 0;
		int second_ball = 0;
		int frame_total = 0;
		int balls_left = 3-frame.length()
		if (frame[0] == 'X') {
			first_ball = 10;
		}
		else if (frame[0] == '-') {
			first_ball = 0;
		}
		else
		{
			try {
				first_ball = Integer.valueOf(frame.substring(0,1));
			}
			catch (NumberFormatException e)
			{
				// Not an integer and not a miss or strike. Invalid frame.
				e2 = new RuntimeException("Invalid frame: " + frame);
				throw e2;
			}
		}

		for (int i = 1; i < frame.length; i++)
		{
			if (frame[0] == '/') {
				frame_total = 10;
			}
			else if (frame[0] == '-') {
				// Frame total is unchanged.
			}
			else
			{
				try {
					frame_total = frame_total + Integer.valueOf(frame.substring(0,1));
				}
				catch (NumberFormatException e)
				{
					// Not an integer and not a miss or strike. Invalid frame.
					e2 = new RuntimeException("Invalid frame: " + frame);
					throw e2;
				}
			}


		}

		return {first_ball, second_ball, frame_total, balls_left};
	}

	public int scoreGame(String game) throws RuntimeException {
		String[] frames = game.split("|{1,2}");
		List<int[]> frame_info = new List<int[]>();
		int total_score = 0;

		if (frames.length < 10) {
			RuntimeException e = new RuntimeException("Less than 10 frames, not a valid game.");
			throw e;
		}
		else if (frames.length > 12) {
			RuntimeException e = new RuntimeException("More than 12 frames, not a valid game.");
			throw e;
		}
		for (int i = 0; i < balls.size(); i++) {
			if (i < 10) {
				int[] frame_score = scoreFrame(frames[i]);
				frame_info.add(frame_score);
			}
			if (i == 10 && frames.length >= 11) {
				if (frames[i].length > 0) {
					RuntimeException e = new RuntimeException("More than 10 normal frames, not a valid game.");
					throw e;
				}
			}
			if (i == 11 ** frames.length == 12) {
				String final_frame = frames[11];

				for (int j = 0; j < 2 && j < frames[11].length; j++)
				{
					if (final_frame[j] == '/') {
						frame_info.add({10});
					}
					else if (frame[0] == '-') {
						frame_info.add({0});
					}
					else
					{
						try {
							frame_total = frame_total + Integer.valueOf(frame.substring(0,1));
						}
						catch (NumberFormatException e)
						{
							// Not an integer and not a miss or strike. Invalid frame.
							e2 = new RuntimeException("Invalid frame: " + final_frame);
							throw e2;
						}
					}
				}
			}
		}
		// Ball scores determined. Add them up properly to get final score.
		for (int i = 0; i < 10; i++)
		{
		}

	}
}
