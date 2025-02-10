package com.gestionpedidos.controllers;

import com.gestionpedidos.entity.Pedido;
import com.gestionpedidos.entity.Producto;
import com.gestionpedidos.services.PedidoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class PedidoController implements Serializable {

    @Inject
    private PedidoService pedidoService;

    private Pedido pedido = new Pedido();
    private List<Pedido> pedidos;

    public void agregarPedido() {
        pedidoService.agregarPedido(pedido);
        pedido = new Pedido(); // Limpiar el formulario
    }

    public List<Pedido> obtenerPedidos() {
        if (pedidos == null) {
            pedidos = pedidoService.obtenerTodosLosPedidos();
        }
        return pedidos;
    }

    public Double calcularTotal(Pedido pedido) {
        Double total = 0.0;
        for (Producto producto : pedido.getProductos()) {
            total += producto.getPrecio();
        }
        return total;
    }


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
