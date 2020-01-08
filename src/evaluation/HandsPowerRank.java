package evaluation;

public enum HandsPowerRank {
    HIGHCARD(1),
    PAIR(2),
    DOUBLEPAIR(3),
    DRILL(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL(7),
    POKER(8),
    STRAIGHTFLUSH(9),
    ROYALFLUSH(10);
    
    private int rank;
    
    private HandsPowerRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
    
}
