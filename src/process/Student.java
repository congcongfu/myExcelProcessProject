package process;

/**
 * 
 * @author 傅聪
 * @Date 2016年8月5日
 */
public class Student {

    private String name;
    private String sex;
    private String school;
    private int    age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String toString() {
        String result = "";
        result += "[ name : " + name + ", age : " + age + ", school : " + school + ", sex : " + sex + " ]";
        return result;
    }
}
