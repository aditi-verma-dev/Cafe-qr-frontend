 package com.cafeqr.cafeQR.Service;

import com.cafeqr.cafeQR.Entity.CafeTable;
import com.cafeqr.cafeQR.Repository.CafeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private CafeTableRepository cafeTableRepository;

    public CafeTable getTableById(Long id) {
        return cafeTableRepository.findById(id).orElse(null);
    }

    public List<CafeTable> getAllTables() {
        return cafeTableRepository.findAll();
    }

    public CafeTable createTable(CafeTable table) {
        return cafeTableRepository.save(table);
    }
} 
