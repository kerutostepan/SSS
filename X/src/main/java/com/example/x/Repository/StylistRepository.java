package com.example.x.Repository;

import com.example.x.Model.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StylistRepository extends JpaRepository<Stylist, Long> {
}
