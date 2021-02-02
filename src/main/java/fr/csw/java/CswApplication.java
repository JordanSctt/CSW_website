package fr.csw.java;

import fr.csw.java.admin.Admin;
import fr.csw.java.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CswApplication {

	public static void main(String[] args) {
		SpringApplication.run(CswApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private AdminRepository adminRepository;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			if(adminRepository.count() == 0) {
				Admin admin = new Admin();
				admin.setLogin("ColinSamuelWeis");
				admin.setPassword(passwordEncoder().encode("admin123"));
				admin.setRole("ADMIN");
				adminRepository.save(admin);
			}
		};
	}

}
