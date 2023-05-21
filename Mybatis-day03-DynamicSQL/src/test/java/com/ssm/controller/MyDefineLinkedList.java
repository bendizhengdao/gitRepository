package com.ssm.controller;

import com.ssm.MyAbstractList;

public class MyDefineLinkedList<E> extends MyAbstractList<E> {

	private Node head;
	
	private static class Node<E>{
		
		Node<E> next;
		
		E element; 
		
		public Node(Node next,E element){
			this.next = next;
			this.element = element;
		}
	}
	

	@Override
	public E get(int index) {
		checkElementIndex(index);
		return node(index).element;
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
		Node<E> xNode =head;
		for (int i = 0; i < index; i++) {
			xNode = xNode.next;
		}
		return xNode;
	}

	@Override
	public E set(int index, E element) {
		checkElementIndex(index);
		Node<E> node = node(index);
		E oldElement = node.element;
		node.element = element;
		return oldElement;
	}

	@Override
	public void add(int index, E element) {
		checkPositionElement(index);
		if (index==0) {
			head = new Node<E>(head, element);
		}else {
			Node<E> prev = node(index-1);
			//Node<E> next = prev.next;
			prev.next = new Node<E>(prev.next, element);
		}
		size++;
	}

	private void checkPositionElement(int index) {
		if(!isPositionElement(index)){
			throw new IndexOutOfBoundsException("index:"+index+",size:"+size);
		}
		
	}

	private boolean isPositionElement(int index) {
		
		return index >= 0 &&  index <= size;
	}

	@Override
	public E remove(int index) {
		checkElementIndex(index);
		Node<E> oldNode = head;
		if (index==0) {
			head = head.next;
		}else {
			Node<E> preNode = node(index-1);
			oldNode = preNode.next;
			preNode.next = oldNode.next;
		}
		return oldNode.element;
	}

	@Override
	public int indexOf(E element) {
		int index = 0;
		Node<E> node = head;
		if (element==null) {
			for (Node i = node; i != null; i=i.next) {
				if (element==i.element) {
					return index;
				}
				index++;
			}
		}else {
			for (Node i = node; i != null; i=i.next) {
				if (element.equals(i.element)) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}

	@Override
	public void clear() {
		size = 0;
		head = null;
	}
	
	public String toString(){
		StringBuilder sbBuilder = new StringBuilder().append("[");
		if (size==0) {
			return sbBuilder.append("]").toString();
		}
		Node nextNode = head;
		for (Node i = nextNode; i !=null; i=i.next) {
			sbBuilder.append(i.element);
			if (i==null) {
				sbBuilder.append("]");
			}
			sbBuilder.append(",");
		}
		return sbBuilder.toString();
	}
}