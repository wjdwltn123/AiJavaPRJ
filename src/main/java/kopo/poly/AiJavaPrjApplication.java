package kopo.poly;

import kopo.poly.dto.OcrDTO;
import kopo.poly.service.IOcrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class AiJavaPrjApplication implements CommandLineRunner {
    //@service 정의된 자바 파일
    //spring 프레임워크가 실행될 떄 , @service에 정의한 자바는 자동으로 메모리에 올림
    //메모리에 올라간 ocrserivce 객체를 ocrservice 변수에 객체를 넣어줌

    private final IOcrService ocrService; //이미지 인식

    public static void main(String[] args) {
        SpringApplication.run(AiJavaPrjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("자바 프로그래밍 시작!");

        String filePath = "image";
        String fileName = "news03.jpg";
       // 전달할 값(parameter) 약자로 보통 변수명 앞에 p를 붙힘 => pDTO
        OcrDTO pDTO = new OcrDTO(); //정보를 전달할 DTO 값을 메모리에 올림

        pDTO.setFilePath(filePath);
        pDTO.setFileName(fileName);

        //실행 결과(result) 약자를 보통 변수명 앞에 r를 붙힘 => rDTO
        OcrDTO rDTO = ocrService.getReadforImageText(pDTO);

        String result = rDTO.getResult(); // 인식된 문자열

        log.info("인식된 문자열");
        log.info(result);

        log.info("자바 프로그래밍 종료!");
    }
}
