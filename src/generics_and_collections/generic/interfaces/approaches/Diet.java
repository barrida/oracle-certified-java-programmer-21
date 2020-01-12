package generics_and_collections.generic.interfaces.approaches;

/**
 * @author Suleyman Yildirim
 * <p>
 * There are three ways a class can approach implementing Diet interface
 */
public interface Diet<T> {
    void printDietList(T t);
}