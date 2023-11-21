package com.producto.productoDemo.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.producto.productoDemo.excepciones.ResourceNotFoundException;
import com.producto.productoDemo.modelo.Producto;
import com.producto.productoDemo.repositorio.ProductoRepositorio;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/v1/")

public class ProductoControlador {

	
	
    @Autowired
    private ProductoRepositorio repositorio;
    
    @GetMapping("/productos")
    public List<Producto> listarTodosLosProductos(){
    	return repositorio.findAll();
    }
    
    @PostMapping("/productos")
    public Producto guardarProducto(@RequestBody Producto producto) {
    	return repositorio.save(producto);
    }
    
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
    	Producto producto = repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException(("No existe el producto")));
    	
    	return ResponseEntity.ok(producto);
    }
    
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProductoPorId(@PathVariable Long id, @RequestBody Producto detallesProducto) {
    	Producto producto = repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException(("No existe el producto")));
    	
    	producto.setNombre(detallesProducto.getNombre());
    	producto.setCategoria(detallesProducto.getCategoria());
    	producto.setCantidad(detallesProducto.getCantidad());
    	producto.setPrecio(detallesProducto.getPrecio());
    	
    	Producto productoActualizado = repositorio.save(producto);
    	return ResponseEntity.ok(productoActualizado);
    }
    
    @DeleteMapping("/empleados/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarProducto(@PathVariable Long id){
		Producto producto = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el producto"));
		
		repositorio.delete(producto);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
    
}
