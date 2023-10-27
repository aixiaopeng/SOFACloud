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
                                  @RequestParam(name = "categoryId",defaultValue = "0",required = false) Long categoryId){


        return Result.ok(productService.listAllProduct(page,pageSize,sorted,categoryId));
    }


    @GetMapping("/list/discount")
    public Result listAllCountProduct(@RequestParam(name = "page", defaultValue = "1",required = false) int page,
                                      @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize){


         return Result.ok(productService.listAllCountProduct(page,pageSize));

    }

    @GetMapping("/list/newproduct")
    public Result listAllNewProduct(@RequestParam(name = "page", defaultValue = "1",required = false) int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize){
        return Result.ok(productService.listAllNewProduct(page,pageSize));
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
    public Result delete(@RequestParam Long id){
        Product product = productService.getById(id);
        product.setDeletedAt(NowTime.setNowTime());
        productService.updateById(product);
        return Result.ok("删除成功");
    }

    @PutMapping("/get")
    public Result get(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Product product){
        return Result.ok(productService.editProduct(product));
    }

    @PostMapping("/downline")
    public Result downline(@PathVariable Long id){
        return Result.ok(productService.downlineProduct(id));
    }

    @PostMapping("/upline")
    public Result upline(@PathVariable Long id){
        return Result.ok(productService.uplineProduct(id));
    }

    @GetMapping("/manageList")
    public Result getManageList(@RequestParam int page,@RequestParam int PageSize,@RequestParam(required = false) String name){
        return Result.ok(productService.ListManageProduct(page,PageSize,name));
    }

    @PostMapping("/examSucc")
    public Result examSucc(@RequestParam("id") Long id,@RequestParam("note") String s){
        return Result.ok(productService.ExamSuccess(id,s));
    }

    @PostMapping("/examFail")
    public Result examFail(@RequestParam("id") Long id,@RequestParam("note") String s){
        return Result.ok(productService.ExamFail(id,s));
    }

    @PostMapping("/draft")
    public Result makeDraft(@RequestBody Product product){
        return Result.ok(productService.makeDraft(product));
    }
}
