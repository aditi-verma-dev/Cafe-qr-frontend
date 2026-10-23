package com.cafeqr.cafeQR.Controller;


import com.cafeqr.cafeQR.Entity.CafeTable;
import com.cafeqr.cafeQR.Service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public List<CafeTable> getAllTables() {
        return tableService.getAllTables();
    }

    @PostMapping
    public CafeTable createTable(@RequestBody CafeTable table) {
        return tableService.createTable(table);
    }
}

