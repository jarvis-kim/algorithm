package com.github.jarviskim.algorithm.book.apss_hanbit.list;

import java.util.Iterator;

public class JarvisLinkedList<T> implements Iterable<T> {

    private Node<T> head = null;

    public void push(T t) {
        if ( head == null ) {
            head = new Node<T>(t);
            return;
        }

        Node<T> node = head;
        while ( node.next != null ) {
            node = node.next;
        }

        node.next = new Node(t);
    }

    public void push(T t, int position) {
        if ( position == 0 ) {
            Node<T> headNode = new Node<T>(t);
            headNode.next = head;
            head = headNode;
            return;
        }

        Node<T> newNode = new Node<T>(t);
        Node<T> previousNode = getNode(position - 1);
        Node<T> node = previousNode.next;
        previousNode.next = newNode;
        newNode.next = node;
    }

    public void remove(T t) {
        if ( head == null ) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = head;
        Node<T> previousNode = node;
        while ( node != null ) {
            if ( node.value.equals(t) ) {
                break;
            }
            previousNode = node;
            node = node.next;
        }

        Node<T> nextNode = node.next != null
                ? node.next
                : null;

        previousNode.next = nextNode;
    }

    public T get(int position) {
        Node<T> node = getNode(position);
        if ( node == null ) {
            throw new IndexOutOfBoundsException();
        }

        return node.value;
    }


    protected Node<T> getNode(int position) {
        if ( head == null ) {
            return null;
        }

        Node<T> node = head;
        for ( int index = 0; index < position; index++ ) {
            if ( node.next == null ) {
                throw new IndexOutOfBoundsException();
            }
            node = node.next;
        }

        return node;
    }

    public int size() {
        int size = 0;
        Node<T> node = head;

        while ( node != null ) {
            node = node.next;
            size++;
        }

        return size;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[ ");

        Node<T> node = head;
        while ( node != null ) {
            builder.append("{ ")
                    .append(node.value.toString())
                    .append(" }");
            if ( node.next != null ) {
                builder.append(", ");
            }
            node = node.next;
        }

        builder.append(" ]");

        return builder.toString();
    }

    public Iterator<T> iterator() {
        return new NodeIterator(head);
    }

    private class NodeIterator implements Iterator<T> {

        private Node<T> head;

        private Node<T> node;

        public NodeIterator(Node<T> head) {
            this.head = head;
            this.node = head;
        }

        public boolean hasNext() {
            return node != null;
        }

        public T next() {
            if ( node == null ) {
                return null;
            }
            T t = node.value;
            node = node.next;
            return t;
        }

        public void remove() {

        }
    }
}
