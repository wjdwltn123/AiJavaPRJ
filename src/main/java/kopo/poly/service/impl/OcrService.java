package kopo.poly.service.impl;

import kopo.poly.dto.OcrDTO;
import kopo.poly.service.IOcrService;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Slf4j

@Service
public class OcrService implements IOcrService {
    @Override
    public OcrDTO getReadforImageText(OcrDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + "getReadforImageText start!");
        // resource 폴더 밑에 존재하는 파일을 활용하기 위해 반드시 ClassPathResource 객체 사용
        ClassPathResource resource = new ClassPathResource(pDTO.getFilePath() + "/" + pDTO.getFileName());

        // OCR 기술 사용을 위한 tesseract 플랫폼 객체 생성
        ITesseract instance = new Tesseract();

        // ocr 분석에 필요한 기준 데이터 (데이터 위치 폴더)
        // 저장 경로는 물리경로를 사용함 (전체 경로)
        instance.setDatapath(IOcrService.modelFile) ;

        //한국어 학습 데이터 선택(기본값은 영어)
        instance.setLanguage("eng");

        // 이미지 파일로부터 텍스트 읽기
        String result = instance.doOCR(resource.getFile());

        // 읽은 글씨를 pDTO에 저장함
        pDTO.setResult(result);

        log.info(this.getClass() + "getReadforImage End!");
        return pDTO;
    }
}
