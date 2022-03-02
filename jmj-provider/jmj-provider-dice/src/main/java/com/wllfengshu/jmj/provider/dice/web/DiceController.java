package com.wllfengshu.jmj.provider.dice.web;

import com.wllfengshu.jmj.provider.dice.model.vo.DiceCupModel;
import com.wllfengshu.jmj.provider.dice.model.vo.DiceModel;
import com.wllfengshu.jmj.provider.dice.service.DiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangll
 * @date 2022-02-13 20:03
 */
@Slf4j
@Api(value = "Dice", tags = "骰子")
@RestController
@RequestMapping("/dice/")
@RequiredArgsConstructor
public class DiceController {

    @NonNull
    private DiceService diceService;

    @ApiOperation(value = "获取骰子", httpMethod = "GET")
    @GetMapping(value = "/giveDice")
    public ResponseEntity<DiceModel> giveDice(@RequestParam(value = "username") String username) {
        return new ResponseEntity<>(diceService.giveDice(username), HttpStatus.OK);
    }

    @ApiOperation(value = "掷骰子", httpMethod = "POST")
    @PostMapping(value = "/doDice")
    public ResponseEntity<DiceCupModel> doDice(@RequestParam(value = "username") String username,
                                               @RequestParam(value = "diceNum", required = false, defaultValue = "2") Integer diceNum) {
        return new ResponseEntity<>(diceService.doDice(username, diceNum), HttpStatus.OK);
    }
}
