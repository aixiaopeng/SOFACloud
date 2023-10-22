package com.controller;


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

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/add")
    public Result addProduct(@RequestBody Product product){
        productService.saveOrUpdate(product);
        return Result.ok("添加商品成功");
    }

    @GetMapping("list")
    public Result listAllProduct( @RequestParam(name = "page", defaultValue = "1",required = false) int page,
                                  @RequestParam(name = "pageSize", defaultValue = "10",required = false) int pageSize,
                                  @RequestParam(name = "sortedByNum", defaultValue = "0",required = false) int sorted){
        // 创建分页对象
        Page<Product> productPage = new Page<>(page, pageSize);

        Page<Product>  products=null;
        // 使用 LambdaQueryChainWrapper 查询
        if(sorted==1){  //为1就根据数量排序
           products = new LambdaQueryChainWrapper<>(productMapper).isNull(Product::getDeletedAt).orderByDesc(Product::getNum).page(productPage);
        } else if (sorted==2) {   //2就是根据销量排序
            products = new LambdaQueryChainWrapper<>(productMapper).isNull(Product::getDeletedAt).orderByDesc(Product::getSold).page(productPage);
        }else {
            products = new LambdaQueryChainWrapper<>(productMapper).isNull(Product::getDeletedAt).page(productPage);
        }
        return Result.ok(products);
    }

    @PostMapping("delete")
    public Result delete(Long id){
        Product product = productService.getById(id);
        product.setDeletedAt(NowTime.setNowTime());
        productService.updateById(product);
        return Result.ok("删除成功");
    }
}
