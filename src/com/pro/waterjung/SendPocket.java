package com.pro.waterjung;
import javax.swing.*;
import java.util.*;
//斗地主发牌
public class SendPocket {
    public static void main(String[] args) {
        //买牌
        Map<Integer,String> pockers = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        String [] colors = {"♦", "♣", "♥", "♠"};
        String [] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        int num = 0;
        for (String number : numbers) {
            for (String color : colors) {
                String pocker = color +number;
                pockers.put(num,pocker);
                list.add(num);
                num++;
               // System.out.println(pocker);

            }

        }
        pockers.put(num,"小王");
        list.add(num++);
        pockers.put(num,"大王");
        list.add(num);
        System.out.println("所有的牌："+pockers);
        System.out.println("牌的编号："+list);


        //洗牌
        Collections.shuffle(list);
        System.out.println("洗好牌后，编号为"+list);

        //发牌
        //3.1 定义四个集合，表示3个玩家和底牌
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        List<Integer> player3 = new ArrayList<>();
        List<Integer> dipai = new ArrayList<>();
        //3.2  具体发牌动作，将索引和3取模，决定发给谁
        for (int i = 0; i <list.size() ; i++) {
            //获取编号
            Integer pockerNum = list.get(i);

            if (i >= list.size() - 3) {
                dipai.add(pockerNum);
            }else if (i % 3==0) {
                player1.add(pockerNum);
            }else if (i % 3==1) {
                player2.add(pockerNum);
            }else if (i % 3==2) {
                player3.add(pockerNum);
            }
        }


        //3.3 查看玩家，底牌的编号
       /*// System.out.println("player1"+player1);
        System.out.println("player2"+player2);
        System.out.println("player3"+player3);
        System.out.println("dipai"+dipai);
        */

        System.out.println("player1"+printPocker(player1,pockers));
        System.out.println("player2"+printPocker(player2,pockers));
        System.out.println("player3"+printPocker(player3,pockers));
        System.out.println("dipai"+printPocker(dipai,pockers));
    }
    public static String printPocker(List<Integer> nums,Map<Integer,String> pockers){
        Collections.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            String pocker = pockers.get(num);
            sb.append(pocker + " ");
        }
         String str =  sb.toString();
        return str.trim();
        }
}


