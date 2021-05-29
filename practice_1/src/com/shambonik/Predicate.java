package com.shambonik;

import java.util.ArrayList;

@FunctionalInterface
public interface Predicate {
    boolean maxScore(ArrayList<Student> students);
}
