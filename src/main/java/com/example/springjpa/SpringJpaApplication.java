package com.example.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
		ServicioController sc = context.getBean(ServicioController.class);
		PagoController pc = context.getBean(PagoController.class);

		sc.subir(new Servicio(null,"movistar"));
		sc.subir(new Servicio(null,"claro"));
		sc.subir(new Servicio(null,"carrefour"));



		Pago p = new Pago(null, LocalDate.now(), 234.234, new Servicio(9L, null));
		pc.cargar(p);

		p = new Pago(null, LocalDate.now(), 234.234, new Servicio(1L, null));
		pc.cargar(p);
		p = new Pago(null, LocalDate.now(), 123.0, new Servicio(2L, null));
		pc.cargar(p);
		p = new Pago(null, LocalDate.now(), 1324.2, new Servicio(3L, null));
		pc.cargar(p);
		p = new Pago(null, LocalDate.now(), 99.200, new Servicio(1L, null));
		pc.cargar(p);

		for (Servicio servicio : sc.mostrar()){
			System.out.println(servicio);
		}

		for (Pago pago : pc.mostrar()){
			System.out.println(pago);
		}


	}

}
