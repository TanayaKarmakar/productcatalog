package common;

/**
 * @author t0k02w6 on 25/03/22
 * @project ds-algo-2021
 */
public class Triplet<S, T, U> {
    private S first;
    private T second;
    private U third;

    public Triplet(S first, T second, U third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public S getFirst() {
        return first;
    }

    public void setFirst(S first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public U getThird() {
        return third;
    }

    public void setThird(U third) {
        this.third = third;
    }
}
