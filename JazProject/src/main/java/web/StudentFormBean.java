package web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import service.StudentManager;

import domain.Student;


@SessionScoped
@Named("studentBean")
public class StudentFormBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Student student = new Student();

	private ListDataModel<Student> students = new ListDataModel<Student>();
	
	@Inject
	private StudentManager sm;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ListDataModel<Student> getAllStudents() {
		students.setWrappedData(sm.getAllStudents());
		return students;
	}

	// Actions
	public String addStudent() {
		sm.addStudent(student);
		return "showStudents";
	}
	
	public String correctStudent(){
		return "addStudent";
	}
	
	public String dataStudent(){
		return "dataStudent";
	}

	public String deleteStudent() {
		Student studentToDelete = students.getRowData();
		sm.deleteStudent(studentToDelete);
		return null;
	}
	
	public void uniqueIndeks(FacesContext context, UIComponent component,
			Object value) {
		
		int album_id = (Integer) value;

		for (Student student : sm.getAllStudents()) {
			if (student.getAlbum_id() == album_id) {
				FacesMessage message = new FacesMessage(
						"Student o takim indeksie juz istnieje");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}


}
