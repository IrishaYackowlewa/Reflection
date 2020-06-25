public class SaltedBiscuit extends Cookie implements Biscuit{
    private double weightCookie;

    private static final String ROUNDCOOKIE = "ROUNDCOOKIE";
    public static final String SQUARECOOKIE = "SQUARECOOKIE";
    public static final String TRIANGULARCOOKIE = "TRIANGULARCOOKIE88";

    public SaltedBiscuit() {
    }

    public SaltedBiscuit(double weightCookie) {
        this.weightCookie = weightCookie;
    }

    public double getWeightCookie() {
        return weightCookie;
    }

    @Override
    public int countCookies(double weightPack) {
        return (int) (weightPack/this.weightCookie);
    }

    @Override
    public double weightCookies(int quantity) {
        return quantity*weightCookie;
    }

    private int cookies (){
        return 0;
    }
}
