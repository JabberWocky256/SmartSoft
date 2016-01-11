package com.smartsoft.casper.smartsoft;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by alexander on 09.01.16.
 */
public class CustomFragmentManager implements CustomFragmentManagerImp {
    private FragmentManager instance;

    public CustomFragmentManager(FragmentManager instance) {
        this.instance = instance;
    }

    public static void enableDebugLogging(boolean enabled) {
        FragmentManager.enableDebugLogging(enabled);
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
        List<FragmentInfo> infos;
        try {
            infos = getFragmentsStackByReflationField();
        }  catch (Exception e) {
            infos = getFragmentsStackFromDump();
        }
        ListIterator<FragmentInfo> iter = infos.listIterator(infos.size());
        int popBackCount = getPopBackOverlappingCount(iter);
        popBackStack(popBackCount);
    }

    private List<FragmentInfo> getFragmentsStackByReflationField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        List<FragmentInfo> result = new ArrayList<>();
        Class classToInvestigate = Class.forName("android.app.FragmentManagerImpl");
        Field field = classToInvestigate.getDeclaredField("mAdded");
        field.setAccessible(true);
        ArrayList<Fragment> fragments = (ArrayList<Fragment>) field.get(instance);
        for(int i = 0; i < fragments.size(); i++) {
            result.add(new FragmentInfo(fragments.get(i).getClass().getName()));
        }

        return result;
    }

    private List<FragmentInfo> getFragmentsStackFromDump() {
        String dump = "";
        DumpWriter writer = new DumpWriter();
        instance.dump(FragmentManagerDumpParser.PREFIX, new FileDescriptor(), writer, new String[]{});
        dump = writer.toString();
        writer.close();

        return FragmentManagerDumpParser.parse(dump);
    }

    private int getPopBackOverlappingCount(ListIterator<FragmentInfo> iter) {
        int popBackCount = 0;
        String previousClassName = null;
        while (iter.hasPrevious()) {
            String nextClassName = "";
            nextClassName = iter.previous().className;
            if (previousClassName == null || nextClassName.equals(previousClassName)) {
                popBackCount++;
            }
        }
        return popBackCount;
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

    public void invalidateOptionsMenu() {
        instance.invalidateOptionsMenu();
    }
}
