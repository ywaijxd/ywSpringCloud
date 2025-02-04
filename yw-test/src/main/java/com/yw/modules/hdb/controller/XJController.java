package com.yw.modules.hdb.controller;

import com.yw.modules.hdb.entity.InquirySheetEntity;
import com.yw.modules.hdb.entity.test;
import com.yw.service.XJService;
import com.yw.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 询价接口
 * @Author: yewei
 * @Date: 2019/10/27 18:02
 */
@RestController
@RequestMapping("/xj")
public class XJController {
    @Autowired
    private XJService xjService;

    /**
     *
     * @param inquiryStatus
     * @param transportModeId
     * @param inOut
     * @return
     */
    @RequestMapping("/queryInquirySheets/{inquiryStatus}/{transportModeId}/{inOut}")

    public JsonResult<List<InquirySheetEntity>>  queryInquirySheets(@PathVariable("inquiryStatus") String inquiryStatus,
                                                                    @PathVariable("transportModeId") String transportModeId ,
                                                                    @PathVariable("inOut") String inOut){
        List<InquirySheetEntity> list =xjService.findall( inquiryStatus,transportModeId,inOut);

        return JsonResult.err();

    }

    @PostMapping("/ss/")
    public JsonResult  Test(@RequestBody test s ){

        return JsonResult.ok(s).msg("ok");
    }
}
