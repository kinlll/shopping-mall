package com.example.shoppingmall.web.admin;

import com.example.shoppingmall.po.MemberProduct;
import com.example.shoppingmall.po.Scategory;
import com.example.shoppingmall.service.admin.MemberProductService;
import com.example.shoppingmall.service.admin.ScategoryService;
import com.example.shoppingmall.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/scategory")
public class ScategoryController {

    @Autowired
    private ScategoryService scategoryService;

    @Autowired
    private MemberProductService memberProductService;

    //分页查询类型
    @ResponseBody
    @GetMapping("/scategoryPage")
    public AjaxResult scategoryPage(@PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        AjaxResult result = new AjaxResult();
        try {
           Page<Scategory> scategories = scategoryService.getAll(pageable);
           result.setPage(scategories);
           result.setSuccess(true);
        }catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("查询小分类失败");
            e.printStackTrace();
        }
        return result;
    }


    //编辑类型
    @ResponseBody
    @GetMapping("editScategory")
    public AjaxResult editScategory(@RequestParam Integer sacategoryId,
                                    @PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable){
        AjaxResult result = new AjaxResult();
        try {
            Scategory scategory = scategoryService.getById(sacategoryId);
            Page<MemberProduct> memberProducts = memberProductService.getAll(pageable);
            scategory.setMemberProductPage(memberProducts);

            result.setData(scategory);
            result.setSuccess(true);
        }catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("编辑小分类失败");
            e.printStackTrace();
        }
        return result;
    }


    //添加类型
    @ResponseBody
    @PostMapping("/addScategory")
    public AjaxResult addScategory(Scategory scategory, HttpSession session){
        AjaxResult result = new AjaxResult();
        try {
            Scategory scategory1 = scategoryService.getByName(scategory.getName());
            if (scategory1 != null){
                result.setSuccess(false);
                result.setMessage("类型已存在");
                return result;
            }

            MultipartFile fileimg = scategory.getFileimg();
            String fileName = fileimg.getOriginalFilename(); //获得图片名称
            String suffix = fileName.substring(fileName.lastIndexOf(".")); //获得图片后缀  如: .jpg
            String random = UUID.randomUUID().toString();
            String pathName = random + suffix;

            String path = session.getServletContext().getRealPath("pics");
            String iconPath = path + pathName;

            fileimg.transferTo(new File(iconPath));

            scategory.setIconpath(pathName);

            scategoryService.add(scategory);


        }catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("编辑小分类失败");
            e.printStackTrace();
        }
        return result;
    }


}
