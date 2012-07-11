package com.wetongji.data;

import com.j256.ormlite.field.DatabaseField;

public class User {
	
	@DatabaseField(id=true)
	private
	String NO;
	@DatabaseField
	private
	String Name;
	@DatabaseField
	String Avatar;
    @DatabaseField
	String UID;
	@DatabaseField
	String Phone;
	@DatabaseField
	String DisplayName;
	@DatabaseField
	String Major;
	@DatabaseField
	private
	String NativePlace;
	@DatabaseField
	private
	String Degree;
	@DatabaseField
	String Gender;
	@DatabaseField
	String Year;	//��ѧ���
	@DatabaseField
	String Birthday;
	@DatabaseField
	String Plan;	//ѧ��
	@DatabaseField
	private
	String SinaWeibo;
	@DatabaseField
	String QQ;
	@DatabaseField
	String Department;
	@DatabaseField
	String Email;
	
	

	/**
	 * 
	 */
	public User() {
	}



	/**
	 * @param nO
	 * @param name
	 * @param avatar
	 * @param uID
	 * @param phone
	 * @param displayName
	 * @param major
	 * @param nativePlace
	 * @param degree
	 * @param gender
	 * @param year
	 * @param birthday
	 * @param plan
	 * @param sinaWeibo
	 * @param qQ
	 * @param department
	 * @param email
	 */
	User(String nO, String name, String avatar, String uID, String phone,
			String displayName, String major, String nativePlace,
			String degree, String gender, String year, String birthday,
			String plan, String sinaWeibo, String qQ, String department,
			String email) {
		setNO(nO);
		setName(name);
		Avatar = avatar;
		UID = uID;
		Phone = phone;
		DisplayName = displayName;
		Major = major;
		setNativePlace(nativePlace);
		setDegree(degree);
		Gender = gender;
		Year = year;
		Birthday = birthday;
		Plan = plan;
		setSinaWeibo(sinaWeibo);
		QQ = qQ;
		Department = department;
		Email = email;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getSinaWeibo() {
		return SinaWeibo;
	}



	public void setSinaWeibo(String sinaWeibo) {
		SinaWeibo = sinaWeibo;
	}



	public String getNO() {
		return NO;
	}



	public void setNO(String nO) {
		NO = nO;
	}



	public String getNativePlace() {
		return NativePlace;
	}



	public void setNativePlace(String nativePlace) {
		NativePlace = nativePlace;
	}



	public String getDegree() {
		return Degree;
	}



	public void setDegree(String degree) {
		Degree = degree;
	}
	
	public String getAvatar() {
        return Avatar;
    }



    public void setAvatar(String avatar) {
        Avatar = avatar;
    }



    public String getUID() {
        return UID;
    }



    public void setUID(String uID) {
        UID = uID;
    }



    public String getPhone() {
        return Phone;
    }



    public void setPhone(String phone) {
        Phone = phone;
    }



    public String getDisplayName() {
        return DisplayName;
    }



    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }



    public String getMajor() {
        return Major;
    }



    public void setMajor(String major) {
        Major = major;
    }



    public String getGender() {
        return Gender;
    }



    public void setGender(String gender) {
        Gender = gender;
    }



    public String getYear() {
        return Year;
    }



    public void setYear(String year) {
        Year = year;
    }



    public String getBirthday() {
        return Birthday;
    }



    public void setBirthday(String birthday) {
        Birthday = birthday;
    }



    public String getPlan() {
        return Plan;
    }



    public void setPlan(String plan) {
        Plan = plan;
    }



    public String getQQ() {
        return QQ;
    }



    public void setQQ(String qQ) {
        QQ = qQ;
    }



    public String getDepartment() {
        return Department;
    }



    public void setDepartment(String department) {
        Department = department;
    }



    public String getEmail() {
        return Email;
    }



    public void setEmail(String email) {
        Email = email;
    }


}
