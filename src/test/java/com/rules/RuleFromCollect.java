package com.rules;

import com.pojo.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RuleFromCollect {

    @Test
    public void testFromCollect() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession ks = kieClasspathContainer.newKieSession("isCollect");

        {
            Person person = new Person();
            person.setName("张三");
            person.setClassName("一班");
            ks.insert(person);
        }

        {
            Person person = new Person();
            person.setName("李四");
            person.setClassName("一班");
            ks.insert(person);
        }

        {
            Person person = new Person();
            person.setName("王五");
            person.setClassName("二班");
            ks.insert(person);
        }

        {
            Person person = new Person();
            person.setName("赵六");
            person.setClassName("一班");
            ks.insert(person);
        }

        int count = ks.fireAllRules();
        System.out.println("总共执行了:" + count + "条规则");
        ks.dispose();
    }
}
