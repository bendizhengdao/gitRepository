package com.ssm.controller;

import com.ssm.MyAbstractList;

public class MyDefinTopLinkedList<E> extends MyAbstractList<E> {
	
	private Node headNode;
	
	private Node endNode;

	private static class Node<E>{
		
		Node<E> prev;
		
		Node<E> next;
		
		E element; 
		
		public Node(Node prev,Node next,E element){
			this.prev = prev;
			this.next = next;
			this.element = element;
		}
	}
	
	@Override
	public E get(int index) {
		checkElementIndex(index);
		Node<E> node = node(index);
		return node.element;
	}

	private void checkElementIndex(int index){
		if (!isElementIndex(index)) {
			throw new IndexOutOfBoundsException("index:"+index+",size:"+size);
		}
	}
	
	private boolean isElementIndex(int index) {
		
		return index >= 0 &&  index < size;
	}

	private Node<E> node(int index) {
		Node<E> head = headNode;
		for (int i =0;i<index;i++) {
			head = head.next;
		}
		return head;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

}
