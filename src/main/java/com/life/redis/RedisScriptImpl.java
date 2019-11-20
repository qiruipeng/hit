package com.life.redis;

import org.springframework.data.redis.core.script.RedisScript;

/** 脚本类实现
 * @author: qirp
 * @since: 2019/11/19 15:17
 **/
public class RedisScriptImpl implements RedisScript {

    /**
     * 执行脚本
     */
    private final String script;

    /**
     * 脚本摘要
     */
    private final String sha1 = null;

    /**
     * 返回类型类
     */
    private final Class resultType;

    public RedisScriptImpl(String script, Class resultType) {
        this.script = script;
        this.resultType = resultType;
    }

    @Override
    public String getSha1() {
        return sha1;
    }

    @Override
    public Class getResultType() {
        return resultType;
    }

    @Override
    public String getScriptAsString() {
        return script;
    }
}
