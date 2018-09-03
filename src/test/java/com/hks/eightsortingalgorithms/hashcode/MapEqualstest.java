package com.hks.eightsortingalgorithms.hashcode;

import org.junit.Test;

import java.util.HashMap;

public class MapEqualstest {

    @Test
    public void keyEqualsTest(){
        HashMap<Person, String> map = new HashMap<Person, String>();
        Person p1 = new Person(101);
        Person p2 = new Person(102);
        Person p3 = new Person(103);
        map.put(p1, "tim");
        map.put(p2, "tony");
        map.put(p3, "Bi");
        System.out.println(map.get(new Person(101)));

        ///get的源码
        /*public V get(Object key) {
            HashMap.Node<K,V> e;
            return (e = getNode(hash(key), key)) == null ? null : e.value;
        }

这个方法做了以下几件事情：
1. 将输入的对象的hashcode拿出来

2. 将输入对象的hashcode和所有的KeySet中的对象hashcode进行比较

3. 将输入对象和所有的KeySet中的对象使用equals方法进行比较
        final Node<K,V> getNode(int hash, Object key) {
            Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
            if ((tab = table) != null && (n = tab.length) > 0 &&
                (first = tab[(n - 1) & hash]) != null) {
                if (first.hash == hash && // always check first node
                    ((k = first.key) == key || (key != null && key.equals(k))))
                    return first;
                if ((e = first.next) != null) {
                    if (first instanceof TreeNode)
                        return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                    do {
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            return e;
                    } while ((e = e.next) != null);
                }
            }
            return null;
        }*/

    }

}
