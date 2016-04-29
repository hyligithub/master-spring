package com.masterspring.common.demo.innerclass;

public class Goods1 {

    public Destination dest(String label) {
        class GDestination implements Destination {

            private String label;

            private GDestination(String l) {
                this.label = l;
            }

            public String readLabel() {
                // TODO Auto-generated method stub
                System.out.println(label);
                return label;
            }

        }
        return new GDestination(label);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Goods1 g = new Goods1();
        Destination d = g.dest("bJ");
        d.readLabel();
    }

}
