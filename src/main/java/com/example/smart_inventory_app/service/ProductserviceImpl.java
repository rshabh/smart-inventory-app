package com.example.smart_inventory_app.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.smart_inventory_app.dto.product.ProductDTO;
import com.example.smart_inventory_app.model.Product;
import com.example.smart_inventory_app.repository.ProductRepository;

@Service
public class ProductserviceImpl implements ProductService {
    @Autowired
    ProductRepository repo;

    @Autowired
    ModelMapper mp;

    public ProductDTO createProduct(ProductDTO productDTO){

         Product product = mp.map(productDTO,Product.class);
         Product savedProduct = repo.save(product);
         return mp.map(savedProduct,ProductDTO.class);

    }


    public ProductDTO updateProduct(int id , ProductDTO productDTO){
            Product product = mp.map(productDTO,Product.class);
            Product product2;
            Optional<Product> op = repo.findById(id);
            
            
            if(op.isPresent()){
               product2 = op.get();
            }else{
                return null;
            }

            product2.setName(product.getName());
            product2.setPrice(product.getPrice());
            product2.setQuantity(product.getQuantity());
            product2.setCategory(product.getCategory());
            product2.setSupplier(product.getSupplier());
            product2.setSupplierMail(product.getSupplierMail());

            repo.save(product2);

            return mp.map(product2,ProductDTO.class);

    }



    public void deleteProduct(int id){
        Optional<Product> op = repo.findById(id);
        Product pd = null;
        
        if(op.isPresent()){pd = op.get();repo.delete(pd);}

    }


    public List<ProductDTO> getAllProducts(){
        List<ProductDTO> l = new ArrayList<>();
        for(Product pd : repo.findAll()){
            l.add(mp.map(pd,ProductDTO.class));
        }
        return l;
    }


    public List<ProductDTO> getProductsBelowPriceThreshold(int threshold){
        List<ProductDTO> l = new ArrayList<>();
        for(Product pd : repo.findAll()){
            if(pd.getPrice()<=threshold){
                l.add(mp.map(pd,ProductDTO.class));
            }
        }

        return l;
    }



    public List<ProductDTO> getProductsByCategory(String category){
        List<ProductDTO> l = new ArrayList<>();
        for(Product pd : repo.findAll()){
            if(pd.getCategory().equals(category)){
                l.add(mp.map(pd,ProductDTO.class));
            }
        }

        return l;
    }

}
