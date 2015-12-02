package io.j2ffrey_2.bongsaggun;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by han on 2015-10-28.
 * BongsaggunProvider에서 필요한 상수값을 지정해두는 클래스
 * 외부에서 Provider를 사용하기 위해 필요한 값들이 저장
 * Provider에 접근하기 위한 API라고 생각하면 편하다
 */
public class BongsaggunContracts {


    //SharedPreference
    public static final String PREFERENCE_NAME = "bongsaggun_settings";

    public static final String PREFERENCE_KEY_USER_ID = "uid";


    /*
    VoluntaryProvider의 AUTHORITY
    다른 프로바이더와의 충돌을 피하기 위해 "Android 패키지이름 + 앱이름"을 추천
    */
    public static final String CONTENT_AUTHORITY = "io.j2ffrey_2.bongsaggun.app";

    /*
    최상위 아이템의 AUTHORITY를 위한 CONTENT URI(provider안의 데이터를 식별하는 URI)
     Provider의 이름을 의미하는 AUTHORITY와 테이블이나 파일을 의미하는 Path로 구성
     테이블 URI: content://<authority>/<path>
     한 열의 URI: content://<authority>/<path>/<id>
     #: 모든 숫자에 매칭
     *: 모든 숫자,문자에 매칭
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_VOLUNTARY = "voluntary";
    public static final String PATH_IMAGE = "image";
    public static final String PATH_SCHOOL = "school";
    public static final String PATH_REGION = "region";
    public static final String PATH_TIME = "time";
    public static final String PATH_CATEGORY = "category";

    //학교
    public static final class SchoolEntry implements BaseColumns {

        //School테이블에 연결되는 CONTENT_URI
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_SCHOOL).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCHOOL;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCHOOL;

        public static final String TABLE_NAME = "school";

        //컬럼속성
        public static final String COLUMN_SCHOOL_ID = "school_id";  //INTEGER
        public static final String COLUMN_SCHOOL_NAME = "school_name";  //TEXT
        public static final String COLUMN_SCHOOL_CREATEAT = "createdAt";  //TEXT
        public static final String COLUMN_SCHOOL_UPDATEAT = "updateAt";  //TEXT

        public static final String[] PROJECTION_ALL = {COLUMN_SCHOOL_ID, COLUMN_SCHOOL_NAME};

        //COLUMN_SCHOOL_ID를 기준으로 정렬
        public static final String SORT_ORDER_DEFAULT = COLUMN_SCHOOL_ID + " ASC";

        public static Uri buildSchoolUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    //활동지역
    public static final class RegionEntry implements BaseColumns {

        //Region테이블에 연결되는 CONTENT_URI
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_REGION).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_REGION;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_REGION;

        //컬럼속성
        public static final String TABLE_NAME = "region";
        public static final String COLUMN_REGION_ID = "region_id";  //INTEGER
        public static final String COLUMN_REGION_NAME = "region_name";  //TEXT
        public static final String COLUMN_REGION_CREATEAT = "createdAt";  //TEXT
        public static final String COLUMN_REGION_UPDATEAT = "updateAt";  //TEXT

        public static final String[] PROJECTION_ALL = {COLUMN_REGION_ID, COLUMN_REGION_NAME};

        //COLUMN_REGION_ID를 기준으로 정렬
        public static final String SORT_ORDER_DEFAULT = COLUMN_REGION_ID + " ASC";

        public static Uri buildRegionUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    //봉사시간
    public static final class TimeEntry implements BaseColumns {

        //Time테이블에 연결되는 CONTENT_URI
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TIME).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TIME;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TIME;

        //컬럼속성
        public static final String TABLE_NAME = "time";
        public static final String COLUMN_TIME_ID = "time_id";  //INTEGER
        public static final String COLUMN_TIME_NAME = "time_name";  //TEXT
        public static final String COLUMN_TIME_MIN = "time_min";  //INTEGER
        public static final String COLUMN_TIME_MAX = "time_max";  //INTEGER
        public static final String COLUMN_TIME_CREATEAT = "createdAt";  //TEXT
        public static final String COLUMN_TIME_UPDATEAT = "updateAt";  //TEXT

        public static final String[] PROJECTION_ALL = {COLUMN_TIME_ID, COLUMN_TIME_NAME};

        //COLUMN_TIME_ID를 기준으로 정렬
        public static final String SORT_ORDER_DEFAULT = COLUMN_TIME_ID + " ASC";

        public static Uri buildTimeUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    //학교
    public static final class CategoryEntry implements BaseColumns {

        //Category테이블에 연결되는 CONTENT_URI
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_CATEGORY).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CATEGORY;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CATEGORY;

        public static final String TABLE_NAME = "category";

        //컬럼속성
        public static final String COLUMN_CATEGORY_ID = "category_id";  //INTEGER
        public static final String COLUMN_CATEGORY_NAME = "category_name";  //TEXT
        public static final String COLUMN_CATEGORY_CREATEAT = "createdAt";  //TEXT
        public static final String COLUMN_CATEGORY_UPDATEAT = "updateAt";  //TEXT

        public static final String[] PROJECTION_ALL = {COLUMN_CATEGORY_ID, COLUMN_CATEGORY_NAME};

        //COLUMN_CATEGORY_ID를 기준으로 정렬
        public static final String SORT_ORDER_DEFAULT = COLUMN_CATEGORY_ID + " ASC";

        public static Uri buildCategoryUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    //이미지
    public static final class ImageEntry implements BaseColumns {

        //Image테이블에 연결되는 CONTENT_URI
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_IMAGE).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_IMAGE;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_IMAGE;

        //컬럼속성
        public static final String TABLE_NAME = "image";
        public static final String COLUMN_IMAGE_FK_VOLUNTARY_ID = "fk_image_voluntary_id";  //INTEGER foreginkey
        public static final String COLUMN_IMAGE_MAINBLOB = "image_mainBlob";  //BLOB
        public static final String COLUMN_IMAGE_POSTERBLOB = "image_posterBlob";  //BLOB

        public static Uri buildImageUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    //봉사정보
    public static final class VoluntaryEntry implements BaseColumns {

        //Voluntary테이블에 연결되는 CONTENT_URI
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_VOLUNTARY).build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VOLUNTARY;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_VOLUNTARY;

        public static final String TABLE_NAME = "voluntary";

        //Todo: 찜여부 컬럼 추가
        //컬럼속성
        public static final String COLUMN_VOLUNTARY_ID = "voluntary_id";  //INTEGER
        public static final String COLUMN_VOLUNTARY_TITLE = "voluntary_title";  //TEXT  제목
        public static final String COLUMN_VOLUNTARY_SUMMARY = "voluntary_summary";  //TEXT  요약
        public static final String COLUMN_VOLUNTARY_CONTENT = "voluntary_content";  //TEXT  상세내용
        public static final String COLUMN_VOLUNTARY_CONTENTETC = "voluntary_contentEtc";  //TEXT  기타내용
        public static final String COLUMN_VOLUNTARY_ADDRESS = "voluntary_address";  //TEXT  장소
        public static final String COLUMN_VOLUNTARY_APPROVAL = "voluntary_approval";  //TEXT  인증서 발급여부
        public static final String COLUMN_VOLUNTARY_LINK = "voluntary_link";  //TEXT 링크
        public static final String COLUMN_VOLUNTARY_DATE_RECRUIT_START = "voluntary_dateRecruitStart";  //TEXT  모집기간 시작
        public static final String COLUMN_VOLUNTARY_DATE_RECRUIT_END = "voluntary_dateRecruitEnd";  //TEXT  모집기간 끝
        public static final String COLUMN_VOLUNTARY_DATE_REAL_START = "voluntary_dateStart";  //TEXT  봉사기간 시작
        public static final String COLUMN_VOLUNTARY_DATE_REAL_END = "voluntary_dateEnd";  //TEXT  봉사기간 끝
        public static final String COLUMN_VOLUNTARY_TIME = "voluntary_time";  //INTEGER  봉사시간
        public static final String COLUMN_VOLUNTARY_MAINIMAGEURL = "voluntary_mainImageURL";  //TEXT  메인 이미지 url -> 로딩용
        public static final String COLUMN_VOLUNTARY_POSTERIMAGEURL = "voluntary_posterImageURL";  //TEXT  포스터 이미지 url  -> 로딩용
        public static final String COLUMN_VOLUNTARY_INCENTIVE = "voluntary_incentive";  //TEXT  활동혜택
        public static final String COLUMN_VOLUNTARY_REQUIREMENT = "voluntary_require";  //TEXT  지원가능 조건
        public static final String COLUMN_VOLUNTARY_RECRUIT_PEOPLE_TOTAL = "voluntary_recruit_people_total";  //INTEGER  모집인원
        public static final String COLUMN_VOLUNTARY_RECRUIT_PEOPLE_CURRENT = "voluntary_recruit_people_current";  //INTEGER  현재모집인원
        public static final String COLUMN_VOLUNTARY_STATUS = "voluntary_status";  //TEXT  현재상태 -> boolean으로 변경요청
        public static final String COLUMN_VOLUNTARY_CLERKNAME = "voluntary_clerkName";  //TEXT  담당자 이름
        public static final String COLUMN_VOLUNTARY_CLERKCALL = "voluntary_clerkCall";  //TEXT  담당자 전화
        public static final String COLUMN_VOLUNTARY_CLERKEMAIL = "voluntary_clerkEmail";  //TEXT  담당자 이메일
        public static final String COLUMN_VOLUNTARY_CLERKLINK = "voluntary_clerkLink";  //TEXT  담당자 링크
        public static final String COLUMN_VOLUNTARY_ORIGANIZATIONID = "voluntary_origanizationId";  //INTEGER  기관 id
        public static final String COLUMN_VOLUNTARY_REGIONID = "voluntary_regioinId";  //INTEGER  활동지역 id (검색시 사용)
        public static final String COLUMN_VOLUNTARY_SCHOOLID = "voluntary_schoolId";  //INTEGER  학교 id (검색시 사용)
        public static final String COLUMN_VOLUNTARY_CATEGORYID = "voluntary_categoryId";  //TEXT 카테고리 id (검색시 사용)
        public static final String COLUMN_VOLUNTARY_BTIMEID = "voluntary_btimeId";  //TEXT  봉사시간 id (검색시 사용)
        public static final String COLUMN_VOLUNTARY_UPDATEAT = "voluntary_updateAt";  //TEXT  DB 업데이트 판

        //api vserson2용
//        public static final String COLUMN_VOLUNTARY_ID = "voluntary_id";  //INTEGER
//        public static final String COLUMN_VOLUNTARY_TITLE = "voluntary_title";  //TEXT  제목
//        public static final String COLUMN_VOLUNTARY_DATE_RECRUIT_START = "voluntary_dateRecruitStart";  //TEXT  모집기간 시작
//        public static final String COLUMN_VOLUNTARY_DATE_RECRUIT_END = "voluntary_dateRecruitEnd";  //TEXT  모집기간 끝
//        public static final String COLUMN_VOLUNTARY_DATE_REAL_START = "voluntary_dateRealStart";  //TEXT  봉사기간 시작
//        public static final String COLUMN_VOLUNTARY_DATE_REAL_END = "voluntary_dateRealEnd";  //TEXT  봉사기간 끝
//        public static final String COLUMN_VOLUNTARY_TIME = "voluntary_time";  //INTEGER  봉사시간
//        public static final String COLUMN_VOLUNTARY_ADDRESS = "voluntary_address";  //TEXT  주소
//        public static final String COLUMN_VOLUNTARY_APPROVAL = "voluntary_approval";  //boolean  인증서 발급여부
//        public static final String COLUMN_VOLUNTARY_MAINIMAGEURL = "voluntary_mainImageURL";  //TEXT  메인 이미지 url -> 로딩용
//        public static final String COLUMN_VOLUNTARY_POSTERIMAGEURL = "voluntary_posterImageURL";  //TEXT  포스터 이미지 url  -> 로딩용
//        public static final String COLUMN_VOLUNTARY_LINK = "voluntary_link";  //TEXT 관련링크
//        public static final String COLUMN_VOLUNTARY_REQUIREMENT = "voluntary_requirement";  //TEXT  지원가능 조건
//        public static final String COLUMN_VOLUNTARY_RECRUIT_PEOPLE_TOTAL = "voluntary_recruit_people_total";  //INTEGER  모집인원
//        public static final String COLUMN_VOLUNTARY_RECRUIT_PEOPLE_CURRENT = "voluntary_recruit_people_current";  //INTEGER  현재모집인원
//        public static final String COLUMN_VOLUNTARY_CLERKNAME = "voluntary_clerkName";  //TEXT  담당자 이름
//        public static final String COLUMN_VOLUNTARY_CLERKCALL = "voluntary_clerkCall";  //TEXT  담당자 전화
//        public static final String COLUMN_VOLUNTARY_CLERKEMAIL = "voluntary_clerkEmail";  //TEXT  담당자 이메일
//        public static final String COLUMN_VOLUNTARY_CLERKLINK = "voluntary_clerkLink";  //TEXT  담당자 링크
//        public static final String COLUMN_VOLUNTARY_STATUS = "voluntary_status";  //TEXT  현재상태 -> boolean으로 변경요청
//        public static final String COLUMN_VOLUNTARY_CONTENT = "voluntary_content";  //TEXT  상세내용
//        public static final String COLUMN_VOLUNTARY_INCENTIVE = "voluntary_incentive";  //TEXT  활동혜택
//        public static final String COLUMN_VOLUNTARY_ORGANIZATION = "voluntary_organization";  //TEXT  기관
//        public static final String COLUMN_VOLUNTARY_CATEGORY = "voluntary_category";  //TEXT 카테고리(검색시 사용)
//        public static final String COLUMN_VOLUNTARY_BTIME = "voluntary_btime";  //TEXT  봉사시간 (검색시 사용)
//        public static final String COLUMN_VOLUNTARY_REGION = "voluntary_regioin";  //TEXT  활동지역 (검색시 사용)
//        public static final String COLUMN_VOLUNTARY_SCHOOL = "voluntary_school";  //INTEGER  학교 (검색시 사용)

        public static final String[] PROJECTION_ALL = {COLUMN_VOLUNTARY_ID, COLUMN_VOLUNTARY_TITLE, COLUMN_VOLUNTARY_SUMMARY,
                COLUMN_VOLUNTARY_CONTENT, COLUMN_VOLUNTARY_CONTENTETC, COLUMN_VOLUNTARY_ADDRESS, COLUMN_VOLUNTARY_APPROVAL,
                COLUMN_VOLUNTARY_LINK, COLUMN_VOLUNTARY_DATE_RECRUIT_START, COLUMN_VOLUNTARY_DATE_RECRUIT_END, COLUMN_VOLUNTARY_DATE_REAL_START,
                COLUMN_VOLUNTARY_DATE_REAL_END, COLUMN_VOLUNTARY_TIME, COLUMN_VOLUNTARY_MAINIMAGEURL, COLUMN_VOLUNTARY_POSTERIMAGEURL,
                COLUMN_VOLUNTARY_INCENTIVE, COLUMN_VOLUNTARY_REQUIREMENT, COLUMN_VOLUNTARY_RECRUIT_PEOPLE_TOTAL, COLUMN_VOLUNTARY_RECRUIT_PEOPLE_CURRENT,
                COLUMN_VOLUNTARY_STATUS, COLUMN_VOLUNTARY_CLERKNAME, COLUMN_VOLUNTARY_CLERKCALL, COLUMN_VOLUNTARY_CLERKEMAIL, COLUMN_VOLUNTARY_CLERKLINK,
                COLUMN_VOLUNTARY_ORIGANIZATIONID, COLUMN_VOLUNTARY_REGIONID, COLUMN_VOLUNTARY_SCHOOLID, COLUMN_VOLUNTARY_CATEGORYID, COLUMN_VOLUNTARY_BTIMEID,
                COLUMN_VOLUNTARY_UPDATEAT
        };

        //COLUMN_VOLUNTARY_ID를 기준으로 정렬
        public static final String SORT_ORDER_DEFAULT = COLUMN_VOLUNTARY_ID + " DESC";

        public static Uri buildVoluntaryUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
