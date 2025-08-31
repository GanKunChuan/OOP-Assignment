package assignment;

public class Voucher {
    private String code;
    private String title;
    private int pointRequired;
    private double discountAmount;
    private boolean used;

    public Voucher(String code, String title, int pointRequired, double discountAmount) {
        this.code = code;
        this.title = title;
        this.pointRequired = pointRequired;
        this.discountAmount = discountAmount;
        this.used = false;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getPointRequired() {
        return pointRequired;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public boolean isUsed() {
        return used;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPointRequired(int pointRequired) {
        this.pointRequired = pointRequired;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

}

