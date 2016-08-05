package test;

import jsonUtil.SerializableTool;
import process.Student;

/**
 * 
 * @author 傅聪
 * @Date 2016年8月5日
 */
public class SerializableToolTest {

    /**
     * 
     * 
     * @param args
     * @return void
     * @since v2.2.2
     * 
     * <PRE>
     * author 傅聪 
     * Date 2016年8月5日
     * </PRE>
     */
    public static void main(String[] args) {
        System.out.println(SerializableTool.serializeFormat(getStudent()));
    }

    private static Student getStudent() {
        Student student = new Student();
        student.setAge(22);
        student.setName("Eric");
        student.setSchool("HDU");
        return student;
    }

}
