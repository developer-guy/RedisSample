package org.redis.base;

import redis.clients.jedis.Jedis;

/**
 * Created by bapaydin on 29.09.2016.
 */
public interface RedisProperties {
    String host = "localhost";
    int port = 6379;
    Jedis buildClient();
}
