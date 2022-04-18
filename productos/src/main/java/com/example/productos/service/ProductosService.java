package com.example.productos.service;

import com.example.productos.model.ProductosTable;

import java.util.List;

public interface ProductosService {
    public List<ProductosTable> getProductos();

    public ProductosTable addProductos(ProductosTable request);

    public  ProductosTable updateProductos(ProductosTable request);

    public String deleteProductos(String codprod);

}
