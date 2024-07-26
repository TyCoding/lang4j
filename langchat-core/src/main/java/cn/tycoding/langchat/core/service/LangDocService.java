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

package cn.tycoding.langchat.core.service;

import cn.tycoding.langchat.common.dto.ChatReq;
import cn.tycoding.langchat.common.dto.EmbeddingR;
import dev.langchain4j.service.TokenStream;
import java.util.List;

/**
 * @author tycoding
 * @since 2024/4/4
 */
public interface LangDocService {

    /**
     * 解析文本向量
     */
    EmbeddingR embeddingText(ChatReq req);

    /**
     * 解析文本文件向量
     */
    List<EmbeddingR> embeddingDocs(ChatReq req);

    /**
     * 文档对话
     */
    TokenStream chat(ChatReq req);
}
