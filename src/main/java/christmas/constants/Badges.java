package christmas.constants;

public enum Badges {
    BADGES_NONE("없음", 0),
    BADGES_STAR("별", 5000),
    BADGES_TREE("트리", 10000),
    BADGES_SANTA("산타", 20000);

    final String BADGE_NAME;
    final int BADGE_PRICE;

    Badges(String BADGE_NAME, int BADGE_PRICE) {
        this.BADGE_NAME = BADGE_NAME;
        this.BADGE_PRICE = BADGE_PRICE;
    }

    public String getBADGE_NAME() {
        return BADGE_NAME;
    }

    public int getBADGE_PRICE() {
        return BADGE_PRICE;
    }
}
