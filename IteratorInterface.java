//iterator interace
import java.util.*;
class student{
    int rollno;
    String name;//S of string is capital
    String grade;
    student(int rollno,String name,String  grade){
        this.rollno=rollno;
        this.name=name;
        this.grade=grade;
    }

    String getname(){//mention the return datatype of method 
        return name;
    }

   String getgrade(){
        return grade;
    }

    int getrollno(){
        return rollno;
    }

    void setgrade(String grade){// setter has void datatype
        this.grade=grade;
    }
        @Override
    public String toString() {
    return "Roll No: " + rollno + ", Name: " + name + ", Grade: " + grade;
    
}
}

class studentmanager{
    List<student> students=new ArrayList<>();//L of list is capital and A of array
    void addstudent(student stud){
        students.add(stud);//adding the input  object in students list
    }
    void removestudent(int rollno){
        Iterator<student> iterator=students.iterator();//creating a iterator for students list 
        while(iterator.hasNext()){
            student stud=iterator.next();//creating a reference variable  for each next object 
            if(stud.getrollno()==rollno){//use getter to get rollno
                iterator.remove();//removing that object
                System.out.println("removed");
            }
        }
    }
    void display(){
        for(student stud:students){
            System.out.println(stud);
        }
    }
    void replacegrade(int rollno,String newgrade){
        for(student stud:students){
            if(stud.getrollno()==rollno){
                stud.setgrade(newgrade);
                System.out.println("grade set");
            }
        }
    }


}

public class IteratorInterface{
    public static void main(String[] args){
        studentmanager studlist=new studentmanager();
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Replace Grade");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

        int choice=scanner.nextInt();//I of int in nextInt is capital
        scanner.nextLine();

        switch (choice) {
            case 1:
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter roll number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter grade: ");
            String grade = scanner.nextLine();
            student stud=new student(rollNumber, name, grade);
            studlist.addstudent(stud);

                break;
            case 2:
            System.out.print("Enter roll number of student to remove: ");
                    rollNumber = scanner.nextInt();
                    studlist.removestudent(rollNumber);

        case 3:
        studlist.display();
        break;

        case 4:
        System.out.print("Enter roll number of student to replace grade: ");
        rollNumber = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new grade: ");
        grade = scanner.nextLine();
        studlist.replacegrade(rollNumber, grade);
        break;

        case 5:
        scanner.close();
        return;

            default:
            System.out.println("wrong choice");
                break;
        }
        }

    }
}