package com.gestionpedidos.controllers;

import com.gestionpedidos.entity.Producto;
import com.gestionpedidos.services.ProductoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ProductoController implements Serializable {

    @Inject
    private ProductoService productoService;

    private Producto producto = new Producto();
    private List<Producto> productos;

    public void agregarProducto() {
        productoService.agregarProducto(producto);
        producto = new Producto();
    }

    public List<Producto> obtenerProductos() {
        if (productos == null) {
            productos = productoService.obtenerTodosLosProductos();
        }
        return productos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
