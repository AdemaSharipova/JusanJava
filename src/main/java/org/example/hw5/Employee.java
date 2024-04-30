package org.example.hw5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phoneNumber);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age + " \n");
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Victor", "Programmer", "victor@inbox.run", "1231343", 50000, 45);
        employees[2] = new Employee("Adema", "Programmer", "adema@inbox.run", "2312313", 45000, 47);
        employees[3] = new Employee("Misha", "Programmer", "misha@inbox.run", "1232144", 49000, 32);
        employees[4] = new Employee("Ayan", "Programmer", "ayan@inbox.run", "123421233", 200000, 21);

        for (Employee employee : employees) {
            if (employee.age >= 40) {
                employee.printInfo();
            }
        }
    }
}

