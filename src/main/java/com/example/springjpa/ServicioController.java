package com.example.springjpa;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ServicioController {
    private ServicioRepository rep;

    public ServicioController(ServicioRepository rep) {
        this.rep = rep;
    }

    public void subir(Servicio s){
        rep.save(s);
    }

    public List<Servicio> mostrar(){
        return rep.findAll();
    }

    public List<Servicio> buscar(Long id, String nombre){
        return rep.busquedaFiltrada(id, nombre);
    }


}
