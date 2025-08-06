package com.example.crud;

import com.example.crud.dao.StudentDAO;
import com.example.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	public void createStudent(StudentDAO studentDao){
//		create student object
//		save student object
//		display
		String[] names = {"Yash", "Krishna", "Anjali", "Ravi", "Sneha", "Arjun", "Meera", "Vikram", "Priya", "Kiran"};
		for (int i = 0; i < names.length; i++) {
			Student s = new Student(names[i], names[i], names[i] + ".com");
			studentDao.save(s);
			System.out.println("Student saved with id " + s.getId());
		}
	}

	public void multipleStudent(StudentDAO studentDAO){
		String[] names = {"Yash", "Dinesh", "Krishna", "Anjali", "Ravi", "Sneha", "Arjun", "Meera", "Vikram", "Priya", "Kiran"};
		for (int i = 0; i < names.length; i++) {
			Student s = new Student(names[i], names[i], names[i] + "@gmail.com");
			studentDAO.save(s);
			System.out.println("Student saved with id " + s.getId());
		}
	}

	public void readStudent(StudentDAO studentDAO){
		Student s = studentDAO.findById(11);
		System.out.println(s);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			readStudent(studentDAO);
		};
	}
}
