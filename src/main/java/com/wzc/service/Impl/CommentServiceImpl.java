package com.wzc.service.Impl;

import com.wzc.bean.Comments;
import com.wzc.bean.CommentsExample;
import com.wzc.dao.CommentsMapper;
import com.wzc.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comments,CommentsExample,Integer> implements ICommentService {

    @Autowired
    public CommentsMapper mapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(mapper);
    }
}
