package com.netradyne.entities;

public class Entity<E> {

	private String columnName;

	private E value;

	public Entity(String columnName, E value) {
		this.columnName = columnName;
		this.value = value;
	}

	public String getColumnName() {
		return columnName;
	}

	public E getValue() {
		return value;
	}
	
	

}
