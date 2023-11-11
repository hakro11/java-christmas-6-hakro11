package christmas.domain;

import christmas.constants.Badges;

public class Badge {
    private final String NONE = Badges.BADGES_NONE.getBADGE_NAME();
    private final String STAR = Badges.BADGES_STAR.getBADGE_NAME();
    private final String TREE = Badges.BADGES_TREE.getBADGE_NAME();
    private final String SANTA = Badges.BADGES_SANTA.getBADGE_NAME();
    private final int TOTAL_DISCOUNT_PRICE;
    private final String BADGE;

    public Badge(int totalDiscountPrice) {
        this.TOTAL_DISCOUNT_PRICE = totalDiscountPrice;
        this.BADGE = judgement();
    }

    public String getBADGE() {
        return BADGE;
    }

    private String judgement() {
        if (TOTAL_DISCOUNT_PRICE >= Badges.BADGES_STAR.getBADGE_PRICE() &&
                TOTAL_DISCOUNT_PRICE < Badges.BADGES_TREE.getBADGE_PRICE()) {
            return STAR;
        }

        if (TOTAL_DISCOUNT_PRICE >= Badges.BADGES_TREE.getBADGE_PRICE() &&
                TOTAL_DISCOUNT_PRICE < Badges.BADGES_SANTA.getBADGE_PRICE()) {
            return TREE;
        }

        if (TOTAL_DISCOUNT_PRICE >= Badges.BADGES_SANTA.getBADGE_PRICE()){
            return SANTA;
        }

        return NONE;
    }
}
