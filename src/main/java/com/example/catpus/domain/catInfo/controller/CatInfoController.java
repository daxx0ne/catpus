package com.example.catpus.domain.catInfo.controller;

import com.example.catpus.domain.catInfo.dto.CatInfoDto;
import com.example.catpus.domain.catInfo.entity.CatInfo;
import com.example.catpus.domain.catInfo.service.CatInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/cat-info")
@Tag(name = "CatInfo", description = "고양이 정보")
public class CatInfoController {

    private final CatInfoService catInfoService;
    private final ModelMapper modelMapper;

    @Autowired
    public CatInfoController(CatInfoService catInfoService, ModelMapper modelMapper) {
        this.catInfoService = catInfoService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    @Operation(summary ="고양이 정보 등록")
    public ResponseEntity<String> registerCatInfo(@RequestBody CatInfo catInfo) {
        try {
            CatInfo savedCatInfo = catInfoService.registerCatInfo(catInfo); // 서비스 레이어에서 등록 로직 수행
            return new ResponseEntity<>("Cat Info registered with ID: " + savedCatInfo.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register Cat Info", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{catInfoId}")
    @Operation(summary = "고양이 정보 조회")
    public ResponseEntity<CatInfo> getCatInfo(@PathVariable Long catInfoId) {
        try {
            CatInfo catInfo = catInfoService.getCatInfo(catInfoId); // 서비스 레이어에서 고양이 정보 조회 로직 수행

            if (catInfo != null) {
                return new ResponseEntity<>(catInfo, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 츄르 증가 API
    @PostMapping("/yummy/{id}")
    @Operation(summary ="츄르 냠냠")
    public ResponseEntity<CatInfoDto> increaseChur(@PathVariable Long id) {
        CatInfo catInfo = catInfoService.increaseChur(id);
        CatInfoDto catInfoDto = modelMapper.map(catInfo, CatInfoDto.class);
        return ResponseEntity.ok(catInfoDto);
    }
}
