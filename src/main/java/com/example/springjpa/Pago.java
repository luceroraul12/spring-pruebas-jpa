package com.example.springjpa;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate fecha;
    private Double pago;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    public Pago() {
    }

    public Pago(Long id, LocalDate fecha, Double pago, Servicio servicio) {
        this.id = id;
        this.fecha = fecha;
        this.pago = pago;
        this.servicio = servicio;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getPago() {
        return pago;
    }

    public Servicio getServicio() {
        return servicio;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", pago=" + pago +
                ", servicio=" + servicio +
                '}';
    }
}
