package com.project.escape.domain.store;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.escape.global.exception.GeneralRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreDataUtils {
    @Value("${data.dummy.path}")
    private String jsonFilePath;
    private final ObjectMapper objectMapper;
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public List<StoreDto> convertStoreJsonData() {
        StoreDataDto storeData = mappingStoreDataDto();
        List<String> storeNames = getStoreNames();

        return storeData.getHits().stream()
                .distinct()
                .filter(store -> !storeNames.contains(store.getStoreName()))
                .map(StoreDataDto.Hit::toStoreDto)
                .toList();
    }

    private StoreDataDto mappingStoreDataDto() {
        try {
            return objectMapper.readValue(new File(jsonFilePath), StoreDataDto.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new GeneralRuntimeException("ERROR MESSAGE : No such file or directory");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new GeneralRuntimeException("ERROR MESSAGE : Json 파일 읽는 중 에러 발생");
        }
    }

    private List<String> getStoreNames() {
        return storeRepository.findAll().stream().map(Store::getName).toList();
    }
}
