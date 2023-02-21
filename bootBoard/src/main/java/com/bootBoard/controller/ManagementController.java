package com.bootBoard.controller;

import com.bootBoard.dto.AreaDto;
import com.bootBoard.dto.TechDto;
import com.bootBoard.service.ManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management")
public class ManagementController
{
    @Autowired
    private ManagementService managementService;

    // 기술 관리 페이지
    @RequestMapping("/techList")
    public ModelAndView techList(ModelAndView mv)
    {
        mv.setViewName("management/techList");

        return mv;
    }

    /**
     * 기술 검색
     * @param keyword(검색어)
     * @param page_num(페이지넘버)
     * @param limit
     * @return
     */
    @GetMapping("/tech")
    public Map<String, Object> searchTech(@RequestParam("keyword") String keyword, @RequestParam(defaultValue = "1", value = "page_num") int page_num, @RequestParam(defaultValue = "10", value = "limit") int limit)
    {
        Map<String, Object> result = managementService.searchTech(keyword, page_num, limit);

        return result;
    }

    /**
     * 기술 등록
     * @param tech(기술명)
     * @return
     */
    @PostMapping("/tech")
    public int insertTech(@RequestParam("tech") String tech)
    {
        return managementService.insertTech(tech);
    }

    @PutMapping("/tech")
    public int updateTech(TechDto tech)
    {
        return managementService.updateTech(tech);
    }

    @DeleteMapping("/tech")
    public int deleteTech(@RequestParam("tech_id") int tech_id)
    {
        return managementService.deleteTech(tech_id);
    }

    @RequestMapping("/areaList")
    public ModelAndView areaList(ModelAndView mv)
    {
        List<AreaDto> area = managementService.selectAreaList();

        mv.addObject("parent", area);

        mv.setViewName("management/areaList");

        return mv;
    }

    @GetMapping("/area")
    public Map<String, Object> searchArea(@RequestParam("keyword") String keyword, @RequestParam("parent") int parent, @RequestParam(defaultValue = "1", value = "page_num") int page_num, @RequestParam(defaultValue = "10", value = "limit") int limit)
    {
        Map<String, Object> result = managementService.searchArea(keyword, parent, page_num, limit);

        return result;
    }

    @PostMapping("/area")
    public int insertArea(AreaDto area)
    {
        return managementService.insertArea(area);
    }

    @PutMapping("/area")
    public int updateArea(AreaDto area)
    {
        return managementService.updateArea(area);
    }

    @DeleteMapping("/area")
    public int deleteArea(@RequestParam("area_id") int area_id)
    {
        return managementService.deleteArea(area_id);
    }
}