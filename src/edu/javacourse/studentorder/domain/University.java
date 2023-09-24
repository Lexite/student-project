package edu.javacourse.studentorder.domain;

public class University {
    private long universityId;
    private String universityName;

    public University(long universityId, String universityName) {
        this.universityId = universityId;
        this.universityName = universityName;
    }

    public University(){}

    public long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(long universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
