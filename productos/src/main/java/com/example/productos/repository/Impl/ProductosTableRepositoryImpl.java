package com.example.productos.repository.Impl;

import com.example.productos.model.ProductosTable;
import com.example.productos.repository.ProductosTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductosTableRepositoryImpl implements ProductosTableRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<ProductosTable> getProductos() {
        List<ProductosTable> ltProductos=null;
        ltProductos = jdbcTemplate.query("SELECT * FROM PRODUCTOS",(rs,rowNUM)->
                new ProductosTable(
                        rs.getString("COD_PROD"),
                        rs.getString("MARCAS"),
                        rs.getString("PRODUCTO"),
                        rs.getBigDecimal("PRECIO")
                )
        );
        return ltProductos;
    }

    @Override
    public ProductosTable addProductos(ProductosTable request) {
        int cantRegUpd = jdbcTemplate.update("INSERT INTO PRODUCTOS ('COD_PROD','MARCAS','PRODUCTO','PRECIO') VALUES(?,?,?,?)",
                request.getCodprod(),request.getMarcas(),request.getProducto(),request.getPrecio());
        System.out.println("cantRegUpd"+cantRegUpd);
        return request;
    }

    @Override
    public ProductosTable updateProductos(ProductosTable request) {
        int cantRegUpd = jdbcTemplate.update("UPDATE PRODUCTOS SET MARCAS=?,PRODUCTO=?,PRECIO=? WHERE COD_PROD=?",
                request.getCodprod(),request.getMarcas(),request.getProducto(),request.getPrecio());
        System.out.println("cantRegUpd"+cantRegUpd);
        return request;
    }

    @Override
    public String deleteProductos(String codprod) {
        int cantRegUpd = jdbcTemplate.update("DELETE FROM PRODUCTOS WHERE COD_PROD=?", codprod);
        System.out.println("cantRegUpd"+cantRegUpd);
        if(cantRegUpd>0){
            return "OK";
        }else{
            return "NOT FOUND";
        }
    }


}
