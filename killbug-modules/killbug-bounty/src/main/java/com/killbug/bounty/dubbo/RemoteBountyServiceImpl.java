package com.killbug.bounty.dubbo;

import com.killbug.bounty.api.RemoteBountyService;
import com.killbug.bounty.api.vo.BountyVO;
import com.killbug.bounty.service.IBountyService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Service
@RequiredArgsConstructor
@DubboService
public class RemoteBountyServiceImpl implements RemoteBountyService {

    private final IBountyService bountyService;

    @Override
    public List<BountyVO> getBountyList() {
        return bountyService.getBountyList();
    }

    @Override
    public List<BountyVO> getMyBounties() {
        return bountyService.getMyBounties();
    }

    @Override
    public List<BountyVO> getBountiesByUserId(Long id) {
        return bountyService.getBountiesByUserId(id);
    }

    @Override
    public List<BountyVO> getGrabbedBountiesByUserId(Long id) {
        return bountyService.getGrabbedBountiesByUserId(id);
    }

}
