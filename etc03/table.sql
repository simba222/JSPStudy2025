
CREATE TABLE tblBusanTheme (
	uc_seq INT PRIMARY KEY COMMENT '고유 식별 번호',
    main_title VARCHAR(255) COMMENT '메인 제목',
    gugun_nm VARCHAR(50) COMMENT '구군명 (지역 정보)',
    cate2_nm VARCHAR(100) COMMENT '카테고리 (세부 테마)',
    lat DOUBLE COMMENT '위도 (Latitude)',
    lng DOUBLE COMMENT '경도 (Longitude)',
    place TEXT COMMENT '장소 목록',
    title TEXT COMMENT '제목 (설명 포함)',
    subtitle TEXT COMMENT '부제목',
    addr1 VARCHAR(255) COMMENT '기본 주소',
    homepage_url VARCHAR(255) COMMENT '홈페이지 URL',
    trfc_info TEXT COMMENT '교통 정보',
    main_img_normal  VARCHAR(255)  COMMENT '메인 이미지 (일반 크기)',
    main_img_thumb VARCHAR(255) COMMENT '메인 이미지 (썸네일)',
    itemcntnts TEXT COMMENT '장소 설명 및 상세 내용'
)COMMENT='부산 테마 여행 정보를 저장하는 테이블';