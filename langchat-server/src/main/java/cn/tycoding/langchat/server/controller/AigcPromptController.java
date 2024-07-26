/*
 * Copyright (c) 2024 LangChat. TyCoding All Rights Reserved.
 *
 * Licensed under the GNU Affero General Public License, Version 3 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.gnu.org/licenses/agpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.tycoding.langchat.server.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.util.StrUtil;
import cn.tycoding.langchat.biz.entity.AigcPrompt;
import cn.tycoding.langchat.biz.service.AigcPromptService;
import cn.tycoding.langchat.common.annotation.ApiLog;
import cn.tycoding.langchat.common.utils.MybatisUtil;
import cn.tycoding.langchat.common.utils.QueryPage;
import cn.tycoding.langchat.common.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author tycoding
 * @since 2024/1/19
 */
@RequestMapping("/aigc/prompt")
@RestController
@AllArgsConstructor
public class AigcPromptController {

    private final AigcPromptService aigcPromptService;

    @GetMapping("/page")
    public R list(AigcPrompt data, QueryPage queryPage) {
        LambdaQueryWrapper<AigcPrompt> queryWrapper = Wrappers.<AigcPrompt>lambdaQuery()
                .like(!StrUtil.isBlank(data.getName()), AigcPrompt::getName, data.getName())
                .orderByDesc(AigcPrompt::getCreateTime);
        IPage<AigcPrompt> iPage = aigcPromptService.page(MybatisUtil.wrap(data, queryPage), queryWrapper);
        return R.ok(MybatisUtil.getData(iPage));
    }

    @GetMapping("/list")
    public R list(AigcPrompt data) {
        List<AigcPrompt> list = aigcPromptService.list(Wrappers.<AigcPrompt>lambdaQuery().orderByDesc(AigcPrompt::getCreateTime));
        return R.ok(list);
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable String id) {
        return R.ok(aigcPromptService.getById(id));
    }

    @PostMapping
    @ApiLog("添加Prompt")
    @SaCheckPermission("aigc:prompt:add")
    public R add(@RequestBody AigcPrompt data) {
        data.setCreateTime(new Date());
        return R.ok(aigcPromptService.save(data));
    }

    @PutMapping
    @ApiLog("更新Prompt")
    @SaCheckPermission("aigc:prompt:update")
    public R update(@RequestBody AigcPrompt data) {
        return R.ok(aigcPromptService.updateById(data));
    }

    @DeleteMapping("/{id}")
    @ApiLog("删除Prompt")
    @SaCheckPermission("aigc:prompt:delete")
    public R del(@PathVariable String id) {
        return R.ok(aigcPromptService.removeById(id));
    }

}