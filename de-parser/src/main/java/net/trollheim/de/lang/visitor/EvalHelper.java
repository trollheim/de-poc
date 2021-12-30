package net.trollheim.de.lang.visitor;

import net.trollheim.lang.TestLangParser;

import java.util.Collection;
import java.util.function.BiFunction;

public final class EvalHelper {
    public static boolean evalTruthy(Object result) {
        if (result instanceof Boolean){
            return (Boolean) result;
        }
        if (result instanceof Number){
            return ((Number) result).intValue() !=0;
        }

        System.err.println("unknown type "+result.getClass().getName());
        return false;

    }

    public static BiFunction getOperation(TestLangParser.OperationContext ctx) {
        if (ctx.IN() != null){
            return  EvalHelper::isIn;
        }
        if (ctx.EQ() != null){
            return (a,b)->a.equals(b);
        }
        throw new RuntimeException("not implemented yet");

    }


    static boolean isIn(Object a, Object b){
        if (b instanceof Collection)    ((Collection) b).contains(a);
        return true;
    }
}
