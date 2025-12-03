package com.sgi.modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private static Inventario instancia;
    private List<Producto> productos;

    private Inventario() {
        productos = new ArrayList<>();
        // Datos de demostración
        productos.add(new Producto("LAP-101", "Laptop Standard", 5, 800.00));
        productos.add(new Producto("CEL-205", "Smartphone Pro", 12, 450.50));
    }

    public static Inventario getInstancia() {
        if (instancia == null) {
            instancia = new Inventario();
        }
        return instancia;
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public Producto buscarProducto(String id) {
        for (Producto p : productos) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean agregarProducto(Producto nuevoProducto) {
        if (buscarProducto(nuevoProducto.getId()) != null) {
            return false; // El ID ya existe
        }
        productos.add(nuevoProducto);
        return true;
    }

    public boolean actualizarCantidad(String id, int cambio) {
        Producto prod = buscarProducto(id);
        if (prod == null) {
            return false;
        }
        int nuevaCantidad = prod.getCantidad() + cambio;
        if (nuevaCantidad < 0) {
            return false; // No puede ser negativo
        }
        prod.setCantidad(nuevaCantidad);
        return true;
    }

    public void eliminarProducto(String id) {
        productos.removeIf(p -> p.getId().equalsIgnoreCase(id));}
}