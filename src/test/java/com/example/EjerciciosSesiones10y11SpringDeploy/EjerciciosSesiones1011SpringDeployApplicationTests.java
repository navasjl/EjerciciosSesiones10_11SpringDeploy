package com.example.EjerciciosSesiones10y11SpringDeploy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest     para que solo ejecute el test (obtener variables de entorno) sin ejecutar Spring, mas rapido
class EjerciciosSesiones1011SpringDeployApplicationTests {

	@Test
	void contextLoads() {
		System.getenv().forEach(
				(key,value)-> System.out.println(key+" "+value)
		);
	}

}
