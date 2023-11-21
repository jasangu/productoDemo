package com.producto.productoDemo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producto.productoDemo.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

    
} 