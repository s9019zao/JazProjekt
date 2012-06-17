package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import domain.Student;

@ApplicationScoped
public class StudentManager {
	
	private List<Student> db = new ArrayList<Student>();

	public void addStudent(Student student) {
		Student newStudent = new Student();

		newStudent.setAlbum_id(student.getAlbum_id());
		newStudent.setFirstName(student.getFirstName());
		newStudent.setLastName(student.getLastName());
		newStudent.setZipCode(student.getZipCode());
		newStudent.setTown(student.getTown());
		newStudent.setPin(student.getPin());
		newStudent.setDateOfBirth(student.getDateOfBirth());


		db.add(newStudent);
	}

	// Removes the person with given PIN
	public void deleteStudent(Student student) {
		Student studentToRemove = null;
		for (Student s : db) {
			if (student.getAlbum_id() == (s.getAlbum_id())) {
				studentToRemove = s;
				break;
			}
		}
		if (studentToRemove != null)
			db.remove(studentToRemove);
	}

	public List<Student> getAllStudents() {
		return db;
	}
}
