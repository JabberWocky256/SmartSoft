package com.smartsoft.casper.smartsoft;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by alexander on 09.01.16.
 */
public class CustomFragmentManager implements CustomFragmentManagerImp{
    FragmentManager instance;

    public CustomFragmentManager(FragmentManager instance) {
        this.instance = instance;
    }

    @Override
    public void popBackStack(int count) {
        count = getMaxPossibleCount(count);
        while (count > 0) {
            instance.popBackStack();
            count--;
        }
    }

    private int getMaxPossibleCount(int count) {
        int maxCount = instance.getBackStackEntryCount();
        return count > maxCount ? maxCount : count;
    }

    @Override
    public void popBackStackOverlapping() {
        new ActivityInfo().dump(); {
            {

            }
        }

        /*int id = instance.getBackStackEntryAt(count - 1) {

        }();*/
        //Fragment fr = instance.findFragmentById(id);
        /*if (fr != null) {
            Log.d("TAGG", fr.getClass().toString());
        }*/
    }

    @Override
    public void popBackStackSoftly() {

    }

    @Override
    public void popBackStackTo(Class frClass) {

    }

    @Override
    public void go(Fragment fr) {

    }

    public FragmentTransaction beginTransaction() {
        return instance.beginTransaction();
    }

    public boolean executePendingTransactions() {
        return instance.executePendingTransactions();
    }

    public Fragment findFragmentById(int var1) {
        return instance.findFragmentById(var1);
    }

    public Fragment findFragmentByTag(String var1) {
        return findFragmentByTag(var1);
    }

    public void popBackStack() {
        instance.popBackStack();
    }

    public boolean popBackStackImmediate() {
        return instance.popBackStackImmediate();
    }

    public void popBackStack(String var1, int var2) {
        instance.popBackStack();
    }

    public boolean popBackStackImmediate(String var1, int var2) {
        return instance.popBackStackImmediate(var1, var2);
    }

    public void popBackStack(int var1, int var2) {
        instance.popBackStack();
    }

    public boolean popBackStackImmediate(int var1, int var2) {
        return instance.popBackStackImmediate();
    }

    public int getBackStackEntryCount() {
        return instance.getBackStackEntryCount();
    }

    public FragmentManager.BackStackEntry getBackStackEntryAt(int var1) {
        return instance.getBackStackEntryAt(var1);
    }

    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener var1) {
        instance.addOnBackStackChangedListener(var1);
    }

    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener var1) {
        instance.removeOnBackStackChangedListener(var1);
    }

    public void putFragment(Bundle var1, String var2, Fragment var3) {
        instance.putFragment(var1, var2, var3);
    }

    public Fragment getFragment(Bundle var1, String var2) {
        return instance.getFragment(var1, var2);
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment var1) {
        return instance.saveFragmentInstanceState(var1);
    }

    public boolean isDestroyed() {
        return instance.isDestroyed();
    }

    public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
        instance.dump(var1, var2, var3, var4);
    }

    public static void enableDebugLogging(boolean enabled) {
        FragmentManager.enableDebugLogging(enabled);
    }

    public void invalidateOptionsMenu() {
        instance.invalidateOptionsMenu();
    }
}
