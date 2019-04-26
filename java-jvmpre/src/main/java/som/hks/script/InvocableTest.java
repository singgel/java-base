package som.hks.script;

import javax.script.*;
import static java.lang.System.*;

/**
 * 动态调用脚本语言的方法
 *
 * 但如果脚本中有多个函数或想通过用户的输入来决定调用哪个函数，
 * 这就需要使用invoke方法进行动态调用。
 * 和编译一样，脚本引擎必须实现Invocable接口才可以动态调用脚本语言中的方法。
 */
public class InvocableTest {
    public static void main(String args[]) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        String name = "abcdefg";
        if (engine instanceof Invocable) {
            try {
                engine.eval("function reverse(name) {" +
                        " var output =' ';" +
                        " for (i = 0; i <= name.length; i++) {" +
                        " output = name.charAt(i) + output" +
                        " } return output;}");
                Invocable invokeEngine = (Invocable) engine;
                Object o = invokeEngine.invokeFunction("reverse", name);
                out.printf("翻转后的字符串：%s", o);
            } catch (NoSuchMethodException e) {
                err.println(e);
            } catch (ScriptException e) {
                err.println(e);
            }
        } else {
            err.println("这个脚本引擎不支持动态调用");
        }
    }
}
