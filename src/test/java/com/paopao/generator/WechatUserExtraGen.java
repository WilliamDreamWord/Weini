package com.paopao.generator;

import com.paopao.dao.OrderMapper;
import com.paopao.dao.WeChatUserExtraMapper;
import com.paopao.dao.WeChatUserMapper;
import com.paopao.po.WeChatUser;
import com.paopao.po.WeChatUserExtra;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by joker on 08/09/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatUserExtraGen {

    @Autowired
    private WeChatUserExtraMapper weChatUserExtraMapper;

    @Autowired
    private WeChatUserMapper weChatUserMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void genWeChatUserExtra() {
        List<WeChatUser> weChatUsers = weChatUserMapper.list();


        for (WeChatUser weChatUser : weChatUsers) {
            WeChatUserExtra weChatUserExtra = new WeChatUserExtra();
            weChatUserExtra.setUserId(weChatUser.getId());
            weChatUserExtraMapper.insert(weChatUserExtra);
        }

    }

    @Test
    public void genOrderCount() {

        List<WeChatUserExtra> weChatUserExtras = weChatUserExtraMapper.list();

        for (WeChatUserExtra weChatUserExtra : weChatUserExtras) {
            WeChatUserExtra newOne = new WeChatUserExtra();
            newOne.setId(weChatUserExtra.getId());
            int count = orderMapper.countByUserIdStatus(weChatUserExtra.getUserId(), null);
            System.out.println(count);
            newOne.setOrderCount(count);

            newOne.setCredit(0L);
            newOne.setStatus(0);
            weChatUserExtraMapper.updateByPrimaryKeySelective(newOne);
        }

    }
}
