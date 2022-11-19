package com.bootBoard.serviceImpl;

import com.bootBoard.dto.Pagination;
import com.bootBoard.dto.UserDto;
import com.bootBoard.mapper.UserMapper;
import com.bootBoard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> userSearch(int user_type, int user_status, int keytype, String keyword, int page_num, int limit)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        int count = userMapper.selectUserCount(user_type, user_status, keytype, keyword);

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

        List<UserDto> user = userMapper.selectUserList(user_type, user_status, keytype, keyword, offset, limit);

        result.put("list", user);
        result.put("page", page);

        return result;
    }
}