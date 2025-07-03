package com.example.smart_inventory_app.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smart_inventory_app.dto.supplier.SupplierDTO;
import com.example.smart_inventory_app.model.Supplier;
import com.example.smart_inventory_app.repository.SupplierRepository;


@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    ModelMapper mp;

    @Autowired
    SupplierRepository repo;
    
    public SupplierDTO createSupplier(SupplierDTO supplierDTO){
        Supplier request = mp.map(supplierDTO,Supplier.class);
        Optional<Supplier> existingSupplier = repo.findBySupplierMail(request.getSupplierMail());
        if(existingSupplier.isPresent()){
            return mp.map(existingSupplier.get(),SupplierDTO.class);
        }
        repo.save(request);
        return mp.map(request,SupplierDTO.class);

    }


     public List<SupplierDTO> getSuppliers(){
        List <SupplierDTO> list = new ArrayList<>();
        for(Supplier supplier : repo.findAll()){
            list.add(mp.map(supplier,SupplierDTO.class));
        }

        return list;
    }

}
