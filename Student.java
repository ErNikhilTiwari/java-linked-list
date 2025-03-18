public class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }

    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        list.addStudentAtBeginning(1, "Nikhil", 21, "A");
        list.addStudentAtEnd(2, "Pranav", 22, "A+");
        list.addStudentAtPosition(3, "Jashan", 21, "A", 1);
        list.displayAllStudents();
        list.updateStudentGrade(2, "A+");
        list.displayAllStudents();
        list.deleteStudentByRollNumber(1);
        list.displayAllStudents();
    }
}

class StudentLinkedList {
    private Student head;

    public StudentLinkedList() {
        this.head = null;
    }

    public void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }
    }

    public void addStudentAtPosition(int rollNumber, String name, int age, String grade, int position) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 0) {
            newStudent.next = head;
            head = newStudent;
        } else {
            Student temp = head;
            for (int i = 0; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                newStudent.next = temp.next;
                temp.next = newStudent;
            }
        }
    }

    public void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public Student searchStudentByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null && temp.rollNumber != rollNumber) {
            temp = temp.next;
        }
        return temp;
    }

    public void displayAllStudents() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public void updateStudentGrade(int rollNumber, String newGrade) {
        Student temp = searchStudentByRollNumber(rollNumber);
        if (temp != null) {
            temp.grade = newGrade;
        }
    }

    
}