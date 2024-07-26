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

import cn.tycoding.langchat.biz.component.ProviderEnum;
import cn.tycoding.langchat.biz.entity.AigcModel;
import cn.tycoding.langchat.biz.mapper.AigcModelMapper;
import cn.tycoding.langchat.biz.service.AigcModelService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tycoding
 * @since 2024/1/19
 */
@Service
@RequiredArgsConstructor
public class AigcModelServiceImpl extends ServiceImpl<AigcModelMapper, AigcModel> implements AigcModelService {

    @Override
    public List<AigcModel> getChatModels() {
        return baseMapper.selectList(Wrappers.<AigcModel>lambdaQuery()
                .ne(AigcModel::getProvider, ProviderEnum.EMBEDDING.getModel())
                .ne(AigcModel::getProvider, ProviderEnum.TEXT_IMAGE.getModel()));
    }

    @Override
    public List<AigcModel> getImageModels() {
        return baseMapper.selectList(Wrappers.<AigcModel>lambdaQuery()
                .eq(AigcModel::getProvider, ProviderEnum.TEXT_IMAGE.getModel()));
    }

    @Override
    public List<AigcModel> getEmbeddingModels() {
        return baseMapper.selectList(Wrappers.<AigcModel>lambdaQuery()
                .eq(AigcModel::getProvider, ProviderEnum.EMBEDDING.getModel()));
    }
}

