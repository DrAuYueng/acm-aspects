package aop.client;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.beans.IFoo;

public class Client {

    private Map<Object, Object> map;

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return map.toString();
    }

    public static void main(String[] args) {
        // 获取 Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
        IFoo foo = (IFoo) context.getBean("foo");
        double result = foo.power(3, 3);
        System.out.println(result);
        try {
            Thread.sleep(50000l);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block

        }
        // double result = foo.power(3, 3);
        // Map<Object, Object> map = new HashMap<Object, Object>();
        // map.put("testkey", "testvalue");
        // Client c = new Client();
        // c.setMap(map);
        // foo.power2(c, null);
        // foo.toString();
    }
}
