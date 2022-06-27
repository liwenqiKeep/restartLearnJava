package com.lwq.leetcode.easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 *
 * @author liwenqi
 */
public class No20 {

    public static void main(String[] args) {
        String s1 = "}";

        System.out.println(isValid(s1));
    }

    /**
     * 自解
     */
    public static boolean isValid(String s) {
        if (s.length() < 1) {
            return false;
        }
        String left = "({[";
        if (s.length() == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> leftS = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (left.contains(String.valueOf(chars[i]))) {
                leftS.push(chars[i]);
            } else if (!leftS.empty()) {
                char a;
                switch (leftS.peek()) {
                    case '(':
                        a = ')';
                        break;
                    case '[':
                        a = ']';
                        break;
                    case '{':
                        a = '}';
                        break;
                    default:
                        return false;
                }
                if (a != chars[i]) {
                    return false;
                } else {
                    leftS.pop();
                }
            } else {
                return false;
            }
        }


        return leftS.empty();
    }


}
