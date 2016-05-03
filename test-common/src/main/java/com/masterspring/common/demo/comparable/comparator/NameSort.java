package com.masterspring.common.demo.comparable.comparator;


import com.masterspring.common.demo.comparable.Name;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NameSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Name[] aa = new Name[]{
                new Name("John", "Lennon", "3556465464644343"),
                new Name("Karl", "Marx", "3556465461111111"),
                new Name("Groucho", "Marx", "3805236412578"),
                new Name("Oscar", "Grouch", "8854321622238")};
        List<Name> ll = Arrays.asList(aa);

        Collections.sort(ll, new FirstNameOrder());
        for (Name a : ll) {
            System.out.println(a.toString());
        }
    }

}
