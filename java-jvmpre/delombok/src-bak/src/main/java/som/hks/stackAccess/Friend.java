package som.hks.stackAccess;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class Friend implements Doer{

    private Doer next;
    private boolean direct;

    public Friend(Doer next,boolean direct){
        this.next=next;
        this.direct=direct;
    }

    @Override
    public void doYourThing() {
        System.out.println("Im a Friend");

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
