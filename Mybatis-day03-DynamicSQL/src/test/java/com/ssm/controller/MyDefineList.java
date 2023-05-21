package com.ssm.controller;

import com.ssm.MyAbstractList;

public class MyDefineList<E> extends MyAbstractList<E>{
	
	private E[] elementData;
	
	private static final int DEFAULT_CAPACITY=0;
	
	public MyDefineList(){
		this(DEFAULT_CAPACITY);
	}
	
	public void rangeCheck(int index){
		if(index<0||index>this.size){
			throw new RuntimeException("Index:"+index+",Size:"+size);
		}
	}
	
	public MyDefineList(int capacity){
		capacity = capacity	<	DEFAULT_CAPACITY	?	DEFAULT_CAPACITY	:	capacity;
		elementData = (E[]) new Object[capacity];
	}
	

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		
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
		size = 0;
		elementData = null;
	}

}
