package com.fangjian.zhenbao.base.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;


public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    // 声明一个缓存接口，这个接口是Shiro缓存管理的一部分，它的具体实现可以通过外部容器注入
    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();

        //retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
            //passwordRetryCache.remove(username);
        }
        // 自定义一个验证过程：当用户连续输入密码错误5次以上禁止用户登录一段时间
        if (retryCount.incrementAndGet() > 5) {
            //if retry count > 5 throw
            //passwordRetryCache.remove(username);
            throw new ExcessiveAttemptsException();
        }
        //可以看到，这个实现里设计人员仅仅是增加了一个不允许连续错误登录的判断。真正匹配的过程还是交给它的直接父类去完成。连续登录错误的判断依靠Ehcache缓存来实现。显然match返回true为匹配成功。
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            //clear retry count
            passwordRetryCache.remove(username);
        } else {
            Object p1 = token.getCredentials();
            String p2 = info.getCredentials().toString();

            char[] p1char = (char[]) p1;
            String p1s = new String(p1char);

            boolean matches2 = p1s.equals(p2);
            if (matches2) {
                passwordRetryCache.remove(username);
                return matches2;
            }
        }
        return matches;
    }
}
