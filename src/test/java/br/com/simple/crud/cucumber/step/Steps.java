package br.com.simple.crud.cucumber.step;

import br.com.simple.crud.cucumber.adapter.StudentDataTableAdapter;
import br.com.simple.crud.domain.dto.StudentRequestDto;
import br.com.simple.crud.repository.StudentRepository;
import br.com.simple.crud.resource.student.StudentResource;
import br.com.simple.crud.service.builder.StudentBuilder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Steps {

    private StudentResource studentResource;
    private StudentRepository studentRepository;
    private StudentDataTableAdapter studentDataTableAdapter = new StudentDataTableAdapter();
    private StudentBuilder studentBuilder;

    private static final int FIRST_INDEX = 0;

//    public Steps(StudentResource studentResource, StudentRepository studentRepository, StudentDataTableAdapter studentDataTableAdapter, StudentBuilder studentBuilder) {
//        this.studentResource = studentResource;
//        this.studentRepository = studentRepository;
//        this.studentDataTableAdapter = studentDataTableAdapter;
//        this.studentBuilder = studentBuilder;
//    }

    @Dado("que possuo as informações do estudante")
    public void iHaveStudentInformation(final DataTable dataTable) {
        StudentRequestDto studentRequestDto = studentDataTableAdapter.createStudentList(dataTable).get(FIRST_INDEX);
        studentRepository.save(studentBuilder.toStudent(studentRequestDto));
    }

    @Quando("envio as informações do meu estudante")
    public void sendMyStudentInformation() {
        //studentResponseDtoResponseEntity = studentResource.create(student);
    }

    @Então("deverá ser cadastrado com sucesso")
    public void mustBeSuccessfullyRegistered() {
        //assertEquals(HttpStatus.CREATED, studentResponseDtoResponseEntity.getStatusCode());
    }
}
