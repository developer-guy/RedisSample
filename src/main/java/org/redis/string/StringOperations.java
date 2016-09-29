package org.redis.string;

import org.redis.client.RedisClient;
import redis.clients.jedis.Jedis;

/**
 * Created by bapaydin on 29.09.2016.
 */
public class StringOperations {
    public static void main(String[] args) {
        RedisClient redisClient = new RedisClient();
        Jedis jedis = redisClient.buildClient();
        jedis.set("server:name", "fido");
        System.out.println(jedis.get("server:name"));

        String result = jedis.set("connections", "10");
        Long connections = jedis.incr("connections");
        System.out.println("Connections :" + connections);

        jedis.set("resource:lock","Redis demo");
        jedis.expire("resource:lock",120);

        for(int i = 0 ;  i < 1000000 ; i++){
            if(i % 5 == 0){
                Long ttl = jedis.ttl("resource:lock");
                System.out.println("Recent time : " + ttl);
            }
        }
    }
}
