package com.masterspring.common.demo.innerclass.test;

/**
 * Created by lihuiyan on 2015/9/16.
 */
public class Cars {
    private String type_brand;

    private int price = 100;

    private Cars(String type_brand) {
        this.type_brand = type_brand;
    }

    public Price getPrice() {
        return new Price() {

            public int printPrice() {
                return price * 100;
            }
        };
    }

    public Type getType() {
        return new Type() {
            public String printType() {
                System.out.println(type_brand);
                return "this is SUV";
            }
        };
    }

    public Brand getBrand() {
        return new Brand() {
            public String printBrand() {
                return "this is BMW";
            }
        };
    }

    public static void main(String[] args) {
        Cars cars = new Cars("bmw_suv");
        int price = cars.getPrice().printPrice();
        String brand = cars.getBrand().printBrand();
        String type = cars.getType().printType();
        System.out.println(brand + "--" + type + "--" + price);
    }
}
