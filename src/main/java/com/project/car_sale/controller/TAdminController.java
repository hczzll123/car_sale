package com.project.car_sale.controller;


import com.project.car_sale.config.RetVal;
import com.project.car_sale.entity.TAdmin;
import com.project.car_sale.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author heyuan
 * @since 2020-03-12
 */
@RestController
@RequestMapping("/admin")
public class TAdminController {

    @Autowired
    TAdminService tAdminService;


    @PostMapping("save")
    public RetVal saveAdmin(){
        TAdmin tAdmin = new TAdmin();


        tAdmin.setLoginAcct("heyuan1");
        tAdmin.setUserPswd("123456");
        tAdmin.setUserName("何源");


        for (int i = 0; i < 10; i++) {

            tAdminService.save(tAdmin);
        }

        return RetVal.success();

    }

    @DeleteMapping("{id}")
    public RetVal deleteById(@PathVariable String id){

        boolean flag = tAdminService.removeById(id);

        if(flag){
            return RetVal.success();
        }else {
            return RetVal.error();
        }

    }

    @GetMapping
    public RetVal getAllAdmin(){

        List<TAdmin> tAdmins = tAdminService.list(null);

        return RetVal.success().data("adminList",tAdmins);
    }

    @PutMapping
    public RetVal updateAdmin(TAdmin tAdmin){


        boolean flag = tAdminService.updateById(tAdmin);

        if(flag){
            return RetVal.success();
        }else {
            return RetVal.error();
        }
    }

}

