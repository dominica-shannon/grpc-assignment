package EmployeeService;

import com.employee.grpc.Employee.EmployeeRequest;
import com.employee.grpc.Employee.EmployeeResponse;
import com.employee.grpc.EmployeeServiceGrpc.EmployeeServiceImplBase;

import io.grpc.stub.StreamObserver;

public class EmployeeService extends EmployeeServiceImplBase{

	@Override
	public void getEmployee(EmployeeRequest request, StreamObserver<EmployeeResponse> responseObserver) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside getEmployee:");
		System.out.println("Employee Server received the following details: ");
		
		//get Employee details
		int id = request.getId();
		String name = request.getName();
		int age = request.getAge();
		String department = request.getDepartment();
		System.out.println("ID:"+id+" Name:"+name+" Age:"+age+" Department:"+department);
		
		EmployeeResponse.Builder response = EmployeeResponse.newBuilder();
		
		String message = "Hi "+name +"!! Received your details successfully";
		response.setMessage(message).build();
		System.out.println("\nEmployee Server responded : "+response);
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}