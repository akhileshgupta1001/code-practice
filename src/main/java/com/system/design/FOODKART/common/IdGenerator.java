package com.system.design.FOODKART.common;

public class IdGenerator {
    private static int id = 0;

    public static int getId() {
        return id++;
    }
}
