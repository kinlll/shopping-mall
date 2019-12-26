package com.example.shoppingmall.web.admin;

import com.example.shoppingmall.po.Category;
import com.example.shoppingmall.po.Scategory;
import com.example.shoppingmall.service.admin.CategoryService;
import com.example.shoppingmall.service.admin.ScategoryService;
import com.example.shoppingmall.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ScategoryService scategoryService;

    //分页查询大分类
    @ResponseBody
    @GetMapping("/categoryPage")
    public AjaxResult categoryPage(@PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        AjaxResult result = new AjaxResult();
        try {
            Page<Category> categories = categoryService.getAll(pageable);
            result.setPage(categories);
            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("查询分类失败");
            e.printStackTrace();
        }
        return result;
    }

    //编辑大分类
    @ResponseBody
    @GetMapping("/editCategory")
    public AjaxResult editCategory(Integer categoryId) {
        AjaxResult result = new AjaxResult();
        try {
            Category category = categoryService.getById(categoryId);
            List<Scategory> scategories = scategoryService.getByCategoryId(categoryId);
            category.setScategories(scategories);

            result.setData(category);
            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("编辑分类失败");
            e.printStackTrace();
        }
        return result;
    }

    //新增大分类
    @ResponseBody
    @PostMapping("/addCategory")
    public AjaxResult addCategory(Category category, HttpSession session) {
        AjaxResult result = new AjaxResult();
        try {

            Category category1 = categoryService.getByName(category.getName());
            if (category1 != null) {
                result.setSuccess(false);
                result.setMessage("分类已存在");
                return result;
            }

            MultipartFile fileimg = category.getFileimg();
            String fileName = fileimg.getOriginalFilename(); //获得图片名称
            String suffix = fileName.substring(fileName.lastIndexOf(".")); //获得图片后缀  如: .jpg
            String random = UUID.randomUUID().toString();
            String pathName = random + suffix;

            String path = session.getServletContext().getRealPath("pics");
            String iconPath = path + pathName;

            fileimg.transferTo(new File(iconPath));

            category.setIconpath(pathName);
            categoryService.add(category);

            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("添加分类失败");
            e.printStackTrace();
        }
        return result;
    }

}
