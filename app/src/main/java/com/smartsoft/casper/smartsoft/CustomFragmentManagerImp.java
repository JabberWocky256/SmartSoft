package com.smartsoft.casper.smartsoft;

import android.app.Fragment;

/**
 *CustomFragmentManager is tool designed to extend android.app.FragmentManager
 */
public interface CustomFragmentManagerImp {

    /**
     * popBackStack(int count) - pops from back stack 'count' times
     * @param count
     */
    void popBackStack(int count);

    /**
     * popBackStackOverlapping - pops from back stack 'n' times
     * where 'n' number of same fragment in stack queue which come one after other
     */
    void popBackStackOverlapping();

    /**
     * popBackStackSoftly - pops from back stack but not removes fragment, only detaches it
     * on transaction add() or replace() it will be attached without recreating,
     * if garbage collector remove fragment it will be recreated
     */
    void popBackStackSoftly();

    /**
     * popBackStackTo(Class frClass) - pops from back stack when visible fragment class will be @frClass
     * if there are no needed instance of @frClass, back stack will be cleared and create new instance of @frClass
     * @param frClass
     */
    void popBackStackTo(Class frClass);

    /**
     * go(Fragment fr) - smart transaction which take last view id and make transaction replace() on it
     * also add this fragment to backStack
     * @param fr
     */
    void go(Fragment fr);
}
