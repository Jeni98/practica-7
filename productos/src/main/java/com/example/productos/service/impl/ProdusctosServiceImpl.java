package com.example.productos.service.impl;

import com.example.productos.model.ProductosTable;
import com.example.productos.repository.ProductosTableRepository;
import com.example.productos.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdusctosServiceImpl implements ProductosService {
    @Autowired
    private ProductosTableRepository productosTableRepository;


    @Override
    public List<ProductosTable> getProductos() {
        return productosTableRepository.getProductos();
    }

    @Override
    public ProductosTable addProductos(ProductosTable request) {
        return productosTableRepository.addProductos(request);
    }

    @Override
    public ProductosTable updateProductos(ProductosTable request) {
        return productosTableRepository.updateProductos(request);
    }

    @Override
    public String deleteProductos(String codprod) {
        return productosTableRepository.deleteProductos(codprod);
    }
}
