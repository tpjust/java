//Inheritance

import java.util.*;
class Employee{
    int id;
    String name;
    int rate;
    Employee(int id, String name, int rate){
        this.id=id;
        this.name=name;
        this.rate=rate;
    }
    int getid(){
        return id;
    }
    String getname(){
        return name;
    }
    int getrate(){
        return rate;
    }
    @Override
    public String toString(){
        return "id="+id+"name="+name+"rate="+rate;
    }
}

class FullEmployee extends Employee{
    int salary;
    int benifits;
    FullEmployee(int id, String name, int rate, int salary,int benifits){
        super(id,name,rate);
        this.salary=salary;
        this.benifits=benifits;
    }

    int getsalary(){
        return salary;
    }

    int beneifits(){
        return benifits;
    }
    @Override//o is capital
    public String toString(){
    return "id="+id+"name="+name+"rate="+rate+"salary="+salary+"benifits="+benifits;
    }

    int calculatemonthlysal(){
        return salary+benifits;
    }
}

class HalfEmployee extends Employee{
    int hours;
    int overtime;
    HalfEmployee(int id, String name, int rate,int hours,int overtime){
        super(id,name,rate);
        this.hours=hours;
        this.overtime=overtime;
    }
    public int getHours() {
        return hours;
    }
    public int getOvertime() {
        return overtime;
    }
    @Override
    public String toString() {
        return "id="+id+"name="+name+"rate="+rate+"hours="+hours+"overtime="+overtime;
    }
    int calculatemonthlysal(){
        return rate*(hours+overtime);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details for Full-time Employee:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Hourly Rate: ");
        int rate = scanner.nextInt();
        System.out.print("Salary: ");
        int salary = scanner.nextInt();
        System.out.print("Benefits: ");
        int benifits = scanner.nextInt();
        scanner.nextLine(); 
        FullEmployee fullTimeEmployee = new FullEmployee(id, name, rate, salary, benifits);
        System.out.println("Enter details for Part-time Employee:");
        System.out.print("Name: ");
        String partName = scanner.nextLine();
        System.out.print("Employee ID: ");
        int partId = scanner.nextInt();
        System.out.print("Hourly Rate: ");
        int partHourlyRate = scanner.nextInt();
        System.out.print("Hours Worked: ");
        int partHoursWorked = scanner.nextInt();
        System.out.print("Overtime Rate: ");
        int partOvertimeRate = scanner.nextInt();
        HalfEmployee partTimeEmployee = new HalfEmployee(partId, partName, partHourlyRate, partHoursWorked, partOvertimeRate);

        System.out.println(fullTimeEmployee);
        System.out.println("Full-Time Employee Monthly Salary: $" + fullTimeEmployee.calculatemonthlysal());
        System.out.println(partTimeEmployee);
        System.out.println("Part-Time Employee Monthly Salary: $" + partTimeEmployee.calculatemonthlysal());
        scanner.close();

    }
}
