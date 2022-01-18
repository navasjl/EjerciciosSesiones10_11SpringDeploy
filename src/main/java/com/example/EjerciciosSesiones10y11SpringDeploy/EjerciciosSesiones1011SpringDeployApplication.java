package com.example.EjerciciosSesiones10y11SpringDeploy;

import com.example.EjerciciosSesiones10y11SpringDeploy.entities.Laptop;
import com.example.EjerciciosSesiones10y11SpringDeploy.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjerciciosSesiones1011SpringDeployApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(EjerciciosSesiones1011SpringDeployApplication.class, args);
		LaptopRepository laptopRepository=context.getBean(LaptopRepository.class);

		Laptop laptop1=new Laptop(null,"Hp","i7",16,512,15.6,1099.99,true);
		Laptop laptop2=new Laptop(null,"Lenovo","i5",12,256,15.6,899.99,false);
		Laptop laptop3=new Laptop(null,"Acer","AMD Ryzen 5",8,512,14.0,699.99,false);

		laptopRepository.save(laptop1);
		laptopRepository.save(laptop2);
		laptopRepository.save(laptop3);

		laptopRepository.findAll();

	}

}
