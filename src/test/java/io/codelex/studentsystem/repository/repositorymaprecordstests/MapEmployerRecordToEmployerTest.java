package io.codelex.studentsystem.repository.repositorymaprecordstests;

import io.codelex.studentsystem.api.Employer;
import io.codelex.studentsystem.repository.model.maprecord.MapEmployerRecordToEmployer;
import io.codelex.studentsystem.repository.model.employer.EmployerRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapEmployerRecordToEmployerTest {
    private MapEmployerRecordToEmployer mapEmployerRecordToEmployer = new MapEmployerRecordToEmployer();

    @Test
    void apply() {
        //given
        EmployerRecord record = new EmployerRecord();
        record.setId(1L);
        record.setName("Janis");
        record.setCompany("Microsoft");
        record.setEmail("dwd@gmail.com");
        record.setLogin("hhjhjh233");
        record.setPhone("+3712782222");
        record.setPassword("efwefwef");
        //when
        Employer employer = mapEmployerRecordToEmployer.apply(record);
        //then
        Assertions.assertEquals(employer.getId(), 1L);
        Assertions.assertEquals(employer.getCompany(), "Microsoft");
        Assertions.assertEquals(employer.getPerson().getEmail(), "dwd@gmail.com");
        Assertions.assertEquals(employer.getLogin(), "hhjhjh233");
        Assertions.assertEquals(employer.getPerson().getPhone(), "+3712782222");
        Assertions.assertEquals(employer.getPassword(), "efwefwef");
        Assertions.assertEquals(employer.getPerson().getName(), "Janis");
    }
}
