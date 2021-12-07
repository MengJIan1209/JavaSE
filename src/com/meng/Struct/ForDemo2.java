package com.meng.Struct;

public class ForDemo2 {

        public static void main(String[] args){

            //用while或者for循环输出1-1000能被5整除的数 并且每行输出三个


            for (int i = 0; i <=1000; i++) {
                if(i%5==0){
                    //sum=i;
                    System.out.print(i+"\t");
                }
                if(i%(5*3)==0)
                    System.out.print("\n");
            }
            System.out.println();
            System.out.println("================================");
            //println 输出完成换行
            //print   输出完成不换行


            int sum = 0;
            while(sum<=1000){
                  sum++;
                if(sum%5==0){
                    System.out.print(sum+"\t");
                }
                if(sum%(5*3)==0){
                    System.out.println();
                }

            }
            System.out.println();
            System.out.println("================================");

            int no = 0;
            do{
                no++;
                //System.out.println(no);
                if(no%5==0){
                    System.out.print(no+"\t");
                }
                if(no%(5*3)==0){
                    System.out.println();
                }

            }while(no<1000);

        }

}
