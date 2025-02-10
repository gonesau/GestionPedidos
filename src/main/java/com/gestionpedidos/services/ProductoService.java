package com.gestionpedidos.services;

import com.gestionpedidos.entity.Producto;
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Dependent
public class ProductoService {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void agregarProducto(Producto producto) {
        entityManager.persist(producto);
    }

    public Producto obtenerProductoPorId(Long id) {
        return entityManager.find(Producto.class, id);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return entityManager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }

    @Transactional
    public void actualizarProducto(Producto producto) {
        entityManager.merge(producto);
    }

    @Transactional
    public void eliminarProducto(Long id) {
        Producto producto = entityManager.find(Producto.class, id);
        if (producto != null) {
            entityManager.remove(producto);
        }
    }
}
