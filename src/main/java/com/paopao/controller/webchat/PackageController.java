package com.paopao.controller.webchat;

import com.paopao.common.JsonResponse;
import com.paopao.param.PackageParam;
import com.paopao.po.Package;
import com.paopao.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joker on 13/08/2018.
 */

@RestController
@RequestMapping("/package/")
public class PackageController {


    @Autowired
    private PackageService packageService;



    @RequestMapping("add.do")
    public JsonResponse<String> add(PackageParam packageParam) {

        packageService.addPackage(packageParam);

        return JsonResponse.createBySuccessMsg("添加成功");
    }

    @RequestMapping("delete.do")
    public JsonResponse<String> delete(Integer packageId) {

        packageService.deletePackage(packageId);

        return JsonResponse.createBySuccessMsg("删除成功");
    }

    @RequestMapping("select.do")
    public JsonResponse<Package> select(Integer packageId) {

        Package pack = packageService.findPackageById(packageId);

        return JsonResponse.createBySuccess(pack);
    }


    // TODO: 15/08/2018 修改参数
    @RequestMapping("update.do")
    public JsonResponse<String> update(Integer packageId, PackageParam packageParam) {


        packageService.updateDetail(packageId, packageParam);

        return JsonResponse.createBySuccess("更新成功");
    }




}
