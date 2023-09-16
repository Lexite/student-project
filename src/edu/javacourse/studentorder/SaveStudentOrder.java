package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.Address;
import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = buildStudentOrder(10);

        //StudentOrder so = new StudentOrder();
        //long ans = saveStudentOrder(so);
        //System.out.println(ans);
    }
    static long saveStudentOrder (StudentOrder studentOrder){
        long answer = 199;
        System.out.println("saveStudentOrder");
        return answer;
    }



    public static StudentOrder buildStudentOrder(long id){
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2023,7,4));
        so.setMarriageOffice("Отдел ЗАГС");

        Address address = new Address("195000","Занаевский пр.","12","","142");

        //Муж
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997,02,24));
        husband.setPassportNumber("" + (1000+id));
        husband.setPassportSeria("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017,9,15));
        husband.setIssueDepartment("Отдел милиции номер" + id);
        husband.setStudentID("" + (100000 + id));
        husband.setAddress(address);

        //Жена
        Adult wife = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997,02,24));
        wife.setPassportNumber("" + (2000+id));
        wife.setPassportSeria("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018,4,5));
        wife.setIssueDepartment("Отдел милиции номер" + id);
        wife.setStudentID("" + (200000 + id));
        wife.setAddress(address);

        //Ребенок
        Child child = new Child("Петрова","Ирина","Викторовна",LocalDate.of(2018,6,29));
        child.setCertificateNumber("" + (3000 + id));
        child.setIssueDate(LocalDate.of(2018,7,19));
        child.setIssueDepartment("Отдел ЗАГС номер" + id);
        child.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.setChild(child);



        //StudentOrder so1 = so;
        //printStudentOrder(so1);

        return so;
    }

    static void printStudentOrder(StudentOrder stOr){
        System.out.println(stOr.getStudentOrderId());
    }
}
