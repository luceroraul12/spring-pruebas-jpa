package com.example.springjpa;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PagoController {
    private PagoRepository repo;

    public PagoController(PagoRepository repo) {
        this.repo = repo;
    }

    public void cargar(Pago p){
        try{
            repo.save(p);
        } catch (DataIntegrityViolationException e){
            System.out.println("SERVICIO ASOCIADO NO EXISTE");;
        }
    }

    public List<Pago> mostrar(){
        return repo.findAll();
    }
}
