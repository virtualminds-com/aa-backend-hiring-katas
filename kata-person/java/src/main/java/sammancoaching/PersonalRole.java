package sammancoaching;public enum PersonalRole{USER_ROLE_ADMIN(0), USER_ROLE_ENGINEER(1), USER_ROLE_MANAGER(2), USER_ROLE_SALES(3);
private int value;
public int getValue(){
return value;
}
	PersonalRole(int value)	{this.value = value;	}}