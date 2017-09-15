public class Main {

	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		StudentGroup group = new StudentGroup(5);
		Student[] students = new Student[5];
		students[0] = new Student(1, "1", new Date(), 1);
		students[1] = new Student(2, "2", new Date(), 2);
		students[2] = new Student(3, "3", new Date(), 3);
		students[3] = new Student(5, "5", new Date(), 3);
		students[4] = new Student(6, "6", new Date(), 1);
		
		group.setStudents(students);
		
		group.add(new Student(4, "4", new Date(), 1), 3);
		
		group.addFirst(new Student(10, "0", new Date(), 1));
		group.addLast(new Student(7, "7", new Date(), 1));
		
		group.removeToIndex(3);
		group.remove(3);
		
	}

}
