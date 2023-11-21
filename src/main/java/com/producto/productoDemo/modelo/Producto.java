package com.producto.productoDemo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private Integer precio;
    
    public Producto() {
    	
    }

public Producto(Long id, String nombre, String categoria, Integer cantidad, Integer precio){
super();
this.id = id;
this.nombre = nombre;
this.categoria = categoria;
this.cantidad = cantidad;
this.precio = precio;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getCategoria() {
    return categoria;
}

public void setCategoria(String categoria) {
    this.categoria = categoria;
}

public Integer getCantidad() {
    return cantidad;
}

public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
}

public Integer getPrecio() {
    return precio;
}

 public void setPrecio(Integer precio) {
        this.precio = precio;
}

}
