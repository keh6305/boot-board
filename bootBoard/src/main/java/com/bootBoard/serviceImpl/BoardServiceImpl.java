package com.bootBoard.serviceImpl;

import com.bootBoard.dto.NoticeDto;
import com.bootBoard.dto.Pagination;
import com.bootBoard.mapper.BoardMapper;
import com.bootBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService
{
    @Autowired
    private BoardMapper boardMapper;

    // 공지사항 조회
    @Override
    public Map<String, Object> noticeSearch(int user_type, int page_num, int limit)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        int count = boardMapper.selectNoticeCount(user_type);

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

        List<NoticeDto> notice = boardMapper.selectNoticeList(user_type, offset, limit);

        result.put("list", notice);
        result.put("page", page);

        return result;
    }

    // 공지사항 등록
    @Override
    public int insertNotice(NoticeDto notice)
    {
        int result = boardMapper.insertNotice(notice);

        return result;
    }
}