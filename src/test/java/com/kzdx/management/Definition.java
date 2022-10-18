package com.kzdx.management;

import java.util.Scanner;

public class Definition {

        public static void main(String[] args) {
            System.out.println("请输入两个非零整数：");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("这两个整数的最大公约数为："+ definition(a,b));
        }
        public static int definition(int num1, int num2) {
            int res=0;
            if (num1 > num2)
                res = num2;
            else
                res = num1;
            while(true) {
                if (num1%res == 0 && num2%res == 0)
                    break;
                else
                    res = res - 1;
            }
            return res;
        }

    }

