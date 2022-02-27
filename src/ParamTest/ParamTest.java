package ParamTest;

/**
 * Ten program demonstruje przekazanie parametrów w Javie.
 * This program demonstrates parameter passing in Java.
 * @author Tomek
 *
 */
public class ParamTest {

    public static void main(String[] args) {
        /*
         * Test 1. Metody nie mogą modyfikować parametrów liczbowych.
         * Test 1. Methods cannot modify numeric parameters.
         */
        System.out.println("Testowanie tripleValue: ");
        double percent = 10;
        System.out.println("Przed: percent = " + percent);
        tripleValue(percent);
        System.out.println("Po: percent = " + percent);

        /*
         * Test 2. Metody mogą zmieniać stan parametrów będących obiektami.
         * Test 2. Methods can change the state of parameters that are objects.
         */
        System.out.println("\nTestowanie tripleSalary: ");
        var harry = new Employee("Grzegorz", 50000);
        System.out.println("Przed: Salary = " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("Po: Salary = " + harry.getSalary());

        /*
         * Test 3. Metody nie mogą dodawać nowych obiektów do parametrów obiektowych.
         * Test 3. Methods cannot add new objects to object parameters.
         */
        System.out.println("\nTestowanie swap:");
        var a = new Employee("Alicja", 70000);
        var b = new Employee("Grzegorz", 60000);
        System.out.println("Przed: a = " + a.getName());
        System.out.println("Przed: b = " + b.getName());
        swap(a,b);
        System.out.println("Po: a = " + a.getName());
        System.out.println("Po: b = " + b.getName());
    }

    public static void tripleValue(double x) {	//Nie działa
        x = 3 * x;
        System.out.println("Koniec metody: x =" + x);
    }

    public static void tripleSalary(Employee x) {	//działa
        x.raiseSalary(200);
        System.out.println("Koniec metody: salary = " + x.getSalary());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("Koniec metody: x = " + x.getName());
        System.out.println("Koniec metody: y = " + y.getName());
    }

}

class Employee {	//Uproszczona klasa Employee.
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary  += raise;
    }
}