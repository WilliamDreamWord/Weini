package com.paopao.convert;

import com.paopao.param.PackageParam;
import com.paopao.po.Package;
import com.paopao.util.BeanValidator;

/**
 * Created by joker on 13/08/2018.
 */
public class PackageConvert {

    public static Package of(PackageParam packageParam) {
        BeanValidator.check(packageParam);

        Package pack = new Package();
        // TODO: 13/08/2018 填充属性   
        return pack;
    }


}
