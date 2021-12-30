package net.trollheim.de.lang.visitor;

import java.util.Map;

public class State {
    final private Map<String,Object> map;
    public State(Map<String,Object> map) {
        this.map = map;
    }

    public Object get(String key){
        return map.get(key);
    }

}
