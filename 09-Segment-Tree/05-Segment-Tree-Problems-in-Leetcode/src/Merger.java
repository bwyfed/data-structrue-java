// 融合器。由a和b融合成新的元素
public interface Merger<E> {
    E merge(E a, E b);
}
