import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.ScriptEngineManager;

public class FailNashornTest {
    public static String initEnv = "var $$prints=[], print=function(s){$$prints.push(s);};";
    public static String loadViz = "load('classpath:viz.js');";
    public static String eval1 = "Viz('digraph g { a -> b; }');";
    public static String eval2 = "$$prints=[]; Viz('graph g {a--b}',{format:'svg',engine:'dot'});";
    @Test
    public void testFailCase() throws ScriptException {
        // assert 1 == 2;
        final ScriptEngine nashornEngine = new ScriptEngineManager().getEngineByExtension("js");

        nashornEngine.eval(initEnv);
        nashornEngine.eval(loadViz);
        // outputting times to see how fast it loads: looks like only the first run is slow.

        System.out.println(System.currentTimeMillis() / 1000);
        nashornEngine.eval(eval1);
        System.out.println(System.currentTimeMillis() / 1000);
        nashornEngine.eval(eval2);
        System.out.println(System.currentTimeMillis() / 1000);
        nashornEngine.eval(eval2);
        System.out.println(System.currentTimeMillis() / 1000);
        nashornEngine.eval(eval2);
        System.out.println(System.currentTimeMillis() / 1000);
        nashornEngine.eval(eval2);
        System.out.println(System.currentTimeMillis() / 1000);
        nashornEngine.eval(eval2);
        System.out.println(System.currentTimeMillis() / 1000);
    }
}
