import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students == null){
			throw new IllegalArgumentException();
		}
		this.students = students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length){
			throw new IllegalArgumentException();
		}
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student == null || index < 0 || index >= students.length){
			throw new IllegalArgumentException();
		}
		students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException();
		}
		Student[] tempArray = new Student[students.length + 1];
		tempArray[0] = student;
		System.arraycopy(students, 0, tempArray, 1, students.length);
		students = tempArray;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException();
		}
		Student[] tempArray = new Student[students.length + 1];
		System.arraycopy(students, 0, tempArray, 0, students.length);
		tempArray[students.length] = student;
		students = tempArray;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student == null || index < 0 || index >= students.length){
			throw new IllegalArgumentException();
		}
		Student[] tempArray = new Student[students.length + 1];
		System.arraycopy(students, 0, tempArray, 0, index);
		tempArray[index] = student;
		System.arraycopy(students, index, tempArray, index + 1, students.length - index);
		students = tempArray;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length){
			throw new IllegalArgumentException();
		}
		Student[] tempArray = new Student[students.length - 1];
		System.arraycopy(students, 0, tempArray, 0, index );
		System.arraycopy(students, index + 1, tempArray, index, students.length - index - 1);
		students = tempArray;
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException();
		}
		boolean found = false;
		int index = 0;
		while(index < students.length){
			Student actualStudent = students[index];
			if(student.compareTo(actualStudent) == 0){
				found = true;
				break;
			}
			index++;
		}
		if(found){
			Student[] tempArray = new Student[students.length - 1];
			System.arraycopy(students, 0, tempArray, 0, index );
			System.arraycopy(students, index + 1, tempArray, index, students.length - index - 1);
			students = tempArray;
		} else {
			throw new IllegalArgumentException("Student not exist.");
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length){
			throw new IllegalArgumentException();
		}
		Student[] tempArray = new Student[index + 1];
		System.arraycopy(students, 0, tempArray, 0, index + 1 );
		students = tempArray;
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException();
		}
		boolean found = false;
		int index = 0;
		while(index < students.length){
			Student actualStudent = students[index];
			if(student.compareTo(actualStudent) == 0){
				found = true;
				break;
			}
			index++;
		}
		if(found){
			Student[] tempArray = new Student[index + 1];
			System.arraycopy(students, 0, tempArray, 0, index + 1 );
			students = tempArray;
		} else {
			throw new IllegalArgumentException("Student not exist.");
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length){
			throw new IllegalArgumentException();
		}
		Student[] tempArray = new Student[students.length - (index + 1)];
		System.arraycopy(students, index, tempArray, 0, students.length - index - 1);
		students = tempArray;
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException();
		}
		boolean found = false;
		int index = 0;
		while(index < students.length){
			Student actualStudent = students[index];
			if(student.compareTo(actualStudent) == 0){
				found = true;
				break;
			}
			index++;
		}
		if(found){
			Student[] tempArray = new Student[students.length - (index + 1)];
			System.arraycopy(students, index, tempArray, 0, students.length - index - 1);
			students = tempArray;
		} else {
			throw new IllegalArgumentException("Student not exist.");
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int n = students.length;
		Student temp;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (students[j - 1].compareTo(students[j]) > 0 ) {
					temp = students[j - 1];
					students[j - 1] = students[j];
					students[j] = temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null){
			throw new IllegalArgumentException();
		}
		List<Student> temp = new ArrayList<Student>();
		for(int i = 0 ; i < students.length ; i++){
			Student current = students[i];
			if(current.getBirthDate().compareTo(date) == 0){
				temp.add(current);
			}
		}
		return (Student[]) temp.toArray();
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate == null || lastDate == null){
			throw new IllegalArgumentException();
		}
		List<Student> temp = new ArrayList<Student>();
		for(int i = 0 ; i < students.length ; i++){
			Student current = students[i];
			if(current.getBirthDate().compareTo(firstDate) >= 0 && current.getBirthDate().compareTo(lastDate) <= 0){
				temp.add(current);
			}
		}
		return (Student[]) temp.toArray();
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		if(date == null){
			throw new IllegalArgumentException();
		}
		Date firstDate = date;
		Calendar cal  = Calendar.getInstance();
		cal.setTime(firstDate);
		cal.add(Calendar.DATE, days);
		Date lastDate = new Date(cal.getTimeInMillis());
		List<Student> temp = new ArrayList<Student>();
		for(int i = 0 ; i < students.length ; i++){
			Student current = students[i];
			if(current.getBirthDate().compareTo(firstDate) >= 0 && current.getBirthDate().compareTo(lastDate) <= 0){
				temp.add(current);
			}
		}
		return (Student[]) temp.toArray();
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent < 0 || indexOfStudent >= students.length){
			throw new IllegalArgumentException();
		}
		Student current = students[indexOfStudent];
		Date birthDate = current.getBirthDate();
		Date date = new Date();
	    long diff = date.getTime() - birthDate.getTime();
	    long d=(1000*60*60*24*365);
	    long years = Math.round(diff / d);
		return (int) years;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		List<Student> temp = new ArrayList<Student>();
		Date date = new Date();
		for(int i = 0 ; i < students.length ; i++){
			Student current = students[i];
			Date birthDate = current.getBirthDate();
			long diff = date.getTime() - birthDate.getTime();
		    long d=(1000*60*60*24*365);
		    long years = Math.round(diff / d);
		    if(years == age){
		    	temp.add(current);
		    }
		}
		return (Student[]) temp.toArray();
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		List<Student> temp = new ArrayList<Student>();
		double highestMarks = 0;
		for(int i = 0 ; i < students.length ; i++){
			Student current = students[i];
			if(current.getAvgMark() == highestMarks){
				temp.add(current);
			} else if(current.getAvgMark() > highestMarks) {
				highestMarks = current.getAvgMark();
				temp = new ArrayList<Student>();
				temp.add(current);
			}
		}
		return (Student[]) temp.toArray();
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException();
		}
		Student nextStudent = null;
		boolean found = false;
		int index = 0;
		while(index < students.length){
			Student actualStudent = students[index];
			if(student.compareTo(actualStudent) == 0){
				found = true;
				break;
			}
			index++;
		}
		if(found){
			if(index == students.length - 1){
				throw new IllegalArgumentException("Student not exist.");
			} else {
				nextStudent = students[index + 1];
			}
		} else {
			throw new IllegalArgumentException("Student not exist.");
		}
		return nextStudent;
	}
}
