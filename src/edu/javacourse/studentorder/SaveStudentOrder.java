package edu.javacourse.studentorder;

import edu.javacourse.studentorder.dao.DictionaryDaoImpl;
import edu.javacourse.studentorder.domain.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception {

        List<Street> d = new DictionaryDaoImpl().findStreets("d");
        for (Street s : d){
            System.out.println(s.getStreetName());
        }




        //StudentOrder so = buildStudentOrder(10);

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

        Street street = new Street(1L, "First street");

        Address address = new Address("195000",street,"12","","142");

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
        Child child1 = new Child("Петрова","Ирина","Викторовна",LocalDate.of(2018,6,29));
        child1.setCertificateNumber("" + (3000 + id));
        child1.setIssueDate(LocalDate.of(2018,7,19));
        child1.setIssueDepartment("Отдел ЗАГС номер" + id);
        child1.setAddress(address);

        Child child2 = new Child("Петрова","Евгений","Викторович",LocalDate.of(2018,6,29));
        child2.setCertificateNumber("" + (4000 + id));
        child2.setIssueDate(LocalDate.of(2018,7,19));
        child2.setIssueDepartment("Отдел ЗАГС номер" + id);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);



        //StudentOrder so1 = so;
        //printStudentOrder(so1);
        System.out.println();

        return so;
    }

    static void printStudentOrder(StudentOrder stOr){
        System.out.println(stOr.getStudentOrderId());
    }
}
