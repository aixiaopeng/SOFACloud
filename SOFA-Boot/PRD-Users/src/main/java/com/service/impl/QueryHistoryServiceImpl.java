package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.QueryHistory;
import com.service.QueryHistoryService;
import com.mapper.QueryHistoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【query_history】的数据库操作Service实现
* @createDate 2023-10-22 21:33:45
*/
@Service
public class QueryHistoryServiceImpl extends ServiceImpl<QueryHistoryMapper, QueryHistory>
    implements QueryHistoryService{

}




