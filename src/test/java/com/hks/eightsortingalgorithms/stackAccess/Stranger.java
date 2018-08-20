package com.hks.eightsortingalgorithms.stackAccess;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class Stranger implements Doer {

    private Doer next;
    private boolean direct;

    public Stranger(Doer next, boolean direct) {
        this.next = next;
        this.direct = direct;
    }

    @Override
    public void doYourThing() {
        System.out.println("Im a Stranger");

        if (direct) {
            next.doYourThing();
        } else {
            AccessController.doPrivileged(new PrivilegedAction() {

                @Override
                public Object run() {
                    next.doYourThing();
                    return null;
                }

            });

        }
    }


}
