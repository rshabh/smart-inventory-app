package com.example.smart_inventory_app.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smart_inventory_app.dto.product.ProductRequestDTO;
import com.example.smart_inventory_app.dto.product.ProductResponseDTO;
import com.example.smart_inventory_app.dto.supplier.SupplierDTO;
import com.example.smart_inventory_app.model.Product;
import com.example.smart_inventory_app.repository.ProductRepository;

@Service
public class ProductserviceImpl implements ProductService {

    @Autowired
    ProductRepository repo;

    @Autowired
    ModelMapper mp;

    @Autowired
    SupplierServiceImpl supplierService;


    public ProductResponseDTO createProduct(ProductRequestDTO request){
        Product product = mp.map(request,Product.class);
        Optional<Product> existingProduct = repo.findByName(product.getName());
        if(existingProduct.isPresent()){
            return mp.map(product,ProductResponseDTO.class);
        }
        SupplierDTO temp = request.getSupplierdto();
        supplierService.createSupplier(temp);
        repo.save(product);
        return(mp.map(product,ProductResponseDTO.class));
    }


    public List<ProductResponseDTO> getProducts(){
        List <ProductResponseDTO> list = new ArrayList<>();
        for(Product product : repo.findAll()){
            list.add(mp.map(product,ProductResponseDTO.class));
        }

        return list;
    }


    
}