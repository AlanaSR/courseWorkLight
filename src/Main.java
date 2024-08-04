public class Main {
    public static Employee addEmployee(String name, int department, int salary) {
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

    public static void printEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {

        employees[0] = addEmployee("Скрягин Владимир Иванович", 2, 14825);
        employees[1] = addEmployee("Засранкина Алиса Святославовна", 1, 45656);
        employees[2] = addEmployee("Чистоплюев Максим Игоревич", 5, 78255);
        employees[3] = new Employee("Незнайкина Алина Петровна", 4, 48156);
        employees[4] = new Employee("Страдалкина Светлана Александровна", 3, 37853);
        employees[5] = new Employee("Капризулькина Никандра Филипповна", 2, 57399);
        employees[6] = new Employee("Вреднюкин Павел Николаевич", 1, 52458);
        employees[7] = new Employee("Хулиганкин Артем Демьянович", 5, 78545);
        employees[8] = new Employee("Засыпалкина Софья Андреевна", 4, 95445);
        employees[9] = new Employee("Приставалкин Андрей Сергеевич", 3, 32453);

        printEmployee();
        System.out.println();

        System.out.println("Сумма затрат на ЗП сотрудников " + sumSalary());
        System.out.println("Минимальная зарабодная плата составляет " + minSalary() + " рублей.");
        System.out.println("Максимальная зарабодная плата составляет " + maxSalary() + " рублей.");
        System.out.println("Средняя зарабодная плата составляет " + midSalary() + " рублей.");
        System.out.println();
        printNamesEmployees();
        System.out.println();

        int department = 3;
        double indexation = 10;
        System.out.println("Минимальная зарабодная плата в отделе " + department + " составляет " + employeeWithMinSalary(department));
        System.out.println("Максимальная зарабодная плата в отделе " + department + " составляет " + employeeWithMaxSalary(department));
        System.out.println("Сумма затрат на ЗП сотрудников в отделе " + department + " составляет " + departmentSumSalary(department) + " рублей.");
        System.out.println("Средняя зарабодная плата в отделе " + department + " составляет " + departmentMidSalary(department) + " рублей.");
        System.out.println();
        salaryIndexation(indexation);
        printEmployee();
        System.out.println();
        salaryIndexationForDepart(department, indexation);
        printEmployee();
        printEmployeeWithoutDepartment(department);
        int salaryLimit=70000;
        System.out.println("=================");
        printEmployeeWithSalaryMoreThen(salaryLimit);
        System.out.println("=================");
        printEmployeeWithSalaryLessThen(salaryLimit);
    }

    public static void salaryIndexationForDepart(int department, double indexation) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                double currentSalary = employee.getSalary();
                employee.setSalary((int) (currentSalary * (indexation / 100f + 1)));
            }
        }
    }

    public static void salaryIndexation(double indexation) {
        for (Employee employee : employees) {
            double currentSalary = employee.getSalary();
            employee.setSalary((int) (currentSalary * (indexation / 100 + 1)));
        }
    }

    public static double employeeWithMinSalary(int department) {
        double minSalary = 99999999;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                final double salary = employees[i].getSalary();
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                }
            }
        }
        return minSalary;
    }

    public static double employeeWithMaxSalary(int department) {
        double maxSalary = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                final double salary = employees[i].getSalary();
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                }
            }
        }
        return maxSalary;
    }

    public static double departmentSumSalary(int department) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }


    public static double departmentMidSalary(int department) {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                count++;
            }
        }
        return departmentSumSalary(department) / (float) count;
    }

    public static void printEmployeeWithoutDepartment(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println("Сотрудник: " + employee.getName() + " " + employee.getSalary() + " " + employee.getId());
            }
        }
    }

    public static void printEmployeeWithSalaryLessThen(int salaryLimit) {
        for (Employee employee : employees) {
            if (employee.getSalary() < salaryLimit) {
                System.out.println("Сотрудник: " + employee.getId() + " " + employee.getName() + " " + employee.getSalary());
            }
        }
    }
    public static void printEmployeeWithSalaryMoreThen(int salaryLimit) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= salaryLimit) {
                System.out.println("Сотрудник: " + employee.getId() + " " + employee.getName() + " " + employee.getSalary());
            }
        }
    }

}


