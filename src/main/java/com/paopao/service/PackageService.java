package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.common.Const;
import com.paopao.convert.PackageConvert;
import com.paopao.dao.PackageMapper;
import com.paopao.param.PackageParam;
import com.paopao.po.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by joker on 13/08/2018.
 */

@Service
public class PackageService {




    @Autowired
    private PackageMapper packageMapper;


    public List<Package> listByUserId(Integer userId, Integer pageNum, Integer pageSize) {
        return packageMapper.selectByUserId(userId, (pageNum-1)*pageSize, pageSize);
    }


    public Package addPackage(PackageParam packageParam) {
        Package pack = PackageConvert.of(packageParam);
        pack.setStatus(Const.PackageStatus.WAIT.getCode());

        int ans = packageMapper.insert(pack);
        Preconditions.checkArgument(ans > 0, "新增包裹失败");

        return pack;

    }


    public void  deletePackage(Integer packageId, Integer userId) {
        Preconditions.checkNotNull(packageId, "请传入包裹id");
        Preconditions.checkNotNull(userId, "请传入用户id");
        int ans = packageMapper.updateStatus(packageId, userId, Const.PackageStatus.CANCEL.getCode());
        Preconditions.checkArgument(ans > 0, "删除包裹失败");


    }

    public Package findPackageById(Integer packageId, Integer userId) {
        Preconditions.checkNotNull(packageId, "请传入包裹id");
        Preconditions.checkNotNull(userId, "请传入用户id");
        Package ans = packageMapper.selectByIdAndUserId(packageId, userId);
        Preconditions.checkNotNull(ans, "没有找到相关包裹");

        return ans;
    }

    public void updateDetail(Integer packageId, PackageParam packageParam) {
        Package pack = PackageConvert.of(packageParam);
        pack.setId(packageId);
        int ans = packageMapper.updateByIdAndUserId(pack);
        Preconditions.checkArgument(ans > 0, "更新失败");

    }


    //manager
    public Package detail(Integer packageId) {

        Preconditions.checkNotNull(packageId, "请传入包裹id");
        Package pack = packageMapper.selectByPrimaryKey(packageId);
        Preconditions.checkNotNull(pack, "没有找到相关包裹");

        return pack;
    }

    public List<Package> list() {
        return packageMapper.selectList();
    }



}
