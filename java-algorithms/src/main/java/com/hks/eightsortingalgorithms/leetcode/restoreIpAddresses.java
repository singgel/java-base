package com.hks.eightsortingalgorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class restoreIpAddresses {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        //这里就是对字符串的预处理，但是对于测试用例来说我觉得用处不大，毕竟不会蠢到用13位数字让你分割
        if(s.length()<4||s.length()>12) {
            return res;
        }
        //这里就是套用最经典的回溯模板了，相比于分割字符串只加入分割线一个参数以外，这里还需要添加额外的层数参数level
        //因为合法的IP地址只有四段，我们不能无限对其进行分割
        backtracking(s, 0, 0);
        return res;
    }
    void backtracking(String s, int start, int level) {
        if(level==4) {
            res.add(String.join(".", path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(s.length()-(start+1) > 3*(3-level)){
                continue;
            }
            if(!validStrIP(s.substring(start,i+1))){
                continue;
            }
            path.add(s.substring(start,i+1));
            backtracking(s,start+1,level+1);
            path.remove(path.size()-1);
        }
    }

    boolean validStrIP(String s) {
        if(s.charAt(0)=='0'&&s.length()>1) {
            return false;
        }
        if(s.length()>3){
            return false;
        }
        if(Integer.valueOf(s)>255){
            return false;
        }
        return true;
    }

    /*void backtracking(String s, int splitIndex, int level) {
        //递归终止条件，分割的四个字符串都是合法的IP地址
        if (level == 4) {
            //在代码的最后再利用join函数加上“.”,构造IP地址的表示形式
            res.add(String.join(".", path));
            return;
        }
        for (int i = splitIndex; i < s.length(); i++) {
            //每一次分割之后，对剩余字符长度是否合理进行判断，剪枝操作，优化运行速度
            if ((s.length() - (i + 1)) > 3 * (3 - level)) {
                continue;
            }
            //如果分割的字符串不是合理的IP地址，跳过
            if (!isValidIp(s.substring(splitIndex, i + 1))) {
                continue;
            }
            //把合法的IP地址段加入path存储
            path.add(s.substring(splitIndex, i + 1));
            //每次把分割线往后移一位，且段数level+1
            backtracking(s, i + 1, level + 1);
            //进行回溯操作
            path.remove(path.size() - 1);
        }
    }

    // 判断分割出来的每一段字符串是否是合法的IP地址
    boolean isValidIp(String s) {
        //判断其是否含有前导0
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        //长度为4就直接舍弃，加上这一步是为了后面parseInt做准备,防止超过了Integer可以表示的整数范围
        if (s.length() > 3) {
            return false;
        }
        //将字符转为int判断是否大于255，因为题目明确说了只由数字组成，所以这里没有对非数字的字符进行判断
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }*/
}
