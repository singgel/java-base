package som.hks.script;

import javax.script.*;
import java.util.*;

import static java.lang.System.*;

/**
 * 必须要知道你的Java SE 6支持什么脚本语言。
 * 在javax.script包中有很多的类，但这些类中最主要的是ScriptEngineManager。
 * 可以通过这个类得到当前 Java SE 6所支持的所有脚本。
 *
 * 如下面例子将列出所有可以使用的脚本引擎工厂。
 */
public class ListScriptEngines {
    public static void main(String args[]) {
        ScriptEngineManager manager = new ScriptEngineManager();
        // 得到所有的脚本引擎工厂
        List<ScriptEngineFactory> factories = manager.getEngineFactories();
        // 这是Java SE 5 和Java SE 6的新For语句语法
        for (ScriptEngineFactory factory : factories) {
        // 打印脚本信息
            out.printf("Name: %s%n" +
                            "Version: %s%n" +
                            "Language name: %s%n" +
                            "Language version: %s%n" +
                            "Extensions: %s%n" +
                            "Mime types: %s%n" +
                            "Names: %s%n",
                    factory.getEngineName(),
                    factory.getEngineVersion(),
                    factory.getLanguageName(),
                    factory.getLanguageVersion(),
                    factory.getExtensions(),
                    factory.getMimeTypes(),
                    factory.getNames());
            // 得到当前的脚本引擎
            ScriptEngine engine = factory.getScriptEngine();
        }
    }
}