package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCityRegister;
import edu.javacourse.studentorder.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.validator.Register.FakeCityRegisterChecker;

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
            CityRegisterCheckerResponse cAns = personChecker.checkPerson(so.getChild());
        }
        catch (CityRegisterException ex){
            ex.printStackTrace(System.out);
        }



        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
