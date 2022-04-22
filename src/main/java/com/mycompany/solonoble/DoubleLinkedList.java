
package com.mycompany.solonoble;

/**
 * Some methods of this class have been overloaded, Ex: addLast. Thats because
 * this is a DoubleLinkedList and type of use of this list is that the one of
 * the list used for holding head nodes. Other lists used as normal list and
 * holds T data and coordinate. Read the method javadocs carrefully.
 * @author termi
 */
public class DoubleLinkedList<T> {

    Node<T> head;

    public DoubleLinkedList(T data, String coordination) {
        this.head = new Node<>(data, coordination);
    }

    /**
     * This addLast method used for normal linked lists. Any effort of using
     * this method with the list that holds the head nodes, will result in
     * malfunction.
     * 
     * Adds new node to the end of linked list.
     * 
     * @param data
     * @param coordination
     */
    public void addLast(T data, String coordination) {
        Node<T> newNode = new Node<>(data, coordination);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> tempNode = this.head;
            while (tempNode.belowNode != null) {
                tempNode = tempNode.belowNode;
            }
            tempNode.belowNode = newNode;
        }
    }

    /**
     * This addLast method used for header linked lists. Any effort of using
     * this method with the normal linked list, will result in malfunction.
     * 
     * Adds new head node at the end of linked list that holds the head nodes.
     * 
     * @param dLL
     */
    public void addLast(DoubleLinkedList dLL) {
        if (head == null) {
            head = dLL.head;
        } else {
            Node<T> tempNode = this.head;
            while (tempNode.rightNode != null) {
                tempNode = tempNode.rightNode;
            }
            tempNode.rightNode = dLL.head;
        }
    }

    /**
     * Works only with linked list that holds the head nodes. Any effort of
     * using this method with the normal list, will result in malfunction.
     */
    public void print() {
        Node<T> node = this.head;
        Node<T> header = this.head;
        System.out.println("\n**************************************************************");
        while (true) {
            if (node != null) {
                System.out.print(node.coordination + " -> ");
                node = node.belowNode;
            } else {
                if (header.rightNode != null) {
                    header = header.rightNode;
                    node = header;
                    System.out.print("\n v \n");
                } else {
                    break;
                }
            }
        }
        System.out.println("\n**************************************************************\n");
    }

    /**
     * Works only with linked list that holds the head nodes. Any effort of
     * using this method with the normal list, will result in malfunction.
     * 
     * Inserts to the next node from the node whose coordination matches.
     * 
     * @param data
     * @param coordination
     * @param searchCoordination
     */
    public void insertAfter(T data, String coordination, String searchCoordination) {
        Node<T> node = this.head;
        Node<T> header = this.head;

        while (true) {
            if (node != null) {
                if (node.coordination.equals(searchCoordination)) {
                    Node<T> newNode = new Node<>(data, coordination);
                    newNode.belowNode = node.belowNode;
                    node.belowNode = newNode;
                    break;
                } else {
                    node = node.belowNode;
                }
            } else {
                if (header.rightNode != null) {
                    header = header.rightNode;
                    node = header;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Removes the temporary node that was created when the list was created.
     */
    public void removeTemp() {
        head = head.belowNode;
    }

    /**
     * Works only with linked list that holds the head nodes. Any effort of
     * using this method with the normal list, will result in malfunction.
     * 
     * This method removes first node that matches the given coordination.
     * Returns false if method cannot find the coordination or head is null.
     * 
     * @param searchCoordination
     * @return true if removed
     */
    public boolean remove(String searchCoordination) {
        if (head == null) {
            System.out.println("List is empty!");
            return false;
        } else if (isInHeaders(searchCoordination)) {
            Node<T> tempNodeH = head.rightNode;
            Node<T> prevNodeH = head;

            if (head.coordination.equals(searchCoordination)) { // A1
                Node<T> temp = head.rightNode;
                head = head.belowNode;
                head.rightNode = temp;
                return true;
            }

            while (tempNodeH != null && !tempNodeH.coordination.equals(searchCoordination)) {
                tempNodeH = tempNodeH.rightNode;
                prevNodeH = prevNodeH.rightNode;
            }
            if (tempNodeH != null) {
                if (tempNodeH.belowNode == null) {
                    prevNodeH.rightNode = tempNodeH.rightNode;
                    return true;
                } else {
                    prevNodeH.rightNode = tempNodeH.belowNode;
                    tempNodeH.belowNode.rightNode = tempNodeH.rightNode;
                    return true;
                }
            }

        } else {
            boolean outerLoop = true;
            Node<T> header = this.head;

            while (outerLoop) {
                Node<T> tempNode = header.belowNode;
                Node<T> prevNode = header;

                while (tempNode != null && !tempNode.coordination.equals(searchCoordination)) {
                    tempNode = tempNode.belowNode;
                    prevNode = prevNode.belowNode;
                }

                if (tempNode != null) {
                    prevNode.belowNode = tempNode.belowNode;
                    return true;
                } else {
                    if (header.rightNode != null) {
                        header = header.rightNode;
                    } else {
                        System.out.println("Coordination not found!");
                        return false;
                    }
                }
            }

        }
        return false;
    }

    /**
     * It's obvious 
     */
    public void clear() {
        this.head = null;
    }

    /**
     * Works only with linked list that holds the head nodes. Any effort of
     * using this method with the normal list, will result in malfunction.
     * 
     * Checks if the headers list has the given coordinate. Returns false if
     * head is null or cannot find the given coordinate.
     * 
     * @param searchCoordination
     * @return true if it is in header linked list
     */
    public boolean isInHeaders(String searchCoordination) {
        Node<T> node = head;
        if (node == null) {
            return false;
        }
        while (node != null && !node.coordination.equals(searchCoordination)) {
            node = node.rightNode;
        }
        return !(node == null);
    }

    /**
     * Works only with linked list that holds the head nodes. Any effort of
     * using this method with the normal list, will result in malfunction.
     * 
     * Checks the entire double linked list if it has the given coordinate.
     * Returns false if head is null or cannot find the given coordinate.
     * 
     * @param searchCoordination
     * @return true if the linked list has the given coordinate.
     */
    public boolean doesItHave(String searchCoordination) {
        Node<T> node = this.head;
        Node<T> header = this.head;

        while (true) {
            if (node != null) {
                if (node.coordination.equals(searchCoordination)) {
                    return true;
                }
                node = node.belowNode;
            } else {
                if (header.rightNode != null) {
                    header = header.rightNode;
                    node = header;
                } else {
                    return false;
                }
            }
        }
    }
    
    /**
     * Works only with linked list that holds the head nodes. Any effort of
     * using this method with the normal list, will result in malfunction.
     * 
     * Returns the size of the double linked list. Returns zero otherwise
     * @return the size of the double linked list
     */
    public int getSize() {
        Node<T> node = this.head;
        Node<T> header = this.head;
        int counter = 0;
        while (true) {
            if (node != null) {
                node = node.belowNode;
                counter++;
            } else {
                if (header.rightNode != null) {
                    header = header.rightNode;
                    node = header;
                    counter++;
                } else {
                    break;
                }
            }
        }
        return counter;
    }

    public char getLetter(String coordination) {      // Example: B3
        return coordination.charAt(0);
    }

    public int getNumber(String coordination) {         // Example: C12
        return Integer.parseInt(coordination.substring(1));
    }
}
