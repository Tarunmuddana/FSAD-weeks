package com.klh.main; 
import org.springframework.context.ApplicationContext; 
import org.springframework.context.annotation.AnnotationConfigApplicationContext; 
import com.klh.config.AppConfig;
import com.klh.model.*;
import com.klh.config.*;
public class AutowiredDemoApplication { 
 
    public static void main(String[] args) { 
 
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class); 
 
        Student student = context.getBean(Student.class); 
        student.display(); 
    } 
} 