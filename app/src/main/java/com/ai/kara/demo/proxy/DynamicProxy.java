package com.ai.kara.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhouliang on 2017/7/12.
 */

public class DynamicProxy implements InvocationHandler {
    Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * 覆盖InvocationHandler接口中的invoke()方法
     * 更重要的是，动态代理模式可以使得我们在不改变原来已有的代码结构
     * 的情况下，对原来的“真实方法”进行扩展、增强其功能，并且可以达到
     * 控制被代理对象的行为，下面的before、after就是我们可以进行特殊
     * 代码切入的扩展点了。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * before ：doSomething();
         */
        Object result = method.invoke(this.obj, args);

        /**
         * after : doSomething();
         */
        return result;
    }
}
