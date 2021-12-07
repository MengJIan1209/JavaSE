package com.meng.Struct;

public class ForDemo {

        public static void main(String[] args){

                //输出0-100的奇数偶数的和

                int Jisum = 0;
                int Ousum = 0;
            for (int i=0;i<=100;i++){
                if(i%2!=0){
                    Jisum+=i;
                }else{
                    Ousum+=i;
                }
            }
            System.out.println("偶数的和为："+Ousum);
            System.out.println("奇数的和为："+Jisum);

           /*
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 100; i++) {


                sum1 = i+2;
                sum1+=i;
                sum2 = i+1;
                sum2+=i;
            }
            System.out.println("偶数的和为："+sum1);
            System.out.println("奇数的和为："+sum2);
            */


        }

}
