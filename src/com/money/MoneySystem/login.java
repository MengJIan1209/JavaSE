package com.money.MoneySystem;

import java.util.Scanner;

public class login {

    public static void main(String[] args){

/*
        System.out.println("----------家庭收支记账软件----------");
        System.out.println();
        System.out.println("           1.收支明细              ");
        System.out.println("           2.登记收入              ");
        System.out.println("           3.登记支出              ");
        System.out.println("           4.退   出              ");
        System.out.println();

        System.out.println("请选择<1-4> :");
        Scanner scan = new Scanner(System.in);
      if (scan.hasNextInt()){



            System.out.println("----------家庭收支记账软件----------");
            System.out.println();
            System.out.println("           1.收支明细              ");
            System.out.println("           2.登记收入              ");
            System.out.println("           3.登记支出              ");
            System.out.println("           4.退   出              ");
            System.out.println();
        }

*/


        //初始金额
        int balance = 1000;


        boolean isflag = true;
        String details = "";

        while (isflag){
           System.out.println("---------------家庭收支记账软件---------------");
           System.out.println();
           System.out.println("                1.收支明细              ");
           System.out.println("                2.登记收入              ");
           System.out.println("                3.登记支出              ");
           System.out.println("                4.退   出              ");
           System.out.println();
           System.out.print("                请选择<1-4> :");

           char c = Utility.readMenuselection();

           switch (c){
               case '1':
                   //System.out.println("1.收支明细");

                   System.out.println("------------当前收支明细--------------");
                   System.out.println("收支\t账户金额\t收支金额\t说  明\n");
                   System.out.println(details);
                   System.out.println("------------------------------------");

                   break;
               case '2':
                   //System.out.println("2.登记收入");

                   System.out.print("本次收入金额：");
                   int addMoney = Utility.readNumber();
                   System.out.print("本次收入说明");
                   String addInfo = Utility.readString();

                   //处理balance
                   balance+=addMoney;

                   //Details说明
                   details+= ("收入\t"+balance+"\t"+"收支金额"+addMoney+"\t"+addInfo+"\n");

                   System.out.println("------------登记完成--------------\n");
                   break;
               case '3':
                   //System.out.println("3.登记支出 ");
                   System.out.print("本次支出金额：");
                   int outMoney=Utility.readNumber();
                   System.out.println("本次指出说明：");
                   String outInfo = Utility.readString();
                   //处理balance
                   if (balance <= outMoney){
                       balance-=outMoney;
                       //处理details
                       details+= ("支出\t"+balance+"\t\t"+"收支金额"+outMoney+"\t\t "+outInfo+"\n");
                   }else{
                       System.out.println("支付失败，是否使用花呗支付");
                   }


                   System.out.println("------------登记完成--------------\n");
                   break;
               case '4':
                   System.out.println("是否确认退出(Y/N)");
                   char isExit = Utility.readConfirmSelection();
                   if (isExit == 'Y'){
                       isflag = false;
                   }

                   break;
           }

        }





    }

}
