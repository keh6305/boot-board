package com.bootBoard.serviceImpl;

import com.bootBoard.dto.AreaDto;
import com.bootBoard.dto.Pagination;
import com.bootBoard.dto.TechDto;
import com.bootBoard.mapper.ManagementMapper;
import com.bootBoard.service.ManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ManagementServiceImpl implements ManagementService
{
    @Autowired
    private ManagementMapper managementMapper;

    // 기술 검색
    @Override
    public Map<String, Object> searchTech(String keyword, int page_num, int limit)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        int count = managementMapper.searchTechCount(keyword);

        int offset = (page_num - 1) * limit;
        int start_page = ((page_num - 1) / 10) * 10 + 1;
        int max_page = (count + limit - 1) / limit;

        Pagination page = new Pagination();
        page.setCount(count);
        page.setPage_num(page_num);
        page.setStart_page(start_page);
        page.setEnd_page(start_page + 9);
        page.setMax_page(max_page);
        page.setOffset(offset);
        page.setLimit(limit);

        List<TechDto> tech = managementMapper.searchTech(keyword, offset, limit);

        result.put("list", tech);
        result.put("page", page);

        return result;
    }

    // 기술 등록
    @Override
    public int insertTech(String tech)
    {
        int check = managementMapper.selectTechCheck(tech);

        int result = 0;

        if(check == 0)
        {
            result = managementMapper.insertTech(tech);
        }
        else
        {
            result = 9;
        }

        return result;
    }

    // 기술 수정
    @Override
    public int updateTech(TechDto tech)
    {
        return managementMapper.updateTech(tech);
    }

    // 기술 삭제
    @Override
    public int deleteTech(int tech_id)
    {
        return managementMapper.deleteTech(tech_id);
    }

    // 지역 목록 조회
    @Override
    public List<AreaDto> selectAreaList()
    {
        return managementMapper.selectAreaList();
    }

    // 지역 검색
    @Override
    public Map<String, Object> searchArea(String keyword, int parent, int page_num, int limit)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        int count = managementMapper.searchAreaCount(keyword, parent);

        int offset = (page_num - 1) * limit;
        int start_page = ((page_num - 1) / 10) * 10 + 1;
        int max_page = (count + limit - 1) / limit;

        Pagination page = new Pagination();
        page.setCount(count);
        page.setPage_num(page_num);
        page.setStart_page(start_page);
        page.setEnd_page(start_page + 9);
        page.setMax_page(max_page);
        page.setOffset(offset);
        page.setLimit(limit);

        List<AreaDto> area = managementMapper.searchArea(keyword, parent, offset, limit);

        result.put("list", area);
        result.put("page", page);

        return result;
    }

    // 지역 등록
    @Override
    public int insertArea(AreaDto area)
    {
        int check = managementMapper.selectAreaCheck(area);

        int result = 0;

        if(check == 0)
        {
            result = managementMapper.insertArea(area);
        }
        else
        {
            result = 9;
        }

        return result;
    }

    // 지역 수정
    @Override
    public int updateArea(AreaDto area)
    {
        return managementMapper.updateArea(area);
    }

    // 지역 삭제
    @Override
    public int deleteArea(int area_id)
    {
        return managementMapper.deleteArea(area_id);
    }
}