package com.batm.Day2.Controller;

import com.batm.Day2.entities.Category;
import com.batm.Day2.entities.Product;
import com.batm.Day2.services.CategoryService;
import com.batm.Day2.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class productController {

    // instance object dari Service
    @Autowired
    private productService productService;

    // get all
    @GetMapping
    public String productIndex(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "category/category-index";
    }

    @DeleteMapping("/product-delete/{id}")
    public String deleteProduct(int id){
        productService.deleteProductById(id);
        return "Berhasil dihapus!";
    }

    @RequestMapping("save")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product/product-index";
    }


//    @GetMapping
//    public String updateProduct(Model model, int id){
//        model.addAttribute("productUpdate", productService.findProductById(id));
//        return "product/product-update";
//    }


}
