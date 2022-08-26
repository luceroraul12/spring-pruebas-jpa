package com.example.springjpa;

import com.example.springjpa.controllers.PagoController;
import com.example.springjpa.controllers.ServicioController;
import com.example.springjpa.models.Pago;
import com.example.springjpa.models.Servicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
		ServicioController sc = context.getBean(ServicioController.class);
		PagoController pc = context.getBean(PagoController.class);

		sc.subir(new Servicio(null,"movistar"));
		sc.subir(new Servicio(null,"claro"));
		sc.subir(new Servicio(null,"movistar"));



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
		System.out.println("SERVICIOS CARGADOS");
		for (Servicio servicio : sc.mostrar()){
			System.out.println(servicio);
		}

		System.out.println("PAGOS CARGADOS");
		for (Pago pago : pc.mostrar()){
			System.out.println(pago);
		}

		System.out.println("SERVICIOS: FILTRO NULL NULL");
		List<Servicio> resultado = sc.buscar(null, null);
		for (Servicio servicio : resultado){
			System.out.println(servicio);
		}

		System.out.println("SERVICIOS: FILTRO NULL movistar");
		resultado = sc.buscar(null, "movistar");
		for (Servicio servicio : resultado){
			System.out.println(servicio);
		}

		System.out.println("SERVICIOS: FILTRO 3 null");
		resultado = sc.buscar(3L, null);
		for (Servicio servicio : resultado){
			System.out.println(servicio);
		}

		System.out.println("SERVICIOS: FILTRO 1 movistar");
		resultado = sc.buscar(1L, "movistar");
		for (Servicio servicio : resultado){
			System.out.println(servicio);
		}

	}

}
