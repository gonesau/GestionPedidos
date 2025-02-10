package com.gestionpedidos.utils;

import com.gestionpedidos.entity.Cliente;
import com.gestionpedidos.entity.Producto;
import com.gestionpedidos.entity.Pedido;
import com.gestionpedidos.services.ClienteService;
import com.gestionpedidos.services.ProductoService;
import com.gestionpedidos.services.PedidoService;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import java.util.Arrays;
import java.util.Date;

@Singleton
@Startup
public class DataInitializer {

    @Inject
    private ClienteService clienteService;

    @Inject
    private ProductoService productoService;

    @Inject
    private PedidoService pedidoService;

    @PostConstruct
    public void init() {
        // Crear clientes
        Cliente cliente1 = new Cliente("Juan Pérez", "Av. Siempre Viva 123", "juan@example.com");
        Cliente cliente2 = new Cliente("María Gómez", "Calle Falsa 456", "maria@example.com");

        clienteService.agregarCliente(cliente1);
        clienteService.agregarCliente(cliente2);

        // Crear productos
        Producto producto1 = new Producto("Laptop", "Laptop Dell 16GB RAM", 1200.0, 10);
        Producto producto2 = new Producto("Mouse", "Mouse inalámbrico Logitech", 25.0, 50);

        productoService.agregarProducto(producto1);
        productoService.agregarProducto(producto2);

        // Crear un pedido para cliente1
        Pedido pedido1 = new Pedido(new Date(), cliente1, Arrays.asList(producto1, producto2));
        pedidoService.agregarPedido(pedido1);

        System.out.println("📌 Datos inicializados correctamente.");
    }
}
