package com.killbug.bounty.service.impl;

import com.killbug.bounty.mapper.TransactionMapper;
import com.killbug.bounty.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Slf4j
@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements ITransactionService {

    private final TransactionMapper transactionMapper;
}
