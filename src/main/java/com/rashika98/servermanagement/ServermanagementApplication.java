package com.rashika98.servermanagement;

import com.rashika98.servermanagement.enumeration.Status;
import com.rashika98.servermanagement.model.Server;
import com.rashika98.servermanagement.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.rashika98.servermanagement.enumeration.Status.SERVER_DOWN;
import static com.rashika98.servermanagement.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServermanagementApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepo serverRepo){
		return args -> {

			serverRepo.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16 GB", "Personal PC",
					"http://localhost:8080/server/image/server1.png", SERVER_UP));

			serverRepo.save(new Server(null, "192.168.1.168", "Fedora Linux", "32 GB", "Personal PC",
					"http://localhost:8080/server/image/server2.png", SERVER_DOWN));
		};
	}

}
