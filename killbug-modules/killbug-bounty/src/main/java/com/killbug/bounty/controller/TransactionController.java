package com.killbug.bounty.controller;

import com.killbug.bounty.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @date 2023/8/20
 **/
@Validated
@RequiredArgsConstructor
@RestController
public class TransactionController {
    private final ITransactionService transactionService;
}
