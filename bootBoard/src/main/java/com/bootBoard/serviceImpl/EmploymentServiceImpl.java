package com.bootBoard.serviceImpl;

import com.bootBoard.dto.*;
import com.bootBoard.mapper.EmploymentMapper;
import com.bootBoard.service.EmploymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmploymentServiceImpl implements EmploymentService
{
    @Autowired
    private EmploymentMapper employmentMapper;

    // 회사 검색
    @Override
    public Map<String, Object> searchCompany(SearchCompanyDto search, int page_num, int limit)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        int count = employmentMapper.searchCompanyCount(search);

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

        List<CompanyDto> company = employmentMapper.searchCompany(search, offset, limit);

        result.put("list", company);
        result.put("page", page);

        return result;
    }

    // 메인 지역 목록 조회
    @Override
    public List<AreaDto> selectMainAreaList()
    {
        return employmentMapper.selectMainAreaList();
    }

    // 서브 지역 목록 조회
    @Override
    public List<AreaDto> selectSubAreaList(int area_parent)
    {
        return employmentMapper.selectSubAreaList(area_parent);
    }

    // 회사 상세 조회
    @Override
    public CompanyDto selectCompany(int company_id)
    {
        return employmentMapper.selectCompany(company_id);
    }

    // 회사 등록
    @Override
    public int insertCompany(CompanyDto company)
    {
        return employmentMapper.insertCompany(company);
    }

    // 회사 수정
    @Override
    public int updateCompany(CompanyDto company)
    {
        return employmentMapper.updateCompany(company);
    }

    // 공고 검색
    @Override
    public Map<String, Object> searchRecruitment(SearchRecruitmentDto search, int page_num, int limit)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        int count = employmentMapper.searchRecruitmentCount(search);

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

        List<RecruitmentDto> recruitment = employmentMapper.searchRecruitment(search, offset, limit);

        result.put("page", page);
        result.put("list", recruitment);

        return result;
    }

    // 사이트 목록 조회
    @Override
    public List<SiteDto> selectSiteList()
    {
        return employmentMapper.selectSiteList();
    }

    // 공고 등록
    @Override
    public int insertRecruitment(RecruitmentDto recruitment)
    {
        int result = employmentMapper.insertRecruitment(recruitment);

        if(result != 0)
        {
            result = recruitment.getRecruitment_id();
        }

        return result;
    }

    // 기술 목록 조회
    @Override
    public List<TechDto> selectTechList()
    {
        return employmentMapper.selectTechList();
    }
}