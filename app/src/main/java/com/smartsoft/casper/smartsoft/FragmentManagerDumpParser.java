package com.smartsoft.casper.smartsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by casper on 11.01.16.
 */
public class FragmentManagerDumpParser {
    public static final String PREFIX = "PREFIX_NAME";
    private static final String ADDED_FRAGMENTS = "Added Fragments:";
    private static final String BACK_STACK = "Back Stack:";

    public static List<FragmentInfo> parse(String dump) {
        List<FragmentInfo> result = new ArrayList<>();

        int startIndex = dump.indexOf(ADDED_FRAGMENTS);
        int endIndex = dump.indexOf(BACK_STACK);
        if(startIndex == -1 || endIndex == -1) {
            return result;
        }
        String[] lines = dump.substring(startIndex, endIndex).split("\n");
        for (int i = 1; i < lines.length - 1; i++) {
            String className = lines[i];
            className = className.replace(PREFIX, "").trim();
            if (className.startsWith("#")) {
                className = className.substring(className.indexOf(":") + 1, className.indexOf("{")).trim();
                result.add(new FragmentInfo(className));
            }
        }
        return result;
    }
}
