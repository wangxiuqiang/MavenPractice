package com.validator;

import com.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

/**
 * Created by wxq on 17-7-26.
 */
public class ProductValidator implements Validator {


    public boolean supports(Class<?> klass){
        return Product.class.isAssignableFrom(klass);
    }


    public void validate(Object target , Errors errors){
        Product product = (Product) target;
        ValidationUtils.rejectIfEmpty(errors,"name","productname.required","null");
        ValidationUtils.rejectIfEmpty(errors,"price","price.required");
        ValidationUtils.rejectIfEmpty(errors,"productionDate","productiondate.required");
        Float price = product.getPrice();
        if( price != null && price < 0){
            errors.rejectValue("price","price.negative");

        }
        Date productionDate = product.getProductionDate();
        if(productionDate != null){
            if(productionDate.after(new Date())){
                System.out.print("salah lagi");
                errors.rejectValue("productionDate","productiondate.invalid");

            }
        }
    }


}
