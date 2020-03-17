package model;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings("rawtypes")
public class Input {
	
	private Map<Class, List<Object>> content;
	
	public Input() {
		content = new HashMap<>();
	}
	
	public Input addEntry(Class type, Object value) {
		List<Object> inputValues;
		
		if(content.containsKey(type)) {
			inputValues = content.get(type);
		} else {
			inputValues = new ArrayList<>();
			content.put(type, inputValues);
		}
		
		inputValues.add(value);
		return this;
	}
	
  public List<Object> getEntry(Class type){
		return content.containsKey(type)
		    ? content.get(type)
				: null;
	}
  
  public Object getFirstEntry(Class type){
    return getEntry(type, 0);
  }
  
  public Object getEntry(Class type, int index){
    return content.containsKey(type)
        ? content.get(type).get(index)
        : null;
  }
	
}
