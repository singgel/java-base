package com.hks.eightsortingalgorithms.cloneClass;

import org.junit.Test;

/**
 * 浅拷贝
 * <p>
 * 可见，二者的name属性依然是指向同一个对象。
 * 上面故意将age属性改为int基本类型，因为基本数据类型是不存在引用问题。
 * 这实际上就是典型的浅拷贝
 */
public class RealCopy {

    @Test
    public void copyRealObject() throws CloneNotSupportedException {
        Person p = new Person(23, "zhang");
        Person p1 = (Person) p.clone();
        System.out.println(p);
        System.out.println(p1);
        System.out.println("------------------------------");
        System.out.println("pName：" + p.getName().hashCode());
        System.out.println("p1Name：" + p1.getName().hashCode());
    }

    /**
     * 对Body对象来说，算是这算是深拷贝吗？
     * 其实应该算是深拷贝，因为对Body对象内所引用的其他对象（目前只有Head）都进行了拷贝，
     * 也就是说两个独立的Body对象内的head引用已经指向了独立的两个Head对象
     * <p>
     * 但是，这对于两个Head对象来说，他们指向了同一个Face对象，
     * 这就说明，两个Body对象还是有一定的联系，并没有完全的独立。这应该说是一种不彻底的深拷贝
     *
     * 至于彻底深拷贝，几乎是不可能实现的，原因已经在上一节中进行了说明。
     * 深拷贝和彻底深拷贝，在创建不可变对象时，可能对程序有着微妙的影响，
     * 可能会决定我们创建的不可变对象是不是真的不可变。clone的一个重要的应用也是用于不可变对象的创建。
     * @throws CloneNotSupportedException
     */
    @Test
    public void reallyCopy() throws CloneNotSupportedException {

        Body body = new Body(new Head(new Face()));

        Body body1 = (Body) body.clone();

        System.out.println("body == body1 : " + (body == body1));

        System.out.println("body.head == body1.head : " + (body.head == body1.head));

        System.out.println("body.head.face == body1.head.face : " + (body.head.face == body1.head.face));

    }

    static class Body implements Cloneable {
        public Head head;

        public Body() {
        }

        public Body(Head head) {
            this.head = head;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Body newBody = (Body) super.clone();
            newBody.head = (Head) head.clone();
            return newBody;
        }

    }

    static class Head implements Cloneable {
        public Face face;

        public Head() {
        }

        public Head(Face face) {
            this.face = face;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Head head = (Head) super.clone();
            head.face = (Face) face.clone();
            return head;
        }
    }

    static class Face implements Cloneable{
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

}
