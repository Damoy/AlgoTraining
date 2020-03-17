package model;

import java.util.Arrays;
import java.util.List;

public class Array<T> {

	private T[] content;
	
	public Array(Class<T> type, int length) {
        @SuppressWarnings("unchecked")
        final T[] array = (T[]) java.lang.reflect.Array.newInstance(type, length);
        this.content = array;
	}
	
	public Array(T[] content) {
	  this.content = content;
	}
	
	public static <T> Array<T> from(T[] content){
	  return new Array<>(content);
	}
	
	public T get(int i) {
		return content[i];
	}
	
	public Array<T> set(int index, T value){
		content[index] = value;
		return this;
	}
	
	public int length() {
		return content.length;
	}
	
	public List<T> toList(){
	  return Arrays.asList(content);
	}
	
	public T[] getContent() {
	  return content;
	}
	
}
