package som.hks.script;

import javax.script.*;
import static java.lang.System.*;

/**
 * 动态实现接口
 *
 * 脚本引擎还有一个更吸引的功能，那就是动态实现接口。
 * 如我们要想让脚本异步地执行，即通过多线程来执行，
 * 那InvokeEngine类必须实现 Runnable接口才可以通过Thread启动多线程。
 *
 * 因此，可以通过getInterface方法来使InvokeEngine动态地实现 Runnable接口。
 */
public class InterfaceTest
{
    public static void main(String args[])
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        try
        {
            engine.eval("function run() {print('异步调用');}");
            Invocable invokeEngine = (Invocable)engine;
            Runnable runner = invokeEngine.getInterface(Runnable.class);
            Thread t = new Thread(runner);
            t.start();
            t.join();
        }
        catch (InterruptedException e)
        {
            err.println(e);
        }
        catch (ScriptException e)
        {
            System.err.println(e);
        }
    }
}
