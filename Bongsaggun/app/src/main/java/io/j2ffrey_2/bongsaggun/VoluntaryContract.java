package io.j2ffrey_2.bongsaggun;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by han on 2015-10-28.
 * VoluntaryProvider에서 필요한 상수값을 지정해두는 클래스
 * 외부에서 Provider를 사용하기 위해 필요한 값들이 저장
 * Provider에 접근하기 위한 API라고 생각하면 편하다
 */
public class VoluntaryContract {

    /*
    VoluntaryProvider의 AUTHORITY
    다른 프로바이더와의 충돌을 피하기 위해 "Android 패키지이름 + 앱이름"을 추천
    */
    public static final String CONTENT_AUTHORITY = "io.j2ffrey_2.bongsaggun.provider";

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

    //학교
    public static final class SchoolEntry implements BaseColumns {

        //School테이블에 연결되는 CONTENT_URI
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_SCHOOL).build();

        //
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCHOOL;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SCHOOL;

        public static final String TABLE_NAME = "school";

        //컬럼속성
        public static final String COLUMN_SCHOOL_ID = "school_id";  //INTEGER
        public static final String COLUMN_SCHOOL_NAME = "school_name";  //TEXT

        public static final String[] PROJECTION_ALL = { COLUMN_SCHOOL_ID, COLUMN_SCHOOL_NAME };

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

        public static Uri buildRegionUri(long id) {
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
        public static final String COLUMN_IMAGE_ID = "image_id";  //INTEGER
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

        //컬럼속성
        public static final String COLUMN_VOLUNTARY_ID = "voluntary_id";  //INTEGER
        public static final String COLUMN_VOLUNTARY_CONTENT = "voluntary_content";  //TEXT  상세내용
        public static final String COLUMN_VOLUNTARY_DATERECRUITSTART = "voluntary_dateRecruitStart";  //TEXT  모집기간 시작
        public static final String COLUMN_VOLUNTARY_DATERECRUITEND = "voluntary_dateRecruitEnd";  //TEXT  모집기간 끝
        public static final String COLUMN_VOLUNTARY_DATESTART = "voluntary_dateStart";  //TEXT  봉사기간 시작
        public static final String COLUMN_VOLUNTARY_DATEEND = "voluntary_dateEnd";  //TEXT  봉사기간 끝
        public static final String COLUMN_VOLUNTARY_IMAGEID = "voluntary_mainImageId";  //INTEGER  이미지 id -> 이미지 테이블이랑 relationship
        public static final String COLUMN_VOLUNTARY_MAINIMAGEURL = "voluntary_mainImageURL";  //TEXT  메인 이미지 url -> 로딩용
        public static final String COLUMN_VOLUNTARY_POSTERIMAGEURL = "voluntary_posterImageURL";  //TEXT  포스터 이미지 url  -> 로딩용
        public static final String COLUMN_VOLUNTARY_PHONE = "voluntary_phone";  //TEXT  담당자 연락처
        public static final String COLUMN_VOLUNTARY_REGIONID = "voluntary_regioinId";  //INTEGER  활동지역 id
        public static final String COLUMN_VOLUNTARY_REQUIRE = "voluntary_require";  //TEXT  지원가능 조건
        public static final String COLUMN_VOLUNTARY_REQUIRESEX = "voluntary_requireSex";  //TEXT  지원가능 성별
        public static final String COLUMN_VOLUNTARY_SCHOOLID = "voluntary_schoolId";  //INTEGER  학교 id (검색시 사용)
        public static final String COLUMN_VOLUNTARY_TIME = "voluntary_time";  //TEXT  봉사시간
        public static final String COLUMN_VOLUNTARY_TITLE = "voluntary_title";  //TEXT  봉사제목
        public static final String COLUMN_VOLUNTARY_UPDATEAT = "voluntary_updateAt";  //TEXT  DB 업데이트 판

        public static Uri buildVoluntaryUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
