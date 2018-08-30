package com.paopao.convert;

import com.paopao.param.PackageParam;
import com.paopao.po.Package;
import com.paopao.util.BeanValidator;

/**
 * Created by joker on 13/08/2018.
 */
public class PackageConvert {

    public static Package of(PackageParam packageParam) {
        //convert里进行参数校验
        BeanValidator.check(packageParam);

        Package pack = new Package();
        pack.setUserId(packageParam.getUserId());
        pack.setName(packageParam.getName());
        pack.setAddress(packageParam.getAddress());
        pack.setCode(packageParam.getCode());
        pack.setDetail(packageParam.getDetail());
        pack.setPrice(packageParam.getPrice());
        pack.setPackageType(packageParam.getPackageType());
        pack.setExceptTime(packageParam.getExceptTime());
        
        return pack;
    }


}
