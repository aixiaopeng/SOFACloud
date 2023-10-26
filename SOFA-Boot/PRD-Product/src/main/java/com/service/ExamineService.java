package com.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.Examine;

public interface ExamineService extends IService<Examine> {
    String addExam(Examine examine);

    Page<Examine> ListManageProduct(int page, int pageSize);
}
