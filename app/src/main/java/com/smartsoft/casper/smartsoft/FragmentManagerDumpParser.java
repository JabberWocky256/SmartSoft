package com.smartsoft.casper.smartsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by casper on 11.01.16.
 */
public class FragmentManagerDumpParser {
    public static final String PREFIX = "PREFIX_NAME";
    private static final String ACTIVE_FRAGMENTS = "Active Fragments";
    private static final String ADDED_FRAGMENTS = "Added Fragments:";

    public static List<FragmentInfo> parse(String dump) {
        List<FragmentInfo> result = new ArrayList<>();

        int startIndex = dump.indexOf(ACTIVE_FRAGMENTS);
        int endIndex = dump.indexOf(ADDED_FRAGMENTS);
        if (startIndex == -1 || endIndex == -1) {
            return result;
        }
        String[] lines = dump.substring(startIndex, endIndex).split("\n");
        for (int i = 1; i < lines.length - 1; i++) {
            String line = lines[i];
            line = line.replace(PREFIX, "").trim();
            if (line.startsWith("#")) {
                String className = tryToGetClassName(line);
                result.add(new FragmentInfo(className));
                continue;
            }

            String mFragmentIdConstant = "mFragmentId=#";
            if (line.startsWith(mFragmentIdConstant)) {
                String fragId = tryToGetFragmentId(line, mFragmentIdConstant);
                if (result.size() > 0 && !fragId.isEmpty()) {
                    FragmentInfo fragmentInfo = result.get(result.size() - 1);
                    fragmentInfo.id = Integer.parseInt(fragId, 16);
                }
                continue;
            }
        }
        return result;
    }

    private static String tryToGetClassName(String line) {
        int nameStartIndex = line.indexOf(":");
        int nameEndIndex = line.indexOf("{");
        if (nameStartIndex != -1 && nameEndIndex != -1) {
            line = line.substring(nameStartIndex + 1, nameEndIndex).trim();
            return line;
        }

        return "";
    }

    private static String tryToGetFragmentId(String line, String mFragmentIdConstant) {
        int nameStartIndex = mFragmentIdConstant.length() - 1;
        int nameEndIndex = line.indexOf(" ");
        if (nameStartIndex != -1 && nameEndIndex != -1) {
            line = line.substring(nameStartIndex + 1, nameEndIndex).trim();
            return line;
        }

        return "";
    }
}
