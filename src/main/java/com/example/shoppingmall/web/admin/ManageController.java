package com.example.shoppingmall.web.admin;

import com.example.shoppingmall.po.Member;
import com.example.shoppingmall.po.MemberCert;
import com.example.shoppingmall.service.admin.CertService;
import com.example.shoppingmall.service.admin.MemberCertService;
import com.example.shoppingmall.service.admin.MemberService;
import com.example.shoppingmall.utils.AjaxResult;
import com.example.shoppingmall.vo.MemberExamineVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberCertService memberCertService;

    @Autowired
    private CertService certService;

    //分页查询实名认证
    @ResponseBody
    @GetMapping(value = "/memberRealAudit")
    public AjaxResult memberRealAudit(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable page){
        AjaxResult result = new AjaxResult();

        try {
            Page<Member> members = memberService.getUnauthorizedMember(page);
            result.setPage(members);
            result.setSuccess(true);

        }catch (Exception e){
            result.setSuccess(false);
            e.printStackTrace();
        }
        return result;
    }

    //实名认证审核
    @ResponseBody
    @GetMapping("/editMemberRealAudit")
    public AjaxResult editMemberRealAudit(@RequestParam Integer memberId){
        AjaxResult result = new AjaxResult();
        try {
            Member member = memberService.getMemberById(memberId);
            List<MemberCert> memberCerts = memberCertService.getByMemberId(memberId);
            for (MemberCert memberCert : memberCerts){
                memberCert.setCertName(certService.getById(memberCert.getCertId()).getName());
            }

            MemberExamineVo memberExamineVo = new MemberExamineVo();
            memberExamineVo.setMember(member);
            memberExamineVo.setMemberCerts(memberCerts);

            result.setData(memberExamineVo);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
            e.printStackTrace();
        }
        return result;
    }

    //member实名审核通过
    @ResponseBody
    @PostMapping("/agreeApply")
    public AjaxResult agreeApply(@RequestParam Integer memberId){
        AjaxResult result = new AjaxResult();
        try {
            Member member = memberService.getMemberById(memberId);
            member.setAuthstatus("2");
            memberService.save(member);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("请求失败");
            e.printStackTrace();
        }
        return result;
    }


    //member实名审核不通过
    @ResponseBody
    @PostMapping("/refuseApply")
    public AjaxResult refuseApply(@RequestParam Integer memberId){
        AjaxResult result = new AjaxResult();
        try {
            Member member = memberService.getMemberById(memberId);
            member.setAuthstatus("0");
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("请求失败");
            e.printStackTrace();
        }
        return result;
    }
}
