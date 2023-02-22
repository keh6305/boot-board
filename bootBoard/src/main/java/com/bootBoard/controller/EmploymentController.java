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

    @RequestMapping("/company/list")
    public ModelAndView companyList(ModelAndView mv)
    {
        List<AreaDto> mainArea = employmentService.selectMainAreaList();

        mv.addObject("mainArea", mainArea);

        mv.setViewName("company/companyList");

        return mv;
    }

    @ResponseBody
    @GetMapping("/company/search")
    public Map<String, Object> searchCompany(SearchCompanyDto search, @RequestParam(defaultValue = "1", value = "page_num") int page_num, @RequestParam(defaultValue = "10", value = "limit") int limit)
    {
        Map<String, Object> result = employmentService.searchCompany(search, page_num, limit);

        return result;
    }

    @GetMapping("/company/insert")
    public ModelAndView companyInsert(ModelAndView mv)
    {
        List<AreaDto> mainArea = employmentService.selectMainAreaList();

        mv.addObject("mainArea", mainArea);

        mv.setViewName("company/companyInsert");

        return mv;
    }

    @ResponseBody
    @PostMapping("/company/insert")
    public int insertCompany(CompanyDto company)
    {
        return employmentService.insertCompany(company);
    }

    @ResponseBody
    @GetMapping("/company/subArea")
    public List<AreaDto> selectSubArea(@RequestParam("area_parent") int area_parent)
    {
        List<AreaDto> result = employmentService.selectSubAreaList(area_parent);

        return result;
    }
}