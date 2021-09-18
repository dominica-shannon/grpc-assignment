import java.io.IOException;

import com.employee.grpc.EmployeeServiceGrpc;

import EmployeeService.EmployeeService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

	public static void main(String[] args)  throws IOException, InterruptedException{
		//Create builder for server
		Server server = ServerBuilder.forPort(9090).addService(new EmployeeService()).build();

		server.start();
		System.out.println("Server started at:"+server.getPort());
		server.awaitTermination(); //For Exception
	}

}

/*
Output:
Inside getEmployee:
Employee Server received the following details: 
ID:1 Name:Rima Age:25 Department:Computer Science

Employee Server responded : message: "Hi Rima!! Received your details successfully"
*/

