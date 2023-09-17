package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCityRegister;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.validator.Register.FakeCityRegisterChecker;

import java.util.Iterator;
import java.util.List;

public class CityRegisterValidator {

    public String hostName;
    protected int port;
    private String login;
    String password;
    private FakeCityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so){
        try {
            CityRegisterCheckerResponse hAns = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wAns = personChecker.checkPerson(so.getWife());
            List<Child> children = so.getChildren();

            for (int i = 0; i < so.getChildren().size(); i++) {
                CityRegisterCheckerResponse cAns = personChecker.checkPerson(children.get(i));
            }

            for (Iterator<Child> it = children.iterator(); it.hasNext(); ) {
                Child child = it.next();
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }

            for (Child child : children) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }
        }
        catch (CityRegisterException ex){
            ex.printStackTrace(System.out);
        }



        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
