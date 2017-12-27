package com.ylc;

import com.ylc.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author: tree
 * @version: 1.0
 * date: 2017/12/27 20:32
 * @description: xxx
 * own: Aratek
 */
public class PersonItemProcessor implements ItemProcessor<Person,Person> {

    private static Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }
}
