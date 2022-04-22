
package com.mycompany.solonoble;

/**
 *
 * @author ISO53
 */
public class Node<T> {

    T data;
    Node<T> belowNode;
    Node<T> rightNode;
    String coordination;

    public Node(T data, String coordination) {
        this.data = data;
        this.coordination = coordination;
        this.belowNode = null;
        this.rightNode = null;
    }
}
