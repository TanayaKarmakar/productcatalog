package common;

import java.util.Objects;

/**
 * @author t0k02w6 on 07/03/22
 * @project ds-algo-2021
 */
public class Pair1<S, T> {
    public S first;
    public T second;

    public Pair1(S first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair1<?, ?> pair1 = (Pair1<?, ?>) o;
        return Objects.equals(first, pair1.first) && Objects.equals(second, pair1.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
