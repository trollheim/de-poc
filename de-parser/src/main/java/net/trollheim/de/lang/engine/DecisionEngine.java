package net.trollheim.de.lang.engine;

import net.trollheim.de.lang.visitor.State;
import net.trollheim.de.lang.visitor.TestVisitor;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


import net.trollheim.lang.TestLangParser;

import java.util.List;

public class DecisionEngine {

    private final List<Option> options;

    public DecisionEngine(List<Option> options) {
        this.options = options;

    }

    public Option makeDecision(State state){
        for (Option option : options){
            if (parse(option.getScript(),state)){
                return option;
            }
        }
        return Option.NONE;
    }


    private boolean parse(String code, State state) {


        net.trollheim.lang.TestLangLexer lexer = new net.trollheim.lang.TestLangLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TestLangParser parser = new TestLangParser(tokens);

        TestVisitor v = new TestVisitor(state);
        return (boolean) v.visit(parser.root());

    }


}
