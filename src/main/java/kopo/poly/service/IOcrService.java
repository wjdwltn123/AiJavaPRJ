package kopo.poly.service;

import kopo.poly.dto.OcrDTO;

public interface IOcrService {
    // 인터페이스는 인터페이스를 구현하는 자바 객체들의 공통 상수를 설정할 떄도 활용함
    // 학습 모델 파일이 존재하는 폴더

    String modelFile = "C:/model/tessdata";
    //이미지 파일로부터 문자 읽어 오가

    OcrDTO getReadforImageText(OcrDTO pDTO) throws Exception;
}
