package com.service;

import com.entity.QueryHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.vo.ShoppingCartVO;

import java.util.List;

/**
* @author 15012
* @description 针对表【query_history】的数据库操作Service
* @createDate 2023-10-22 21:33:45
*/
public interface QueryHistoryService extends IService<QueryHistory> {
    void addHistory(Long productId);

    List<ShoppingCartVO> listHistory();

    void deleteHistory(Long productId);
}
