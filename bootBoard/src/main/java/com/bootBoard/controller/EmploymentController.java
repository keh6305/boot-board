package com.bootBoard.controller;

import com.bootBoard.dto.AreaDto;
import com.bootBoard.dto.CompanyDto;
import com.bootBoard.dto.SearchCompanyDto;
import com.bootBoard.dto.TechDto;
import com.bootBoard.service.EmploymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employment")
public class EmploymentController
{
    @Autowired
    private EmploymentService employmentService;

    // 회사 목록 페이지
    @RequestMapping("/company/list")
    public ModelAndView companyList(ModelAndView mv)
    {
        List<AreaDto> mainArea = employmentService.selectMainAreaList();

        mv.addObject("mainArea", mainArea);

        mv.setViewName("company/companyList");

        return mv;
    }

    // 회사 검색
    @ResponseBody
    @GetMapping("/company/search")
    public Map<String, Object> searchCompany(SearchCompanyDto search, @RequestParam(defaultValue = "1", value = "page_num") int page_num, @RequestParam(defaultValue = "10", value = "limit") int limit)
    {
        Map<String, Object> result = employmentService.searchCompany(search, page_num, limit);

        return result;
    }

    // 회사 등록 페이지
    @GetMapping("/company/insert")
    public ModelAndView companyInsert(ModelAndView mv)
    {
        List<AreaDto> mainArea = employmentService.selectMainAreaList();

        mv.addObject("mainArea", mainArea);

        mv.setViewName("company/companyInsert");

        return mv;
    }

    // 회사 등록
    @ResponseBody
    @PostMapping("/company/insert")
    public int insertCompany(CompanyDto company)
    {
        return employmentService.insertCompany(company);
    }

    // 회사 상세 페이지
    @GetMapping("/company/detail/{company_id}")
    public ModelAndView companyDetail(ModelAndView mv, @PathVariable("company_id") int company_id)
    {
        CompanyDto company = employmentService.selectCompany(company_id);

        mv.addObject("company", company);

        mv.setViewName("company/companyDetail");

        return mv;
    }

    // 회사 수정 페이지
    @GetMapping("/company/update/{company_id}")
    public ModelAndView companyUpdate(ModelAndView mv, @PathVariable("company_id") int company_id)
    {
        CompanyDto company = employmentService.selectCompany(company_id);
        List<AreaDto> mainArea = employmentService.selectMainAreaList();
        List<AreaDto> subArea = employmentService.selectSubAreaList(company.getCompany_main_area());

        mv.addObject("company", company);
        mv.addObject("mainArea", mainArea);
        mv.addObject("subArea", subArea);

        mv.setViewName("company/companyUpdate");

        return mv;
    }

    // 회사 수정
    @ResponseBody
    @PutMapping("/company/update")
    public int updateCompany(CompanyDto company)
    {
        return employmentService.updateCompany(company);
    }

    // 서브 지역 조회
    @ResponseBody
    @GetMapping("/company/subArea")
    public List<AreaDto> selectSubArea(@RequestParam("area_parent") int area_parent)
    {
        List<AreaDto> result = employmentService.selectSubAreaList(area_parent);

        return result;
    }
}