/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java.lab1;

import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class Student {
     private String FirstName;
     private String LastName;
     private String Email;
     private int ID;
    private ArrayList<Course> CourseList; 
    
    public Student(String FirstName, String LastName, int ID,String Email){
        this.FirstName= FirstName;
        this.LastName= LastName; 
        this.Email = Email;
 
    
        
    }
    public void AddCourse(String Class, String Grade ){
       CourseList.add(new Course(Class,Grade));
      
    }
        public void RemoveCourse( Course x ){
       CourseList.remove(x); 
      
    }
    class Course  {
        private String Class;
        private String Grade;
        private  int CourseNum = 0; 
        
        Course( String Class, String Grade ){
            this.Class = Class; 
            this.Grade = Grade; 
            CourseList.add(this);
            
            
        }
      public String  GetCourse(){
          return Class + " : " + Grade;
            
        }
    
    }
     interface Iterator <E>   {
 E GetNext();     
 boolean HasNext();
 void remove();
 
    
}
     class CourseIterator implements Iterator{
       public int I;
         CourseIterator(int I){
             this.I = I; 
             
         }

        @Override
        public Course GetNext() {
            return CourseList.get(I);
            
        }

        @Override
        public boolean HasNext() {
            boolean b = true;
         if (CourseList.get(I) == null ){
             b = false;
         }
         return b; 
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
     }
     CourseIterator returnIT(){
         return new CourseIterator(0); 
         
     }

    
    
}
