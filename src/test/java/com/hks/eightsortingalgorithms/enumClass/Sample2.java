package com.hks.eightsortingalgorithms.enumClass;

public class Sample2 {
    enum Size {
        Small(0.8),
        Medium(1.0),
        Large(1.2);
        private double pricingFactor;
        Size(double p) {
            pricingFactor = p;
        }
        public double getPricingFactor() {
            return pricingFactor;
        }
    }
    public static void main(String args[]) {
        Size s = Size.Large;
        double d = s.getPricingFactor();
        System.out.println(s + " Size has pricing factor of " + d);
    }
}
