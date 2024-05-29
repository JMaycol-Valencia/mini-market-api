package com.ministore.persistence.crud;

import com.ministore.persistence.entity.Producto;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //uso de QUERY NATIVO
    //@Query(value = "SELECT * FROM products WHERE id_categoria = ?", nativeQuery = true)

    //uso de QUERY METHODS
    //ORDENAR POR CATEGORIA
    List<Producto> findByIdCategoria(int idCategoria);

    //ORDENAR POR CATEGORIA Y EN ORDEN ASENDENTE O ALFABETICO
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //USANDO OPTIONLES para obtener la cantidad que tenemos en stock
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
