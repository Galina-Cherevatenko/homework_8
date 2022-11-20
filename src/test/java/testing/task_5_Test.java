package testing;

import org.example.homework_5.Person;
import org.example.homework_5.Repository;
import org.example.homework_5.Service;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class task_5_Test {
    private Repository repository = Mockito.mock(Repository.class);
    private Service service = new Service(repository);
    @Test
    public void findPersonByNameTest (){
        String stringForSearch = "Петр";
        List<String> email = Arrays.asList("mail1", "mail2");
        Person person1 = new Person("12345", "Петр", "Петров", "Москва", email);
        Person person2 = new Person("456", "Петр", "Иванов", "Москва", email);
        List<Person> expectedList = Arrays.asList(person1, person2);
        when(repository.findName(stringForSearch)).thenReturn(expectedList);
        //when
        List<Person> actualResult = service.findPersonNamePhoneEmail (1, stringForSearch);

        // then
        assertTrue(expectedList.size()==actualResult.size() && expectedList.containsAll(actualResult) && actualResult.containsAll(expectedList));
        verify(repository,times(1)).findName(stringForSearch);

    }
    @Test
    public void findPersonByPhoneTest (){
        String stringForSearch = "12345";
        List<String> email = Arrays.asList("mail1", "mail2");
        Person person1 = new Person("12345", "Петр", "Петров", "Москва", email);
        List<Person> expectedList = new ArrayList<>();;
        when(repository.findPhone(stringForSearch)).thenReturn(person1);
        expectedList.add(person1);

        //when
        List<Person> actualResult = service.findPersonNamePhoneEmail (2, stringForSearch);

        // then
        assertTrue(expectedList.size()==actualResult.size() && expectedList.containsAll(actualResult) && actualResult.containsAll(expectedList));
        verify(repository,times(1)).findPhone(stringForSearch);

    }
    @Test
    public void findPersonByEmailTest (){
        String stringForSearch = "mail1";
        List<String> email = Arrays.asList("mail1", "mail2");
        Person person1 = new Person("12345", "Петр", "Петров", "Москва", email);
        List<Person> expectedList = new ArrayList<>();;
        when(repository.findEmail(stringForSearch)).thenReturn(person1);
        expectedList.add(person1);

        //when
        List<Person> actualResult = service.findPersonNamePhoneEmail (3, stringForSearch);

        // then
        assertTrue(expectedList.size()==actualResult.size() && expectedList.containsAll(actualResult) && actualResult.containsAll(expectedList));
        verify(repository,times(1)).findEmail(stringForSearch);

    }
}
