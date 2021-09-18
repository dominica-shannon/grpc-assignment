import io.grpc.ManagedChannelBuilder;

import com.employee.grpc.Employee.EmployeeRequest;
import com.employee.grpc.Employee.EmployeeResponse;
import com.employee.grpc.EmployeeServiceGrpc;
import com.employee.grpc.EmployeeServiceGrpc.EmployeeServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcEmployeeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build(); //ip, port

		EmployeeServiceBlockingStub employeeStub = EmployeeServiceGrpc.newBlockingStub(channel);
		
		EmployeeRequest employeerequest = EmployeeRequest.newBuilder().setId(1).setName("Tina").setAge(10).setDepartment("CS").build();
		 
		EmployeeResponse response = employeeStub.getEmployee(employeerequest);
		System.out.println("Response: "+response.getMessage());
	}

}
