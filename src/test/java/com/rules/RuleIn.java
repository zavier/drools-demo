package com.rules;

import com.pojo.Person;
import com.pojo.School;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RuleIn {

    @Test
    public void testIn() {
        KieServices ks = KieServices.Factory.get();
        KieContainer container = ks.getKieClasspathContainer();
        KieSession session = container.newKieSession("isIn");

        Person person = new Person();
        person.setClassName("三班");
        session.insert(person);

        School school = new School();
        school.setClassName("三班");
        session.insert(school);

        Person person2 = new Person();
        person2.setClassName("四班");
        session.insert(person2);

        int count = session.fireAllRules();
        System.out.println("共执行了" + count + "条规则" );

        session.dispose();
    }

}
