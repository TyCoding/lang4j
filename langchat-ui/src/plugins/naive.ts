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

import type { App } from 'vue';
import {
  create,
  NAlert,
  NAvatar,
  NBackTop,
  NBadge,
  NBreadcrumb,
  NBreadcrumbItem,
  NButton,
  NCard,
  NCascader,
  NCheckbox,
  NCheckboxGroup,
  NCol,
  NConfigProvider,
  NDataTable,
  NDatePicker,
  NDescriptions,
  NDescriptionsItem,
  NDialogProvider,
  NDivider,
  NDrawer,
  NDrawerContent,
  NDropdown,
  NElement,
  NForm,
  NFormItem,
  NGrid,
  NGridItem,
  NIcon,
  NInput,
  NInputGroup,
  NInputNumber,
  NLayout,
  NLayoutContent,
  NLayoutFooter,
  NLayoutHeader,
  NLayoutSider,
  NList,
  NListItem,
  NLoadingBarProvider,
  NMenu,
  NMessageProvider,
  NModal,
  NNotificationProvider,
  NPagination,
  NPopover,
  NProgress,
  NRadio,
  NRadioGroup,
  NResult,
  NRow,
  NSelect,
  NSkeleton,
  NSlider,
  NSpace,
  NSpin,
  NStep,
  NSteps,
  NSwitch,
  NTable,
  NTabPane,
  NTabs,
  NTag,
  NThing,
  NTimePicker,
  NTooltip,
  NTree,
  NUpload,
} from 'naive-ui';

// https://www.naiveui.com/en-US/os-theme/docs/import-on-demand
const naive = create({
  components: [
    NMessageProvider,
    NDialogProvider,
    NConfigProvider,
    NInput,
    NButton,
    NForm,
    NFormItem,
    NCheckboxGroup,
    NCheckbox,
    NIcon,
    NLayout,
    NLayoutHeader,
    NLayoutContent,
    NLayoutFooter,
    NLayoutSider,
    NMenu,
    NBreadcrumb,
    NBreadcrumbItem,
    NDropdown,
    NSpace,
    NTooltip,
    NAvatar,
    NTabs,
    NTabPane,
    NCard,
    NRow,
    NCol,
    NDrawer,
    NDrawerContent,
    NDivider,
    NSwitch,
    NBadge,
    NAlert,
    NElement,
    NTag,
    NNotificationProvider,
    NProgress,
    NDatePicker,
    NGrid,
    NGridItem,
    NList,
    NListItem,
    NThing,
    NDataTable,
    NPopover,
    NPagination,
    NSelect,
    NRadioGroup,
    NRadio,
    NSteps,
    NStep,
    NInputGroup,
    NResult,
    NDescriptions,
    NDescriptionsItem,
    NTable,
    NInputNumber,
    NLoadingBarProvider,
    NModal,
    NUpload,
    NTree,
    NSpin,
    NTimePicker,
    NBackTop,
    NSkeleton,
    NCascader,
    NSlider,
  ],
});

export function setupNaive(app: App<Element>) {
  app.use(naive);
}