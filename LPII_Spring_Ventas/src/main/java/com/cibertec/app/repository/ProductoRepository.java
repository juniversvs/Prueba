package com.cibertec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cibertec.app.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	@Query(value="Select p.idproducto, p.codigo, p.descripcion, p.precio_compra,"
			+"p.precio_venta, p.stock, p.idcate From producto p"
			+"where p.codigo = :codigo", nativeQuery = true)
	public Producto buscarProductoByCodigo(@Param("codigo")String codigo);

	@Query(value="Select codigo from producto order by idproducto DESC LIMIT 1", nativeQuery = true)
	public String obtenerUltimoCodigo();
}
