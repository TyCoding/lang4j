/*
 * Project: LangChat
 * Author: TyCoding
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

package cn.tycoding.langchat.biz.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.tycoding.langchat.biz.entity.AigcOss;
import cn.tycoding.langchat.biz.mapper.AigcOssMapper;
import cn.tycoding.langchat.biz.service.AigcOssService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author tycoding
 * @since 2024/1/4
 */
@Service
@RequiredArgsConstructor
public class AigcOssServiceImpl extends ServiceImpl<AigcOssMapper, AigcOss> implements AigcOssService {

    private final FileStorageService fileStorageService;

    @Override
    public AigcOss upload(MultipartFile file, String userId) {
        FileInfo info = fileStorageService.of(file)
                .setPath(DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN))
                .upload();
        AigcOss oss = BeanUtil.copyProperties(info, AigcOss.class);
        oss.setOssId(info.getId());
        oss.setUserId(userId);
        this.save(oss);
        return oss;
    }
}

