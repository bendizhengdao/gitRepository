package com.ssm.inter;

/**
 * 发布接口
 * @author interface
 *
 */
public interface Publisher {
    
    void publish(String channel, String message);
}
