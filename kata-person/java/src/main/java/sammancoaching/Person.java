package sammancoaching;

public class Person {

    private PersonalRole role;
	private String swedishPersonalNumber;
    private String phoneNumber;

    public Person(PersonalRole role, String swedishPersonalNumber, String phoneNumber) {
        setRole(role);
        setSwedishPersonalNumber(swedishPersonalNumber);
        this.phoneNumber = phoneNumber;
    }

    public void setRole(PersonalRole role) {
        this.role = role;
    }

    public void setSwedishPersonalNumber(String swedishPersonalNumber) {
        swedishPersonalNumber = swedishPersonalNumber.replace("-", "");
        if (swedishPersonalNumber.length() != 12)
            throw new IllegalArgumentException("invalid personal number " + swedishPersonalNumber);
        this.swedishPersonalNumber = swedishPersonalNumber;
    }

    public int birthYear() {
        String year = swedishPersonalNumber.substring(0, 4);
        return Integer.parseInt(year);
    }

    public String countryCode() {
        String code = "";
        if (phoneNumber.startsWith("00"))
            code = phoneNumber.substring(2, 4);
        else if (phoneNumber.startsWith("+"))
            code = phoneNumber.substring(1,3);
        if (!code.isEmpty())
            return "+" + code;
        return "";
    }

    public boolean canDeleteUsers() {
        return this.role == PersonalRole.USER_ROLE_MANAGER || this.role == PersonalRole.USER_ROLE_ADMIN;
    }
}