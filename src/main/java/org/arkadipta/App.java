package org.arkadipta;

import org.arkadipta.dao.StudentDao;
import org.arkadipta.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // 1. Load Spring context from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        // 2. Retrieve the DAO bean (type-safe)
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

////         3. Create a Student instance
//        Student student2 = new Student();
//        student2.setId(4);
//        student2.setName("Bina Star");
//        student2.setEmail("star@gmail.com");
//
//        // 4. Insert the student (returns generated count or id)
//        int result = studentDao.save(student2);
//        System.out.println("Insert result: " + result);

//        //view
//        Student student = studentDao.view(2);
//        System.out.println(student);

//        //update
//        Student student2 = new Student();
//        student2.setId(4);
//        student2.setName("Bina Saha");
//        student2.setEmail("saha@gmail.com");
//
//        Student s = studentDao.update(student2);
//        System.out.println(s);

        //delete
        studentDao.delete(2);


        // 5. Close the context (optional for standalone apps)
        ((ClassPathXmlApplicationContext) context).close();
    }
}
