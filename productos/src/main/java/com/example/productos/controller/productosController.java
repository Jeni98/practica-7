package com.example.productos.controller;

import com.example.productos.model.ProductosTable;
import com.example.productos.repository.ProductosTableRepository;
import com.example.productos.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/service")
public class ProductosController {
    @Autowired
    private ProductosService productosService;


    @GetMapping("/api/productos")
    public List<ProductosTable> getProductos() {
        return productosService.getProductos();
    }

    //añadir
    @PostMapping("/saveProducto")
    public ProductosTable addProductos(@RequestBody ProductosTable request){

        return productosService.addProductos(request);
    }

    @PutMapping("/updateProducto")
    public ProductosTable updateProductos(@RequestBody ProductosTable request){

        return productosService.updateProductos(request);
    }

    @DeleteMapping("/deleteProducto/{codprod}")
    public ResponseEntity<String> deleteProductos(@PathVariable String Marca){

        //Eliminar
        String resp = productosService.deleteProductos("codprod");
        if("OK".equalsIgnoreCase(resp)){
            return new ResponseEntity<>(resp,HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
        }
    }


}
