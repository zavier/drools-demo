package com.rules;

import com.pojo.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RulesHello {

    @Test
    public void test() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kc = kieServices.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("testhellowrold");

        Person person = new Person();
        person.setName("张三");
        person.setAge(30);
        ks.insert(person);

        int count = ks.fireAllRules();
        System.out.println("总共执行了" + count + "条规则");
        ks.dispose();
    }
}
