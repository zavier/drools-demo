package com.rules;

import com.pojo.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RuleAccumulate {

    @Test
    public void testAccumulate() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession ks = kieClasspathContainer.newKieSession("isAccumulate");
        {
            Person person = new Person();
            person.setName("张三");
            person.setAge(50);
            ks.insert(person);
        }
        {
            Person person = new Person();
            person.setName("李四");
            person.setAge(20);
            ks.insert(person);
        }
        {
            Person person = new Person();
            person.setName("王五");
            person.setAge(24);
            ks.insert(person);
        }
        {
            Person person = new Person();
            person.setName("赵六");
            person.setAge(15);
            ks.insert(person);
        }

        int count = ks.fireAllRules();
        System.out.println("总共执行了：" + count + "条规则");
        ks.dispose();
    }


    @Test
    public void testAccumulate1() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession ks = kieClasspathContainer.newKieSession("isAccumulate");
        {
            Person person = new Person();
            person.setName("张三");
            person.setAge(50);
            person.setDous(5.0);
            ks.insert(person);
        }
        {
            Person person = new Person();
            person.setName("李四");
            person.setAge(20);
            ks.insert(person);
        }
        {
            Person person = new Person();
            person.setName("王五");
            person.setAge(24);
            ks.insert(person);
        }
        {
            Person person = new Person();
            person.setName("赵六");
            person.setAge(15);
            ks.insert(person);
        }

        int count = ks.fireAllRules();
        System.out.println("总共执行了：" + count + "条规则");
        ks.dispose();
    }
}
