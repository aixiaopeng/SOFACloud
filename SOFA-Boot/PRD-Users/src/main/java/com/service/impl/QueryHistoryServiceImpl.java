package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.QueryHistory;
import com.entity.ShoppingCart;
import com.entity.vo.LoginUser;
import com.entity.vo.ShoppingCartVO;
import com.service.ProductService;
import com.service.QueryHistoryService;
import com.mapper.QueryHistoryMapper;
import com.utils.NowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author 15012
* @description 针对表【query_history】的数据库操作Service实现
* @createDate 2023-10-22 21:33:45
*/
@Service
public class QueryHistoryServiceImpl extends ServiceImpl<QueryHistoryMapper, QueryHistory>
    implements QueryHistoryService{

    @Autowired
    private QueryHistoryMapper   queryHistoryMapper;

    @Autowired
    private ProductService productService;

    @Override
    public void addHistory(Long productId) {
        QueryHistory queryHistory=  new LambdaQueryChainWrapper<>(queryHistoryMapper).eq(QueryHistory::getProductId,productId).isNull(QueryHistory::getDeletedAt).one();

        Long userId=null;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            LoginUser userDetails = (LoginUser) principal;
            userId = userDetails.getUserId();
        }catch (Exception e){
            e.printStackTrace();
        }

            if (Objects.isNull(queryHistory)){
                queryHistory=new QueryHistory();
                queryHistory.setUserId(userId);
                queryHistory.setProductId(productId);

        }else {
                queryHistory.setUpdatedAt(NowTime.setNowTime());
            }
        this.saveOrUpdate(queryHistory);

    }

    @Override
    public List<ShoppingCartVO> listHistory() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginUser userDetails= (LoginUser) principal;
        Long userId=userDetails.getUserId();



        List<QueryHistory> queryHistoryList = new LambdaQueryChainWrapper<>(queryHistoryMapper).isNull(QueryHistory::getDeletedAt).eq(QueryHistory::getUserId,userId).list();

        //购物车不存在
        if(queryHistoryList.size()==0){
            return null;
        }

        // 使用Stream提取productIds
        List<Long> productIds = queryHistoryList.stream()
                .map(QueryHistory::getProductId)
                .collect(Collectors.toList());




        //RPC调用商品模块
        List<ShoppingCartVO> products= productService.listProductByIds(productIds);



        return products;


    }

    @Override
    public void deleteHistory(Long productId) {
       LambdaQueryWrapper<QueryHistory> wrapper=new LambdaQueryWrapper<>();
       wrapper.eq(QueryHistory::getProductId,productId);
       this.remove(wrapper);
    }
}




