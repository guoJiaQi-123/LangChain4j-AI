package com.tyut.tool;

import dev.langchain4j.agent.tool.Tool;

/**
 * @version v1.0
 * @author OldGj 2024/12/11
 * @apiNote 计算一个数的平方根
 */
public class NumberTool {
    @Tool("计算一个数的平方根")
    private double sqrt(double a) {
        return Math.sqrt(a);
    }
}
