package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.QueryHistory;
import com.entity.vo.LoginUser;
import com.service.QueryHistoryService;
import com.mapper.QueryHistoryMapper;
import com.utils.NowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public List<QueryHistory> listHistory() {
        Long userId=null;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            LoginUser userDetails = (LoginUser) principal;
            userId = userDetails.getUserId();
        }catch (Exception e){
            e.printStackTrace();
        }

       List<QueryHistory> queryHistoryList= new LambdaQueryChainWrapper<>(queryHistoryMapper).eq(QueryHistory::getUserId,userId).orderByDesc(QueryHistory::getUpdatedAt).list();

        return queryHistoryList;
    }

    @Override
    public void deleteHistory(Long productId) {
       LambdaQueryWrapper<QueryHistory> wrapper=new LambdaQueryWrapper<>();
       wrapper.eq(QueryHistory::getProductId,productId);
       this.remove(wrapper);
    }
}




