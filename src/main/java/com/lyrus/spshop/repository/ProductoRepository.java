package com.lyrus.spshop.repository;

import com.lyrus.spshop.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
