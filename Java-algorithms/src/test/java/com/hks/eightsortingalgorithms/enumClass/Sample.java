package com.hks.eightsortingalgorithms.enumClass;

public class Sample {
    enum Size {
        Small(0.8),
        Medium(1.0),
        Large(1.2);
        double pricingFactor;
        Size(double p) {
            pricingFactor = p;
        }
    }
    public static void main(String args[]) {
        Size s = Size.Large;
        double d = s.pricingFactor;
        System.out.println(s + " Size has pricing factor of " + d);
    }
}
