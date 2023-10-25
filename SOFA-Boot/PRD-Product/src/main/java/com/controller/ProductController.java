package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.Product;
import com.mapper.ProductMapper;
import com.result.Result;
import com.service.ProductService;
import com.utils.NowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/product")
@CrossOrigin(origins ="*")
public class ProductController {

    @Autowired
    private ProductService productService;



    @PostMapping("/add")
    public Result addProduct(@RequestBody Product product){
        productService.saveOrUpdate(product);
        return Result.ok("添加商品成功");
    }

    @GetMapping("/list/product")
    public Result listAllProduct( @RequestParam(name = "page", defaultValue = "1",required = false) int page,
                                  @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize,
                                  @RequestParam(name = "sorted", defaultValue = "0",required = false) int sorted,
                                  @RequestParam(name = "categoryId",required = false) Long categoryId){


        return Result.ok(productService.listAllProduct(page,pageSize,sorted,categoryId));
    }


    @GetMapping("/list/discount")
    public Result listAllCountProduct(@RequestParam(name = "page", defaultValue = "1",required = false) int page,
                                      @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize){


         return Result.ok(productService.listAllCountProduct(page,pageSize));

    }

    @GetMapping("/list/pic")
    public Result listPic(){
       return Result.ok(productService.listPic());
    }


    @PostMapping("/add/discount")
    public Result addDiscount(@RequestBody Product product){
        productService.updateById(product);
        return Result.ok("添加成功");
    }


    @DeleteMapping("delete")
    public Result delete(@PathVariable Long id){
        Product product = productService.getById(id);
        product.setDeletedAt(NowTime.setNowTime());
        productService.updateById(product);
        return Result.ok("删除成功");
    }
}
