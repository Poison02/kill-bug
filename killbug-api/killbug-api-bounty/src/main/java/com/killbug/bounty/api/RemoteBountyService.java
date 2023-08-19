package com.killbug.bounty.api;

import com.killbug.bounty.api.vo.BountyVO;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/19
 **/
public interface RemoteBountyService {

    List<BountyVO> getBountyList();

    List<BountyVO> getMyBounties();

    List<BountyVO> getBountiesByUserId(Long id);

    List<BountyVO> getGrabbedBountiesByUserId(Long id);

}
