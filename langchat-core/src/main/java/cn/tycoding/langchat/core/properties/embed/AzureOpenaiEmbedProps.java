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

package cn.tycoding.langchat.core.properties.embed;

import com.azure.core.http.ProxyOptions;
import java.time.Duration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tycoding
 * @since 2024/3/8
 */
@Data
@ConfigurationProperties(prefix = "langchat.embedding.azureopenai")
public class AzureOpenaiEmbedProps {

    private String endpoint;
    private String serviceVersion;
    private String apiKey;
    private String deploymentName;
    private Duration timeout = Duration.ofSeconds(600);
    private Integer maxRetries;
    private ProxyOptions proxyOptions;
    private boolean logRequestsAndResponses;
}
