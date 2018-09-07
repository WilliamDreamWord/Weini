package com.paopao.service;

import com.paopao.common.Const;
import com.paopao.param.PackageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by joker on 13/08/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PackageServiceTest {

    @Autowired
    private PackageService packageService;


    @Test
    public void shouldAdd() {
        PackageParam packageParam = new PackageParam();
        packageParam.setName("package");
        packageParam.setUserId(23);
        packageParam.setPrice(new BigDecimal("3"));
        packageParam.setCode("OIJ341421");
        packageParam.setAddress("dfafdaf");
        packageParam.setPackageType(Const.PackageType.SMALL.getCode());
        packageParam.setPhoneMessage("短发控嗯出去哦");

        packageService.addPackage(packageParam);
    }

}
