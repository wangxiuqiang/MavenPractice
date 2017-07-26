package com.controller;

import com.domain.Product;
import com.validator.ProductValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wxq on 17-7-26.
 */
@Controller
public class ProductController  {


    @RequestMapping(value="/product_input")
    public String inputProduct (Model model){
        model.addAttribute("product",new Product());
        return "ProductForm";
    }

    @RequestMapping(value="/product_save")
    public String saveProduct(@ModelAttribute Product product, BindingResult bindingResult,Model model){
        ProductValidator productValidator = new ProductValidator();
        productValidator.validate(product,bindingResult);
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return "ProductForm";
        }
        model.addAttribute("product",product);
        return "ProductDetails";
    }

}
