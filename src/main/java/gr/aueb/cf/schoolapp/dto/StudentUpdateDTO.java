package gr.aueb.cf.schoolapp.dto;

public class StudentUpdateDTO extends BaseDTO {
    private String firstname;
    private String lastname;

    public StudentUpdateDTO() {}

    public StudentUpdateDTO(int id, String firstname, String lastname) {
        this.setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
