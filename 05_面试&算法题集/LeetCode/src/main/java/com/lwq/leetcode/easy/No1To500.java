package com.lwq.leetcode.easy;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liwenqi
 */
public class No1To500 {
    public static void main(String[] args) {
        No1To500 te = new No1To500();
//        int[] arr = {9,9};
//        System.out.println(Arrays.toString(te.plusOne(arr)));
        ListNode ln = new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(2,null))));
        System.out.println(te.deleteDuplicates(ln));
    }
    /**
     * 88. 合并两个有序数组
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }

    /**
     * 83. 删除排序链表中的重复元素
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null ){
            return head;
        }
        ListNode  cur = head;
        ListNode o = head.next;
        while ( o != null){
            if(cur.val == o.val){
                cur.next = o.next;
            }else {
                cur = cur.next;
            }
            o = o.next;

        }
        return head;
    }

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     */

    public int climbStairs(int n) {
        if(n ==0){
            return 0;
        }
        if(n == 1){
            return 1;

        }
        if(n == 2){
            return 2;

        }
        return (n*(n-1))>>1;

    }
    /**
     * 69. x 的平方根
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     *
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：x = 4
     * 输出：2
     * 示例 2：
     *
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     */

    public int mySqrt(int x) {
        int s = 0;
        while (true){
            if(s * s == x || (s*s <x &&( (s+1) * (s+1) )> x)  ){
                return s;
            }
            s++;
        }
    }
    /**
     * 67. 二进制求和
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     *
     *
     *
     * 示例 1:
     *
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    public String addBinary(String a, String b) {
        // 存在超出integer.max的场景
        int ai = 0;
        char[] aChars = a.toCharArray();
        for (int i = aChars.length -1; i >=0; i--) {
            ai += Integer.parseInt(aChars[i]+"") *(int)Math.pow(2,aChars.length-i-1);
        }

        int bi = 0;
        char[] bChars = b.toCharArray();
        for (int i = bChars.length -1; i >=0; i--) {
            bi += Integer.parseInt(bChars[i]+"")*  (int)Math.pow(2,bChars.length-i-1);
        }

        return Integer.toBinaryString(bi + ai);

    }

    public String addBinary2(String a, String b){
        StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    /**
     * 66. 加一
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length -1; i >= 0; i--) {
            if(digits[i]+1 <= 9){
                digits[i] ++ ;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int[] ints = new int[digits.length+1];
        ints[0] = 1;
        return ints;


    }
    /**
     * 58. 最后一个单词的长度
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     */

    public int lengthOfLastWord(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }
        String[] ss = s.split(" ");
        return ss[ss.length-1].length();
    }

    public int lengthOfLastWord2(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
    /**
     * 53. 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组 是数组中的一个连续部分。
     */
    public  int maxSubArray(int[] nums) {
        // 暴力解法
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = 0;
        boolean init = true;
        for (int i = 0; i < nums.length; i++) {
            int subSum = 0;
            for (int j = i; j < nums.length; j++) {
                subSum += nums[j];
                if (subSum > max || init) {
                    init = false;
                    max = subSum;
                }
            }
        }

        return max;
    }


    public static int maxSubArray2(int[] nums) {
        //动态规划
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public  int maxSubArray3(int[] nums) {
        // 分治
        return getInfo(nums, 0, nums.length - 1).mSum;
    }
    class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }
    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }


    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     */
    public static int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 28. 实现 strStr()
     * 实现 strStr() 函数。
     * <p>
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
     * <p>
     * 说明：
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.equals("") || needle == null || needle.equals("") || haystack.length() < needle.length()) {


            return -1;
        }
        char[] needles = needle.toCharArray();
        char[] haystacks = haystack.toCharArray();
        int haIndex = 0;
        int neIndex = 0;
        boolean flag = true;
        while (haIndex < haystacks.length && neIndex < needles.length) {
            if (haystacks[haIndex] == needles[neIndex]) {
                neIndex++;
                flag = true;
            } else {
                flag = false;
                haIndex = haIndex - neIndex;
                neIndex = 0;
            }
            haIndex++;
        }
        if (flag && neIndex - 1 == needles.length - 1) {
            return haIndex - neIndex;
        } else {
            return -1;
        }
    }

    /**
     * 27. 移除元素
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        int i = 0;
        int j = 0;
        while (j < nums.length) {

            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

    /**
     * 26. 删除有序数组中的重复项
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * <p>
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
     * <p>
     * 将最终结果插入 nums 的前 k 个位置后返回 k 。
     * <p>
     * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int index = 0;
        int maxNum = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] || nums[i] > maxNum) {
                maxNum = nums[i + 1];
                index++;
                nums[index] = nums[i + 1];
            }
        }
        for (int i = index + 1; i < nums.length; i++) {
            nums[i] = 0;
        }

        return index + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        // 使用双指针
        if (nums == null || nums.length == 1) {
            return nums.length;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * /**
     * * Definition for singly-linked list.
     * * public class ListNode {
     * *     int val;
     * *     ListNode next;
     * *     ListNode() {}
     * *     ListNode(int val) { this.val = val; }
     * *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * * }
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }


    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
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

    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }

    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     */
    public static int romanToInt(String s) {

        Map<Character, Integer> integerMap = new HashMap<>(8);
        integerMap.put('I', 1);
        integerMap.put('V', 5);
        integerMap.put('X', 10);
        integerMap.put('L', 50);
        integerMap.put('C', 100);
        integerMap.put('D', 500);
        integerMap.put('M', 1000);
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return integerMap.get(chars[0]);
        }
        int result = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (integerMap.get(chars[i]) >= integerMap.get(chars[i + 1])) {
                result += integerMap.get(chars[i]);
            } else {
                result = result + integerMap.get(chars[i + 1]) - integerMap.get(chars[i]);
                i++;
            }
        }
        if (integerMap.get(chars[chars.length - 2]) >= integerMap.get(chars[chars.length - 1])) {
            result += integerMap.get(chars[chars.length - 1]);
        }

        return result;
    }

    /**
     * 9. 回文数
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * <p>
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    public static boolean isPalindrome(int x) {
        String xs = String.valueOf(x);
        byte[] bytes = xs.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != bytes[bytes.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexes[0] = i;
                indexes[1] = hash.get(nums[i]);
                return indexes;
            }
            hash.put(target - nums[i], i);
        }
        return indexes;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        ListNode n = this;
        while (n != null) {

            a.append(n.val);
            n = n.next;
        }

        return String.join(",", a.toString());
    }
}
