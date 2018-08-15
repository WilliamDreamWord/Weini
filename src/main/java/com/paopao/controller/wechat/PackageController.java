package com.paopao.controller.wechat;

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
    public JsonResponse<String> delete(Integer packageId, Integer userId) {

        packageService.deletePackage(packageId, userId);

        return JsonResponse.createBySuccessMsg("删除成功");
    }

    @RequestMapping("select.do")
    public JsonResponse<Package> select(Integer packageId, Integer userId) {

        Package pack = packageService.findPackageById(packageId, userId);

        return JsonResponse.createBySuccess(pack);
    }


    @RequestMapping("update.do")
    public JsonResponse<String> update(Package pack) {

        packageService.updateDetail(pack);

        return JsonResponse.createBySuccess("更新成功");
    }




}
