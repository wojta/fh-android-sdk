/**
 * Copyright Red Hat, Inc, and individual contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feedhenry.sdk.android;

import android.support.test.runner.AndroidJUnit4;
import com.feedhenry.sdk.storage.Storage;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static android.support.test.InstrumentationRegistry.getContext;
import static junit.framework.Assert.assertEquals;

/**
 * Testing file storage.
 */
@RunWith(AndroidJUnit4.class)
public class FileStorageTest {

    private static final String TEST_CONTENT_ID = "testContent";



    @Test
    public void testStorage() throws IOException {
        Storage storage = new FileStorage(getContext());
        String testContent =
                "Лорем ипсум долор сит амет, ест долор хонестатис цу, ин идяуе видерер при. Вел анциллае реферрентур ут, мунере граеци садипсцинг ид хис. Яуодси адиписци вис цу, нолуиссе сцрибентур вел ид. Лаореет перицула ет про, вих ет бруте нихил тимеам, меи лудус рецтеяуе диспутандо цу.\n"
                        + "\n"
                        + "Еи яуо воцибус яуалисяуе, видит волутпат ид еам. Цум цоммуне цонсететур елаборарет но, епицури проприае яуалисяуе еа вих. Еу цонституто витуперата хис. Хас цонвенире цонституто ин. Ин сед малис дицтас симилияуе, лудус промпта проприае иус ех.\n"
                        + "\n"
                        + "Ех меи волуптуа вертерем атоморум, лаореет репудиаре цу еум. Ид дицам волумус сусципиантур хас. Елигенди атоморум еос но, пер ет елитр ехплицари. При мелиус маиорум петентиум ан. Бруте лабитур цонцлусионемяуе сед те, витае доцтус ет нам, яуот фалли пробатус ех нец.\n"
                        + "\n"
                        + "Сеа те цонгуе албуциус, пробо еверти аппетере но меа, вел ут саепе пробатус. Вел яуаестио ратионибус волуптатибус цу, нам зрил импедит аппетере еа, но нам цонсул инермис. Еам вери ноструд ин. Про фугит нонумы ностро те, нец ут видиссе цонсецтетуер, ад еум алияуип лаореет. Доцтус доценди аппареат ех дуо, малис омниум аппареат еам еу.\n"
                        + "\n"
                        + "Меи тантас граеци ех. Еум етиам цонтентионес ат, ет цум бландит пертинах. Цу перципит рецусабо вих. Пер лорем оцурререт ех. Еу цум глориатур интерессет. Яуот аргументум ех цум, нисл игнота волутпат ут нам.";
        storage.putContent(TEST_CONTENT_ID, testContent.getBytes("UTF-8"));
        String retrievedContent = new String(storage.getContent("testContent"), "UTF-8");
        assertEquals(testContent, retrievedContent);
    }

}
