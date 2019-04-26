package com.hks.eightsortingalgorithms.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * 上面已经讨论了执行脚本的第一步，就是得到一个可用的脚本引擎。
 * 在完成这项工作之后就可以利用这个脚本引擎执行相应的脚本了。
 *
 * 我们可以使用ScriptEngine的eval方法来执行脚本。
 * eval方法被重载的多次，但最常用的是 public Object eval(String script)。
 */
public class FirstJavaScript
{
    public static void main(String args[])
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        // 得到javascript脚本引擎
        ScriptEngine engine = manager.getEngineByName("javascript");
        try
        {
            // 开始运行脚本，并返回当前的小时
            Double hour = (Double)engine.eval("var date = new Date();" +"date.getHours();");
            String msg;
            // 将小时转换为问候信息
            if (hour < 11)
            {
                msg = "上午好";
            }
            else if (hour < 13)
            {
                msg = "中午好";
            }
            else if (hour < 18)
            {
                msg = "下午好";
            }
            else
            {
                msg = "晚安";
            }
            out.printf("小时%s: %s%n", hour, msg);
        }
        catch (ScriptException e)
        {
            err.println(e);
        }
    }
}
