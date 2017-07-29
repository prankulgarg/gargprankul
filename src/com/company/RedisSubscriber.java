package com.company;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cgc6679 on 7/29/2017.
 */
public class RedisSubscriber {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        List<String> recievedMessages=new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the channel name:");
        String channel = scanner.nextLine();
        System.out.println("Starting subscriber for channel " + channel);

        while (true) {
            JedisPubSub jedisPubSub = new JedisPubSub() {
                @Override
                public void onUnsubscribe(String channel, int subscribedChannels) {
                }

                @Override
                public void onSubscribe(String channel, int subscribedChannels) {
                }

                @Override
                public void onPUnsubscribe(String pattern, int subscribedChannels) {
                }

                @Override
                public void onPSubscribe(String pattern, int subscribedChannels) {
                }

                @Override
                public void onPMessage(String pattern, String channel, String message) {
                }

                @Override
                public void onMessage(String channel, String message) {
                    System.out.println(message);
                }
            };
            jedis.subscribe(jedisPubSub, channel);




        }

    }

}