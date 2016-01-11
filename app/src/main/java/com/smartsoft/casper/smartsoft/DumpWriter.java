package com.smartsoft.casper.smartsoft;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by casper on 11.01.16.
 */
public class DumpWriter extends PrintWriter {

    public DumpWriter() {
        super(new StringWriter());
    }

    @Override
    public void close() {
        super.flush();
        super.close();
    }

    public String toString() {
        return out.toString();
    }
}
