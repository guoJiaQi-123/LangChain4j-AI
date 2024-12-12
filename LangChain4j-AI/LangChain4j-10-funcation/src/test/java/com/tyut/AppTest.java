package com.tyut;

import dev.langchain4j.code.graalvm.GraalVmJavaScriptExecutionEngine;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {


    @Test
    public void test() {
        GraalVmJavaScriptExecutionEngine engine = new GraalVmJavaScriptExecutionEngine();
        String execute = engine.execute("function sum(a,b){return a+b;}" +
                "sum(10,50);");
        System.out.println(execute);

    }
}
