package com.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Examine;
import com.mapper.ExamineMapper;
import com.service.ExamineService;
import org.springframework.stereotype.Service;

@Service
//@SofaService(interfaceType = ExamineService.class,uniqueId = "${service.unique.id}",bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class ExamineServiceImpl extends ServiceImpl<ExamineMapper, Examine> implements ExamineService {

    public String addExam(Examine examine){
        this.saveOrUpdate(examine);
        return "等待审核";
    }

    public Page<Examine> ListManageProduct(int page, int pageSize){
        Page<Examine> pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Examine> lqw=new LambdaQueryWrapper<Examine>();
        lqw.orderByDesc(Examine::getCreatedAt);
        Page<Examine> publicPage = this.page(pageInfo, lqw);
        return publicPage;
    }
}
