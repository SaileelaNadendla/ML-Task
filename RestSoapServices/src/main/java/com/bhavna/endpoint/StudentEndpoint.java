package com.bhavna.endpoint;




import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.www_bhavna_com.student.GetStudentRequest;
import https.www_bhavna_com.student.GetStudentResponse;
import https.www_bhavna_com.student.Student;

@Endpoint
public class StudentEndpoint {
	 
	@PayloadRoot(namespace= "https://www.bhavna.com/student",localPart = "getStudentRequest")
	@ResponsePayload	
	public GetStudentResponse studentDetailRequest(@RequestPayload GetStudentRequest request) {
		GetStudentResponse responce = new GetStudentResponse();
	
		Student student = new Student();
        student.setId(request.getId());
		student.setName("Anusha");
		student.setPlace("Hyderabad");
		responce.setStudent(student);
		return responce ;
		
	}
}
