package org.redis.client;

import org.redis.base.RedisProperties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.logging.Logger;

/**
 * Created by bapaydin on 29.09.2016.
 */
public class RedisClient implements RedisProperties{
    protected static Jedis jedis ;
    protected static Logger logger = Logger.getLogger(RedisClient.class.getName());

    public Jedis buildClient() {
        jedis = new Jedis(host,port);
        logger.info("Redis client successfully initialized");
        return jedis;
    }
}
