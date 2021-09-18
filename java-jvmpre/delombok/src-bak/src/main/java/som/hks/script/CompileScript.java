package som.hks.script;

import javax.script.*;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * 让脚本运行得更快
 *
 * 我们可以使用 ScriptEngine的compile方法进行编译。
 *
 * 并不是所有脚本引擎都支持编译，只有实现了Compilable接口的脚本引擎才可以使用 compile进行编译，
 * 否则将抛出一个错误。下面的例子将演示如何使用compile方法编译并运行javascript脚本。
 */
public class CompileScript
{
    public static void main(String args[])
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        engine.put("counter", 0); // 向javascript传递一个参数
        // 判断这个脚本引擎是否支持编译功能
        if (engine instanceof Compilable)
        {
            Compilable compEngine = (Compilable)engine;
            try
            {
                // 进行编译
                CompiledScript script = compEngine.compile("function count() { " +
                        " counter = counter +1; " +
                        " return counter; " +
                        "}; count();");
                out.printf("Counter: %s%n", script.eval());
                out.printf("Counter: %s%n", script.eval());
                out.printf("Counter: %s%n", script.eval());
            }
            catch (ScriptException e)
            {
                err.println(e);
            }
        }
        else
        {
            err.println("这个脚本引擎不支持编译!");
        }
    }
}
