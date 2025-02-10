package com.gestionpedidos.services;

import com.gestionpedidos.entity.Cliente;
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Dependent
public class ClienteService {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void agregarCliente(Cliente cliente) {
        entityManager.persist(cliente);
    }

    public Cliente obtenerClientePorId(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Transactional
    public void actualizarCliente(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Transactional
    public void eliminarCliente(Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }
}
