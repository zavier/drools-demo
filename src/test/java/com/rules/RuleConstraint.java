package com.rules;

import com.pojo.Person;
import com.pojo.School;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Arrays;

public class RuleConstraint {

    @Test
    public void contains() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kc = kieServices.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("testhellowrold");

        Person person = new Person();
        person.setName("张三");
        person.setAge(30);
        person.setClassName("一班");

        School school = new School();
        school.setClassName("一班");

        ks.insert(person);
        ks.insert(school);
        int count = ks.fireAllRules();
        System.out.println("共执行了" + count + "条规则");
        ks.dispose();
    }

    @Test
    public void memberOfArray() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kc = kieServices.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("testhellowrold");

        Person person = new Person();
        person.setName("张三");
        person.setAge(30);
        person.setClassName("一班");

        School school = new School();
        school.setClassNameArray(Arrays.asList("一班", "二班", "三班"));

        ks.insert(person);
        ks.insert(school);
        int count = ks.fireAllRules();
        System.out.println("共执行了" + count + "条规则");
        ks.dispose();
    }
}
