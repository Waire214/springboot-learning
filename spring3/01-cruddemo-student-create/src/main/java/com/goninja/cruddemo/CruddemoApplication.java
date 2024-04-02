package com.goninja.cruddemo;

import com.goninja.cruddemo.dao.StudentDAO;
import com.goninja.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int deletedRows = studentDAO.deleteAll();
		System.out.println("Deleted rows: " + deletedRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);

		studentDAO.deleteByID(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// get a student by id
		Student theStudent = studentDAO.findByID(1);

		// update the student
		theStudent.setFirstName("John");

		System.out.println("Updating student with id 1...");
		studentDAO.update(theStudent);
		System.out.println("Update complete: " + theStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("Displaying students with last name of Doe...");
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// display each student
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		System.out.println("Displaying all students...");

		// get all students
		List<Student> theStudents = studentDAO.findAll();

		// display each student
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating student object...");
		Student tempStudent = new Student("Dave", "Doe", "davedoe@example.com");

		// save the student
		studentDAO.save(tempStudent);

		// display the id of the saved student
		int theId = tempStudent.getId();
		System.out.println("id of the saved student => " + theId);

		// retrieve student based on the id: primary key
		System.out.println("getting student with id: " + theId);
		Student myStudent = studentDAO.findByID(theId);
		System.out.println("student => " + myStudent);

		// display student
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create the student object
		System.out.println("creating a new student object...");
		Student tempStudent1 = new Student("Jane", "Doe", "janedoe@example.com");
		Student tempStudent2 = new Student("Mary", "Public", "marypublic@example.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonitaapplebum@example.com.com");

		// save the student object
		System.out.println("saving the new student..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display the id of the saved student
		System.out.println("generated ID of the saved student => " + tempStudent1.getId());
		System.out.println("generated ID of the saved student => " + tempStudent2.getId());
		System.out.println("generated ID of the saved student => " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("John", "Doe", "johndoe@example.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
