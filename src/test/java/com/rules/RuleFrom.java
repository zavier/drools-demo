package com.rules;

import com.pojo.Person;
import com.pojo.School;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RuleFrom {

    @Test
    public void testFrom() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession ks = kieClasspathContainer.newKieSession("isFrom");

        Person person = new Person();
        person.setAge(30);
        person.setName("张三");
        School school = new School();
        school.setClassName("一班");
        person.setSchool(school);
        ks.insert(person);

        School school1 = new School();
        school1.setClassName("二班");
        ks.insert(school);

        int count = ks.fireAllRules();
        System.out.println("总共执行了" + count + "条规则");
        ks.dispose();

    }
}
