import app.users.Student;
import app.users.Teacher;
import app.users.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main(String[] args) {
    Student student=Student.builder().setId("123123").setDataInscrierii(LocalDate.now()).build();
    System.out.println(student);
    Teacher teacher=Teacher.builder().setId("1111").setEmail("aaaa@gmail.com").setDataAngajarii(LocalDate.now() ).setPassword("12345").build();
    System.out.println(teacher);


}
