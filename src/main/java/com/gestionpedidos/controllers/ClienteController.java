package com.gestionpedidos.controllers;

import com.gestionpedidos.entity.Cliente;
import com.gestionpedidos.services.ClienteService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ClienteController implements Serializable {

    @Inject
    private ClienteService clienteService;

    private Cliente cliente = new Cliente();
    private List<Cliente> clientes;

    public void agregarCliente() {
        clienteService.agregarCliente(cliente); // Delegar la operación al servicio
        cliente = new Cliente(); // Limpiar el formulario después de agregar
    }

    public List<Cliente> obtenerClientes() {
        if (clientes == null) {
            clientes = clienteService.obtenerTodosLosClientes();
        }
        return clientes;
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}
