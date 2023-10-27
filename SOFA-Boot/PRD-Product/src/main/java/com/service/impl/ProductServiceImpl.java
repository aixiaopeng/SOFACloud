package com.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Product;
import com.entity.vo.ShoppingCartVO;
import com.result.Result;
import com.service.ExamineService;
import com.service.ProductService;
import com.mapper.ProductMapper;
import com.utils.NowTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 15012
 * @description 针对表【product】的数据库操作Service实现
 * @createDate 2023-10-22 12:34:08
 */
@Service
//@SofaService(interfaceType = ProductService.class, bindings = {
//        @SofaServiceBinding(bindingType = "bolt")
//})
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ExamineService examineService;

    @Override
    public Page<Product> listAllProduct(int page, int pageSize, int sorted,Long categoryId) {
        // 创建分页对象
        Page<Product> productPage = new Page<>(page, pageSize);


        // 使用 LambdaQueryChainWrapper 查询
        LambdaQueryChainWrapper<Product> queryWrapper = new LambdaQueryChainWrapper<>(productMapper)
                .isNull(Product::getDeletedAt);

        if (sorted == 1) { //根据销量降序排序
            queryWrapper.orderByDesc(Product::getSold);
        } else if (sorted == 2) {  //根据销量升序序排序
            queryWrapper.orderByAsc(Product::getSold);
        } else if (sorted==3) {   //根据价格降序
            queryWrapper.orderByDesc(Product::getPrice);
        } else if (sorted==4) {   //根据价格升序
            queryWrapper.orderByAsc(Product::getPrice);
        }

        if (categoryId != 0) {
            queryWrapper.eq(Product::getCategory, categoryId);
        }


        return queryWrapper.page(productPage);
    }

    @Override
    public Page<Product> listAllCountProduct(int page, int pageSize) {

        // 创建分页对象
        Page<Product> productPage = new Page<>(page, pageSize);
        Page<Product> products = new LambdaQueryChainWrapper<>(productMapper).isNull(Product::getDeletedAt).ge(Product::getDiscountEnd, NowTime.setNowTime()).page(productPage);

        return products;
    }

    @Override
    public List<Product> listPic() {
       List<Product> products= new LambdaQueryChainWrapper<>(productMapper).isNull(Product::getDeletedAt).orderByDesc(Product::getPriority).last("LIMIT 5").list();
        return products;
    }

    @Override
    public Page<Product> listAllNewProduct(int page, int pageSize) {

        Page<Product> productPage = new Page<>(page, pageSize);
        Page<Product> productPage1= new LambdaQueryChainWrapper<>(productMapper).isNull(Product::getDeletedAt).orderByDesc(Product::getUpdatedAt).page(productPage);
        return productPage1;
    }


    public Page<Product> ListManageProduct(int page,int pageSize,String name){
        Page<Product> pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Product> lqw=new LambdaQueryWrapper<Product>();
        lqw.like(Product::getName,name).orderByDesc(Product::getCreatedAt);
        Page<Product> publicPage = this.page(pageInfo, lqw);
        return publicPage;
    }
    public Result getProduct(Long id){
        Product product = this.getById(id);
        return product.getStatus()==1? Result.ok(product):Result.fail("商品未下线，请先下线再编辑！");
        //return this.getById(id);
    }
    public String editProduct(Product product){
        this.saveOrUpdate(product);
        return "修改成功";
    }

    public String ExamSuccess(Long id,String s){
        Product product = this.getById(id);
        product.setStatus(4);
        product.setNotes(s);
        examineService.removeById(id);
        this.saveOrUpdate(product);
        return "审核成功！";
    }

    public String ExamFail(Long id,String s){
        Product product = this.getById(id);
        product.setStatus(0);
        product.setNotes(s);
        examineService.removeById(id);
        this.saveOrUpdate(product);
        return "未通过审核,请重新编辑！";
    }

    public String downlineProduct(Long id){
        Product product = this.getById(id);
        product.setStatus(0);
        this.saveOrUpdate(product);
        return "成功下线商品";
    }
    /**
     * 审核成功后上线商品
     * @param id
     * @return
     */
    public String uplineProduct(Long id){
        Product product = this.getById(id);
        if(product.getStatus()!=4){
            return "请先通过审核再上线！！！";
        }
        product.setStatus(1);
        this.saveOrUpdate(product);
        return "成功上线该商品";
    }

    @Override
    public List<ShoppingCartVO> listProductByIds(List<Long> ids) {
        LambdaQueryWrapper<Product> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.in(Product::getId,ids);



        List<Product> products= productMapper.selectList(queryWrapper);

        List<ShoppingCartVO> shoppingCartVOS = products.stream()
                .map(product -> {
                    ShoppingCartVO cartVO = new ShoppingCartVO();
                    cartVO.setImgUrl(product.getImgurl());
                    cartVO.setName(product.getName());
                    cartVO.setDescription(product.getDescription());
                    cartVO.setPrice(product.getPrice());
                    cartVO.setDiscountPrice(product.getDiscountPrice());
                    cartVO.setCreatedAt(NowTime.setNowTime());
                    cartVO.setProductId(product.getId());
                    return cartVO;
                })
                .collect(Collectors.toList());

        return shoppingCartVOS;
    }

    public String makeDraft(Product product){
        product.setStatus(2);
        this.save(product);
        return "保存草稿成功";
    }
    /*public String sendToExamine(Long id,String s){
        Product product = getById(id);
        product.setStatus(3);   //status=3为审核中
        product.setNotes(s);
        Examine examine = examineService.getById(id);
        BeanUtils.copyProperties(product,examine);
        return "已发起审核请求，请等待审核";
    }*/

}




