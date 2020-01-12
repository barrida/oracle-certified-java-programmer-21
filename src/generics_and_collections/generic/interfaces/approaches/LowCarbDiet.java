package generics_and_collections.generic.interfaces.approaches;

import generics_and_collections.generic.interfaces.diets.LowCarbHighProtein;

/**
 * Approach 1: Specify the generic type in the class.
 */
class LowCarbDiet implements Diet<LowCarbHighProtein> {

    @Override
    public void printDietList(LowCarbHighProtein t) {
        t.getLowCarbHighProtein();
    }
}
