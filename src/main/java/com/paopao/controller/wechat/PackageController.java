package com.paopao.controller.wechat;

import com.paopao.common.Const;
import com.paopao.common.JsonResponse;
import com.paopao.param.PackageParam;
import com.paopao.po.Package;
import com.paopao.po.WeChatUser;
import com.paopao.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by joker on 13/08/2018.
 */

@RestController
@RequestMapping("/wechat/package/")
public class PackageController {


    @Autowired
    private PackageService packageService;



    @PostMapping("add.do")
    public JsonResponse<String> add(PackageParam packageParam,HttpSession httpSession) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        packageParam.setUserId(weChatUser.getId());
        packageService.addPackage(packageParam);

        return JsonResponse.createBySuccessMsg("添加成功");
    }

    @PostMapping("delete.do")
    public JsonResponse<String> delete(Integer packageId, HttpSession httpSession) {

        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        packageService.deletePackage(packageId, weChatUser.getId());

        return JsonResponse.createBySuccessMsg("删除成功");
    }

    @PostMapping("select.do")
    public JsonResponse<Package> select(Integer packageId, HttpSession httpSession) {
        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        Package pack = packageService.findPackageById(packageId, weChatUser.getId());

        return JsonResponse.createBySuccess(pack);
    }


    @PostMapping("update.do")
    public JsonResponse<String> update(Integer packageId, PackageParam packageParam, HttpSession httpSession) {

        WeChatUser weChatUser = (WeChatUser) httpSession.getAttribute(Const.CURRENT_WECHAT_USER);
        packageParam.setUserId(weChatUser.getId());
        packageService.updateDetail(packageId, packageParam);

        return JsonResponse.createBySuccess("更新成功");
    }




}
