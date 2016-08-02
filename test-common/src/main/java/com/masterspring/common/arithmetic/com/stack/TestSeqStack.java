package com.masterspring.common.arithmetic.com.stack;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/26.
 */
public class TestSeqStack {
    private static SeqStack<String> seqStack = new SeqStack<String>(16);

    private static String validate(String expstr) {
        for (int i = 0; i < expstr.length(); i++) {
            char ch = expstr.charAt(i);
            switch (ch) {
                case '(':
                    seqStack.put(String.valueOf(ch));
                    break;
                case ')': {
                    if (seqStack.isEmpty())
                        return "lack of '('";
                    else seqStack.pop();
                    break;
                }
            }
        }
        if (seqStack.isEmpty())
            return "OK";
        else
            return "lack of '('";
    }

    public static void main(String[] args) {
        String expstr = "((1+2)*3+4)";
        String expstr1 = "(((1+2)*3+4)";
        PrintUtil.print(validate(expstr1));
    }
}
