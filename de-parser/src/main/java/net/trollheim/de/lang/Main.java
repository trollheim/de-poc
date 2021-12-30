package net.trollheim.de.lang;

import net.trollheim.de.lang.engine.DecisionEngine;
import net.trollheim.de.lang.engine.Option;
import net.trollheim.de.lang.visitor.State;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws Exception {
        JSONParser jsonParser = new JSONParser();
        List<JSONObject> a = (List<JSONObject>) jsonParser.parse(new FileReader("test.json"));
        List<Option> options = a.stream().map(o -> Option.fromJson(o)).collect(Collectors.toList());

        DecisionEngine engine = new DecisionEngine(options);
        State state = new State(Collections.singletonMap("country","UK"));
        Option decision = engine.makeDecision(state);
        System.out.println(decision.getValue());

    }



}