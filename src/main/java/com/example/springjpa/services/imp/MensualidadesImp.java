package com.example.springjpa.services.imp;

import com.example.springjpa.models.Pago;
import com.example.springjpa.models.Servicio;
import com.example.springjpa.repository.PagoRepository;
import com.example.springjpa.repository.ServicioRepository;
import com.example.springjpa.services.Mensualidades;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MensualidadesImp implements Mensualidades {

    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private PagoRepository pagoRepository;

    public MensualidadesImp(ServicioRepository servicioRepository, PagoRepository pagoRepository) {
        this.servicioRepository = servicioRepository;
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<Servicio> getServiciosCargados() {
        return servicioRepository.findAll();
    }

    @Override
    public List<Pago> getPagosCargados() {
        return pagoRepository.findAll();
    }
}
