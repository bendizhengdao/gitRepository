package com.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;

public class DoubleLinkedList {
	
	class Node{
		
		int primaryKey;
		
		String userName;
		
		Node last;
		
		Node next;
		
		public Node(int key,String userName){
			this.userName = userName;
			this.primaryKey = key;
			this.last = null;
			this.next = null;
		}
		
		public Node(){
			this.userName = null;
			this.primaryKey = 0;
			this.last = null;
			this.next = null;
		}
	}

	private Node head,tail;
	
	private ArrayList<Node> database = new ArrayList<>(); //database user
	
	private HashMap<Integer, Node> cache = new HashMap<>();//cache
	
	private int count = 0;
	
	private int capacity;
	
	private final int database_size = 10;
	
	public DoubleLinkedList(int capacity){
		
		this.capacity = capacity;
		
		head = new Node();
		
		tail = new Node();
		
		head.next = null;
		
		head.last = tail;
		
		tail.next = head;
		
		tail.last = null;
		
	}
	
	private void saveToDatabase(int key,String userName){
		if (database.size() < database_size){
			database.add(new Node(key, userName));
		}else {
			System.out.println("To much data,I can't save it,Sorry");
		}
	}
	
	private void print(Node node){
		if(node!=null){
			System.out.println("number:"+node.primaryKey+",name:"+node.userName);
		}else {
			throw new IllegalArgumentException("node is null");
		}
	}
	
	private void get(int key){
		Node node = cache.get(key),beitail = cache.get(key);
		if (beitail==null) {//不在缓存中
			System.out.println("Cache don't have the information about that user,load from database");
			node = searchDatabase(key);
		}
		System.out.println("Information about that user:");
		print(node);
	}

	private Node searchDatabase(int key) {
		return null;
	}
}
