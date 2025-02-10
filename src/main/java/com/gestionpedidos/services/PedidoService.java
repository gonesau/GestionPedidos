package com.gestionpedidos.services;

import com.gestionpedidos.entity.Pedido;
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Dependent
public class PedidoService {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void agregarPedido(Pedido pedido) {
        entityManager.persist(pedido);
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return entityManager.find(Pedido.class, id);
    }

    public List<Pedido> obtenerTodosLosPedidos() {
        return entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
    }

    @Transactional
    public void actualizarPedido(Pedido pedido) {
        entityManager.merge(pedido);
    }

    @Transactional
    public void eliminarPedido(Long id) {
        Pedido pedido = entityManager.find(Pedido.class, id);
        if (pedido != null) {
            entityManager.remove(pedido);
        }
    }
}
