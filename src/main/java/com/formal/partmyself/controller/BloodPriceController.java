package com.formal.partmyself.controller;


import com.formal.partmyself.pojo.entity.BloodPrice;
import com.formal.partmyself.pojo.entity.BloodStocks;
import com.formal.partmyself.service.BloodPriceService;
import com.formal.partmyself.service.BloodStocksService;
import com.formal.partmyself.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author FZX
 * @since 2022-08-06
 */
@Controller
@RequestMapping("//bloodPrice")
public class BloodPriceController {
    @Autowired
    private BloodPriceService bloodPriceService;
    /**
     *  获取所有的血液价格
     *@return
     */
    @ResponseBody
    @GetMapping("/getBloodPrice")
    public Result getBloodPrice() {
        List<BloodPrice> bloodList= bloodPriceService.listBloodPrice();
        if (bloodList != null) {
            System.out.println(bloodList);
            return Result.success(bloodList);
        } else {
            return Result.fail();
        }
    }
}

