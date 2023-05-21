package com.ssm;

import com.ssm.inter.MyList;

public abstract class MyAbstractList<E> implements MyList<E> {
	
	protected int size;
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	
	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return indexOf(element)!=-1;
	}
	
	@Override
	public void add(E element) {
		add(size,element);
	}
	
	public abstract void add(int index,E element);
}
