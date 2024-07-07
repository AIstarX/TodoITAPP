package se.lexicon;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Users appUser1 = new Users("eriksv", "password123", Roles.ROLE_APP_USER);
        Person person1 = new Person(1, "Erik", "Svensson", "erik.svensson@gmail.com", appUser1);
        System.out.println("Person created: " + person1);

        TodoItem todoItem1 = new TodoItem(1, "Change tires", "Change the car tires before winter", LocalDate.of(2024, 12, 1), false, person1);
        System.out.println("TodoItem created: " + todoItem1);

        System.out.println("Is TodoItem overdue? " + todoItem1.isOverdue());

        TodoItemTask task1 = new TodoItemTask(1, todoItem1, person1);
        System.out.println("TodoItemTask created: " + task1);

        todoItem1.setDone(true);
        System.out.println("TodoItem updated: " + todoItem1);
    }
}
