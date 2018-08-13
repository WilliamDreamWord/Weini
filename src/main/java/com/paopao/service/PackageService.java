package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.common.Const;
import com.paopao.convert.PackageConvert;
import com.paopao.dao.PackageMapper;
import com.paopao.param.PackageParam;
import com.paopao.po.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joker on 13/08/2018.
 */

@Service
public class PackageService {


//    DROP TABLE IF EXISTS `paopao_package`;
//    CREATE TABLE `paopao_package` (
//            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
//            `name` varchar(100) NOT NULL COMMENT '包裹名称',
//            `address` varchar(100) NOT NULL comment '包裹取货地址',
//            `detail` text COMMENT '包裹详细叙述',
//            `price` decimal(20,2) NOT NULL COMMENT '价格,单位-元保留两位小数',
//            `code` varchar(100) NOT NULL COMMENT '提货码',
//            `package_type` int(11) NOT NULL COMMENT '包裹类型， 1-小件 2-大件 3-超大件',
//            `status` int(6) DEFAULT '1' COMMENT '包裹状态.1-待取 2-取消',
//            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
//            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
//    PRIMARY KEY (`id`)
//    ) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;


    @Autowired
    private PackageMapper packageMapper;





    public boolean addPackage(PackageParam packageParam) {
        Package pack = PackageConvert.of(packageParam);
        pack.setStatus(Const.PackageStatus.WAIT.getCode());
        int ans = packageMapper.insert(pack);
        Preconditions.checkArgument(ans > 0, "新增包裹失败");

        return true;
    }


    public boolean  deletePackage(int id) {
        int ans = packageMapper.updateStatus(id, Const.PackageStatus.CANCEL.getCode());
        Preconditions.checkArgument(ans > 0, "删除包裹失败");

        return true;

    }

    public Package findPackageById(int id) {
        Package ans = packageMapper.selectByPrimaryKey(id);
        Preconditions.checkNotNull(ans, "没有找到相关包裹");

        return ans;
    }

    public boolean updateDetail(Package pack) {
        int ans = packageMapper.updateByPrimaryKeySelective(pack);
        Preconditions.checkArgument(ans > 0, "更新失败");

        return true;
    }


}
