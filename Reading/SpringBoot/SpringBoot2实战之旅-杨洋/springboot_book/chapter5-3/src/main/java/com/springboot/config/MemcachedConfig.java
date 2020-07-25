package com.springboot.config;

import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;


@Component
public class MemcachedConfig implements CommandLineRunner {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Value("${memcache.ip}")
    private String memcacheIp;

    @Value("${memcache.port}")
    private Integer memcachePort;

    private MemcachedClient client = null;

    @Override
    public void run(String... args) throws Exception {
        try {
            client = new MemcachedClient(new InetSocketAddress(memcacheIp,memcachePort));
        } catch (IOException e) {
            logger.error("Connection to server failed",e);
        }
        logger.info("Connection to server success");
    }

    public MemcachedClient getClient() {
        return client;
    }


    public Boolean set(String key,int time,String value) {
        Boolean b = false;
        try{
            b=(this.getClient().set(key, time, value)).get();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return b;
    }

    public Boolean add(String key,int time,String value){
        Boolean b = false;
        try{
            b=(this.getClient().add(key, time, value)).get();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return b;
    }

    public Object replace(String key,int time,String value){
        Boolean b = false;
        try{
            b=(this.getClient().replace(key, time, value)).get();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return b;
    }

    public Object append(String key,int time,String value){
        Boolean b = false;
        try{
            b=(this.getClient().append(key, value)).get();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return b;
    }

    public Object prepend(String key,int time,String value){
        Boolean b = false;
        try{
            b=(this.getClient().prepend(key, value)).get();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return b;
    }

    public Object cas(String key,int time,String value){
        return this.getClient().cas(key, time, value);
    }

    public Object get(String key){
        return this.getClient().get(key);
    }

    public Boolean delete(String key){
        Boolean b = false;
        try{
            b=(this.getClient().delete(key)).get();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return b;
    }

    public long incr(String key,Integer value){
        return this.getClient().incr(key,value);
    }

    public long decr(String key,Integer value){
        return this.getClient().decr(key,value);
    }

}
