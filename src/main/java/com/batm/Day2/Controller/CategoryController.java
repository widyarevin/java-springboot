package com.batm.Day2.Controller;

import com.batm.Day2.entities.Category;
import com.batm.Day2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    // instance object dari Service
    @Autowired
    private CategoryService categoryService;

    // get all
    @GetMapping
    public String categoryIndex(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        return "category/category-index";
    }


    //delete
    //category/delete/1
    //@DeleteMapping("/category-delete/{id}")
    @PostMapping("delete/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryService.deleteCategoryById(id);
        return "redirect:/category";
    }

    //form save
    //category-form
    //category/form/1
    @GetMapping(value = {"form","form/id"})
    public String categoryForm(@PathVariable(required = false) Integer Id, Model model){
        if(Id != null){
            model.addAttribute("category", categoryService.findCategoryById(Id));
        } else {
            model.addAttribute("category", new Category());
        }
        return "category/category-form";
    }


    //save
    //category/save
    //@RequestMapping("/save")
    @PostMapping("save")
    public String saveCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/category";
    }


//    @GetMapping
//    public String updateCategory(Model model, int id){
//        model.addAttribute("categoryUpdate", categoryService.findCategoryById(id));
//        return "category/category-update";
//    }

}
