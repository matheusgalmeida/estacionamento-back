package br.com.uniamerica.estacionamento.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.Banner;


@Entity
public class Veiculo  extends  AbstractEntity{
    @Getter @Setter
    @Column(name = "placa", nullable = false, unique = true)
    private String placa;
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    @Column(name = "cor", nullable = false)
    private Cor cor;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    @Column(name = "tipo", nullable = false)
    private Tipo tipo;
    @Getter @Setter
    @Column(name = "ano", nullable = false)
    private int ano;


}

