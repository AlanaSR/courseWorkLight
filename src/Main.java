public class Main {
    public static Employee addEmployee(String name, String department, int salary) {
        Employee employee = new Employee(name, department, salary);
        return employee;
    }

    public static Employee[] employees = new Employee[10];

    public static double sumSalary() {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public static double minSalary() {
        double minSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            final double salary = employees[i].getSalary();
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
            }
        }
        return minSalary;
    }

    public static double maxSalary() {
        double maxSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            final double salary = employees[i].getSalary();
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
            }
        }
        return maxSalary;
    }

    public static double midSalary() {
        double midSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            midSalary = sumSalary() / employees.length;
        }
        return midSalary;
    }

    public static void printNamesEmployees() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getName());
        }
    }

    public static void main(String[] args) {

        employees[0] = addEmployee("Скрягин Владимир Иванович", "2", 14825);
        employees[1] = addEmployee("Засранкина Алиса Святославовна", "1", 45656);
        employees[2] = addEmployee("Чистоплюев Максим Игоревич", "5", 78255);
        employees[3] = new Employee("Незнайкина Алина Петровна", "4", 48156);
        employees[4] = new Employee("Страдалкина Светлана Александровна", "3", 37853);
        employees[5] = new Employee("Капризулькина Никандра Филипповна", "2", 57399);
        employees[6] = new Employee("Вреднюкин Павел Николаевич", "1", 52458);
        employees[7] = new Employee("Хулиганкин Артем Демьянович", "5", 78545);
        employees[8] = new Employee("Засыпалкина Софья Андреевна", "5", 95445);
        employees[9] = new Employee("Приставалкин Андрей Сергеевич", "5", 32453);

        int i;
        for (i = 0; i < employees.length; i++) ;
        System.out.println(employees[i]);
        System.out.println();

        System.out.println("Сумма затрат на ЗП сотрудников " + sumSalary());
        System.out.println("Минимальная зарабодная плата составляет " + minSalary() + " рублей.");
        System.out.println("Максимальная зарабодная плата составляет " + maxSalary() + " рублей.");
        System.out.println("Средняя зарабодная плата составляет " + midSalary() + " рублей.");
        System.out.println();
        printNamesEmployees();
    }


}


