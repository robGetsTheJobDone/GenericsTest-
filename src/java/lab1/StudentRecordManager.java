package java.lab1;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
public class StudentRecordManager {
    public ArrayList<Student> List; 
    
   
    
    
    public void  AddStudent( String FirstName, String LastName, int ID,String Email){
        Student Temp = new Student( FirstName,  LastName,  ID, Email); 
      List.add(Temp); 
    } 
   public void DelStudent(Student t){
       List.remove(t);
   }
    public void AddSubject(Student t, String Class, String Grade ){
        t.AddCourse(Class, Grade);
        }
    
    public void RemoveSubject(Student t, Student.Course c ){
        t.RemoveCourse(c); 
    }
        interface Iterator <E>   {
 E GetNext();     
 boolean HasNext();
 void remove();
 
    
}
        class Student It implements Iterator(<E>){
            
        }
      
       
}
