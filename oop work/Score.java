public class Score {
    private int startingScore;
    private int currentScore;
    private int roomsVisited;
    private final int ROOM_SCORE = 10; 

    public Score(int startingScore) {
        this.startingScore = startingScore;
        this.currentScore = startingScore;
        this.roomsVisited = 0;
    }

    public void visitRoom() {
        roomsVisited++;
        currentScore += ROOM_SCORE; 
    }

    public boolean canDestroyNuclearButton() {
        return currentScore >= 100; 
    }

    public double getScore() {
        return currentScore;
    }
}
