package com.project.escape.domain.store;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles(value = "local")
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StoreServiceTest {
    @Autowired
    private StoreService storeService;
    @Autowired
    private StoreDataUtils storeDataUtils;

    @Test
    @DisplayName("Json data를 읽어서 방탈출 업체 데이터가 저장된다. 중복되는 데이터는 제외하고 저장된다.")
    void testSaveStoreJsonData() {
        // given
        List<StoreDto> storeDtos = storeDataUtils.convertStoreJsonData();

        // when
        List<StoreResponse> storeResponses = storeService.saveAllStoreData(storeDtos);

        // then
        assertEquals(storeResponses.size(), storeDtos.size());
    }
}
