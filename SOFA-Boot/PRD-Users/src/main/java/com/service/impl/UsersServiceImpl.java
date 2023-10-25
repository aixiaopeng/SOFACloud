package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Users;
import com.entity.vo.LoginUser;
import com.result.Result;
import com.service.UsersService;
import com.mapper.UsersMapper;
import com.utils.NowTime;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author 15012
* @description 针对表【users】的数据库操作Service实现
* @createDate 2023-10-22 21:33:45
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

    @Override
    public void addUser(Users user) {
        user.setRole("manager");
        this.saveOrUpdate(user);
    }

    @Override
    public Users getPublic(Long id) {
        LambdaQueryWrapper<Users> lqw=new LambdaQueryWrapper<>();
        lqw.eq(Users::getRole,"public").eq(Users::getId,id);
        Users one = getOne(lqw);
        return one;
    }

    @Override
    public Users getManager(Long id) {
        LambdaQueryWrapper<Users> lqw=new LambdaQueryWrapper<>();
        lqw.eq(Users::getRole,"manager").eq(Users::getId,id);
        Users one = getOne(lqw);
        return one;
    }

    @Override
    public Page<Users> list(int page, int pageSize,int isPublic) {
        Page<Users> pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Users> lqw=new LambdaQueryWrapper<Users>();
        if(isPublic==1){
            lqw.eq(Users::getRole,"public").isNull(Users::getDeletedAt).orderByDesc(Users::getCreatedAt);
        }else{
            lqw.eq(Users::getRole,"manager").isNull(Users::getDeletedAt).orderByDesc(Users::getCreatedAt);
        }
        Page<Users> publicPage = this.page(pageInfo, lqw);
        return publicPage;
    }

    @Override
    public Page<Users> listManager(int page, int pageSize) {
        Page<Users> pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Users> lqw=new LambdaQueryWrapper<>();
        lqw.eq(Users::getRole,"manager").isNull(Users::getDeletedAt).orderByDesc(Users::getCreatedAt);
        Page<Users> managerPage = this.page(pageInfo, lqw);
        return managerPage;
    }

    @Override
    public Boolean updateUsers(Users user) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginUser userDetails= (LoginUser) principal;
        Long userId=userDetails.getUserId();

        if(userDetails.getRole().equals("superadminsupervisor") || userId==userDetails.getUserId()){
            this.updateById(user);
            return true;
        }else {
            return false;
        }


    }

    @Override
    public void enableUserByIds(List<Long> ids) {
        List<Users> users = ids.stream().map((item) -> {
            Users user = this.getById(item);
            user.setStatus(1);
            return user;
        }).collect(Collectors.toList());
        this.saveOrUpdateBatch(users);
    }

    @Override
    public void banUserByIds(List<Long> ids) {
        List<Users> users = ids.stream().map((item) -> {
            Users user = this.getById(item);
            user.setStatus(0);
            return user;
        }).collect(Collectors.toList());
        this.saveOrUpdateBatch(users);
    }

    @Override
    public void delete(List<Long> ids) {
        LambdaQueryWrapper<Users> lqw=new LambdaQueryWrapper<>();
        lqw.eq(Users::getStatus,1).in(Users::getId,ids);


        Users updateUser = new Users();
        updateUser.setDeletedAt(NowTime.setNowTime()); // 设置deleted_at为当前时间

        this.update(updateUser,lqw);



    }
}




