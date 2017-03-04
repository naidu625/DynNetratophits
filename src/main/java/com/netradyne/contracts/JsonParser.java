package com.netradyne.contracts;

public interface JsonParser<E> {
	
	public E parseJson(String json,String column);

}
