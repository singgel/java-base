package som.hks.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * 和脚本语言进行交互
 *
 * put 有两个参数，一个是脚本变量名，另一个是变量的值，这个值是Object类型，因此，可以传递任何值。
 * get 有一个参数，就是脚本变量的名。
 */
public class ReverseString
{
    public static void main(String args[])
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        // 建立javascript脚本引擎
        ScriptEngine engine = manager.getEngineByName("javascript");
        try
        {
            // 将变量name和变量值abcdefg传给javascript脚本
            engine.put("name", "abcdefg");
            // 开始执行脚本
            engine.eval("var output ='' ;" +
                    "for (i = 0; i <= name.length; i++) {" +
                    " output = name.charAt(i) + output" +
                    "}");
            // 得到output变量的值
            String name = (String)engine.get("output");
            out.printf("被翻转后的字符串：%s", name);
        }
        catch (ScriptException e)
        {
            err.println(e);
        }
    }
}
