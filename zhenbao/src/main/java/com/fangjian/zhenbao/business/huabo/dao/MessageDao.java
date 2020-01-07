package com.fangjian.zhenbao.business.huabo.dao;

import com.fangjian.zhenbao.business.huabo.entity.Message;
import com.fangjian.zhenbao.business.system.dao.SystemBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author FangJian
 * @description: 系统消息dao层
 * @date 2019-12-07 15:28
 */
@Repository
public class MessageDao extends SystemBaseDao{

    public int insertSelective(Message message){
        return save("MessageMapper.insertSelective",message);
    }
}
