package com.paopao.controller.web;

import com.paopao.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joker on 15/08/2018.
 */
@RestController
@RequestMapping("/manager/package/")
public class PackageManagerController {

    @Autowired
    private PackageService packageService;

//    @PostMapping("detail.do")
//    public JsonResponse getDetail(Integer packageId) {
//
//        return JsonResponse.createBySuccess(packageService.detail(packageId));
//
//    }
//
//    @PostMapping("list.do")
//    public JsonResponse getList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
//                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
//
//        return JsonResponse.createBySuccess(packageService.list());
//    }



}
