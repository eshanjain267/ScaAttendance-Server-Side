/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Comp001
 */
public class BatchPojo {
    private String batchcode;
    private String course ;
     private String days;
      private String time ;
      private String faculty ;

    @Override
    public String toString() {
        return "BatchPojo{" + "batchcode=" + batchcode + ", course=" + course + ", days=" + days + ", time=" + time + ", faculty=" + faculty + '}';
    }

    public String getBatchcode() {
        return batchcode;
    }

    public void setBatchcode(String batchcode) {
        this.batchcode = batchcode;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
      
              
    
    
}
