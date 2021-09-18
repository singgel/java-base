package com.hks.enumClass;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.EnumMap;

public class EnumClassTest {

    public static void main(String args[]){
        // values() 的返回值是 Grade[]
        for (Grade g : Grade.values()) {
            System.out.println("Allowed value: '" + g + "'");
        }
    }

    @Test
    public void testSwitchStatement(PrintStream out) throws IOException {
        Student student = new Student("kuangsheng","he");
        StringBuffer outputText = new StringBuffer(student.getFullName());
        switch (student.getGrade()) {
            case A:
                outputText.append(" excelled with a grade of A");
                break;
            case B: // fall through to C
            case C:
                outputText.append(" passed with a grade of ")
                        .append(student.getGrade().toString());
                break;
            case D: // fall through to F
            case F:
                outputText.append(" failed with a grade of ")
                        .append(student.getGrade().toString());
                break;
            case INCOMPLETE:
                outputText.append(" did not complete the class.");
                break;
        }
        out.println(outputText.toString());
    }

    /**
     * 该代码使用了泛型（generics）和新的 EnumMap 构造来建立新映射
     * @param out
     * @throws IOException
     */
    public void testEnumMap(PrintStream out) throws IOException {
        // Create a map with the key and a String message
        EnumMap<AntStatus, String> antMessages =
                new EnumMap<AntStatus, String>(AntStatus.class);
        // Initialize the map
        antMessages.put(AntStatus.INITIALIZING, "Initializing Ant...");
        antMessages.put(AntStatus.COMPILING,"Compiling Java classes...");
        antMessages.put(AntStatus.COPYING,"Copying files...");
        antMessages.put(AntStatus.JARRING,"JARring up files...");
        antMessages.put(AntStatus.ZIPPING,"ZIPping up files...");
        antMessages.put(AntStatus.DONE, "Build complete.");
        antMessages.put(AntStatus.ERROR,"Error occurred.");
        // Iterate and print messages
        for (AntStatus status : AntStatus.values() ) {
            out.println("For status " + status + ", message is: " +
                    antMessages.get(status));
        }
    }

}
