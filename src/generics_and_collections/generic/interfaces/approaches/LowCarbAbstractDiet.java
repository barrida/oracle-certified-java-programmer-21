package generics_and_collections.generic.interfaces.approaches;

/**
 * Approach 2: Create a generic class. The following concrete class allows the caller to specify the type of the generic
 */
class LowCarbAbstractDiet<U> implements Diet<U> {

    @Override
    public void printDietList(U u) {

    }
}
