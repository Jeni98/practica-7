package com.example.productos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("PRODUCTOS")
public class ProductosTable {
    private @Column("COD_PROD") String codprod;
    private @Column("MARCAS") String marcas;
    private @Column("PRODUCTO") String producto;
    private @Column("PRECIO") BigDecimal precio;
}
