package net.trollheim.de.lang.engine;

import org.json.simple.JSONObject;

public class Option {

    public static Option NONE = new Option("","","");

    public static Option fromJson(JSONObject object) {
        return new Option(object.getOrDefault("name", "").toString(), object.getOrDefault("value", "").toString(), object.getOrDefault("script", "").toString());
    }

    private final String name;
    private final String value;
    private final String script;

    private Option(String name, String value, String script) {
        this.name = name;
        this.value = value;
        this.script = script;
    }


    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getScript() {
        return script;
    }
}
