package com.controller;


import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.entity.Category;
import com.mapper.CategoryMapper;
import com.service.CategoryService;
import com.result.Result;
import com.utils.NowTime;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/category")
@CrossOrigin(origins ="*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @PostMapping("/add")
    public Result addCategory(@RequestBody Category category){

        Category category1 = categoryService.lambdaQuery().eq(Category::getCategoryName, category.getCategoryName()).one();
        if(!Objects.isNull(category1)){
            return Result.fail("商品类型已存在");
        }

        categoryService.saveOrUpdate(category);
        return Result.ok("添加成功");
    }


    @GetMapping("/list")
    public Result listAllCategory(){

        // 使用 LambdaQueryChainWrapper 查询
        List<Category> result = new LambdaQueryChainWrapper<>(categoryMapper).isNull(Category::getDeletedAt).list();
         return Result.ok(result);
    }

    @DeleteMapping("/delete")
    public Result deleteCategory(@PathVariable Long id){
        Category category= categoryService.getById(id);
        category.setDeletedAt(NowTime.setNowTime());
        categoryService.updateById(category);
        return Result.ok("删除成功");
    }


}
