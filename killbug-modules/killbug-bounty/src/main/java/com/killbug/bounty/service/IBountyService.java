package com.killbug.bounty.service;

import com.killbug.bounty.api.vo.BountyVO;
import com.killbug.bounty.dto.BountyDTO;
import com.killbug.bounty.dto.FinishBountyDTO;
import com.killbug.bounty.dto.GrabBountyDTO;
import com.killbug.common.core.vo.ListVO;

import java.util.List;

/**
 * @author Zch
 * @date 2023/8/20
 **/
public interface IBountyService {

    Long createBounty(BountyDTO bountyDTO);

    ListVO<BountyVO> getBountyList(Integer pageNum, Integer pageSize, Integer status);

    BountyVO getBountyById(Long idInt);

    List<BountyVO> getBountyList();

    void grabBounty(GrabBountyDTO grabBountyDTO);

    void closeBounty(GrabBountyDTO grabBountyDTO);

    List<BountyVO> getMyBounties();

    List<BountyVO> getBountiesByUserId(Long id);

    void finishBounty(FinishBountyDTO finishBountyDTO);

    void cancelBounty(GrabBountyDTO grabBountyDTO);

    List<BountyVO> getGrabbedBountiesByUserId(Long id);

    List<BountyVO> getMyGrabbedBounties();

}
