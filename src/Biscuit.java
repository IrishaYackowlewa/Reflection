public interface Biscuit {

    @Cache
    int countCookies(double weight);

    @Cache
    double weightCookies(int quantity);
}
